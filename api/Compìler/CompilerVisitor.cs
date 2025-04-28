using analyzer;
using Antlr4.Runtime.Misc;
using System.Globalization;
using System.Text;
using Antlr4.Runtime.Tree;
using Microsoft.Extensions.Logging.Console;


public class CompilerVisitor : LanguageBaseVisitor<Object?>
{

    public ArmGenerator c = new ArmGenerator();
    private String? continueLabel = null;
    private String? breakLabel = null;
    private String? returnLabel = null;  
    public CompilerVisitor()
    {
        
    }

    public override Object? VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var dclFuera in context.dclFuera())
        {
            Visit(dclFuera);
        }

        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }


        return null;
    }

    // VisitDeclaracionExplicita
    public override Object? VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    { 
        var varName = context.ID().GetText();
        c.Comment("Variable explícita: " + varName);

        Visit(context.expresion());

        var value = c.PopObject(Register.X0);     
        c.Push(Register.X0);                       
        c.PushObject(c.CloneObject(value));        
        c.TagObject(varName);                      

        return null;
    }

    // VisitDeclaracionPorDefecto
    public override object? VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        var varName = context.ID().GetText();
        var tipo = context.tipoDeclaracion().GetText();

        c.Comment($"Declaración por defecto: {varName} ({tipo})");

        StackObject obj = tipo switch
        {
            "int" => c.IntObject(),
            "float64" => c.FloatObject(),
            "string" => c.StringObject(),
            "rune" => c.RuneObject(),
            "bool" => c.BoolObject(),
            _ => throw new NotImplementedException(),
        };

        switch (obj.Type)
        {
            case StackObject.StackObjectType.Int:
            case StackObject.StackObjectType.Rune:
            case StackObject.StackObjectType.Bool:
                c.Mov(Register.X0, 0);
                c.Push(Register.X0);
                break;

            case StackObject.StackObjectType.Float:
                c.Mov(Register.X0, 0);
                c.Fmov(Register.D0, Register.X0);
                c.Push(Register.X0);
                break;

            case StackObject.StackObjectType.String:
                List<byte> emptyString = Utils.StringToByteArray("");
                c.Push(Register.HP);
                foreach (var charCode in emptyString)
                {
                    c.Mov("w0", charCode);
                    c.Strb("w0", Register.HP);
                    c.Mov(Register.X0, 1);
                    c.Add(Register.HP, Register.HP, Register.X0);
                }
                c.Mov("w0", 0);
                c.Strb("w0", Register.HP);
                c.Mov(Register.X0, 1);
                c.Add(Register.HP, Register.HP, Register.X0);
                break;
        }

        c.PushObject(obj);
        c.TagObject(varName);

        return null;
    }

    // VisitDeclaracionImplicita
    public override object? VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        var varName = context.ID().GetText();
        c.Comment($"Declaración implícita: {varName}");

        Visit(context.expresion());

        var obj = c.PopObject(Register.X0);
        c.Push(Register.X0);
        c.PushObject(c.CloneObject(obj));
        c.TagObject(varName);

        return null;
    }


    // VisitExprStmt
    public override Object? VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        c.Comment("Expression statement");
        Visit(context.expresion());
        c.Comment("Popping value to discard ");
        c.PopObject(Register.X0);
        return null;
    }

    // VisitPrintStmt
    public override Object? VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {
        c.Comment("Print statement");
        var exprs = context.expresion();
        for (int i = 0; i < exprs.Length; i++)
        {
            Visit(exprs[i]);
            var isDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
            var value = c.PopObject(isDouble ? Register.D0 : Register.X0);
            
            switch (value.Type)
            {
                case StackObject.StackObjectType.Int:
                    c.PrintInt(Register.X0);
                    break;
                case StackObject.StackObjectType.String:
                    c.PrintString(Register.X0);
                    break;
                case StackObject.StackObjectType.Float:
                    c.PrintFloat();
                    break;
                case StackObject.StackObjectType.Rune:
                    c.PrintRune(Register.X0);
                    break;
                case StackObject.StackObjectType.Bool:
                    c.PrintBool(Register.X0);
                    break;
                case StackObject.StackObjectType.Array:
                    string elementTypeStr = value.ElementType switch
                    {
                        StackObject.StackObjectType.Int => "Int",
                        StackObject.StackObjectType.Float => "Float",
                        StackObject.StackObjectType.String => "String",
                        StackObject.StackObjectType.Rune => "Rune",
                        StackObject.StackObjectType.Bool => "Bool",
                        _ => throw new Exception($"Tipo de elemento no soportado: {value.ElementType}")
                    };
                    
                    c.PrintArray(Register.X0, elementTypeStr);
                    break;
            }
        }
        c.PrintNewLine();
        return null;
    }

    // VisitIdentifier
    public override Object? VisitIdentifier(LanguageParser.IdentifierContext context)
    {   
        var id = context.ID().GetText();
        c.Comment("Identifier: " + id);

        var (offset, obj) = c.GetObject(id);
        c.Mov(Register.X0, offset);
        c.Add(Register.X0, Register.SP, Register.X0);
        c.Ldr(Register.X0, Register.X0);

        c.Push(Register.X0);

        var newObject = c.CloneObject(obj);
        newObject.Id = null;
        c.PushObject(newObject);


        return null;
    }
    


    // VisitParens
    public override Object? VisitParens(LanguageParser.ParensContext context)
    {   
        return Visit(context.expresion());
    }

    // VisitBlockStmt
    public override Object? VisitBlockStmt(LanguageParser.BlockStmtContext context)
    {
        c.Comment("Block statement");
        c.NewScope();

        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }

        int bytesRemove = c.endScope();

        if (bytesRemove  > 0)
        {
            c.Comment("Removing " + bytesRemove + " bytes from stack");
            c.Mov(Register.X0, bytesRemove);
            c.Add(Register.SP, Register.SP, Register.X0);
            c.Comment("Stack pointer adjusted");
        }

        return null;
    }

     // VisitNegate
    public override object? VisitNegate(LanguageParser.NegateContext context)
    {
        c.Comment("Negación unaria");

        Visit(context.expresion());

        var value = c.PopObject(Register.X0);

        if (value.Type == StackObject.StackObjectType.Int)
        {
            c.Neg(Register.X0, Register.X0);
            c.Push(Register.X0);
            c.PushObject(c.IntObject());
        }
        
        return null;
    }

    // VisitNumber
    public override Object? VisitNumber(LanguageParser.NumberContext context)
    {
        var value = context.INT().GetText();
        c.Comment("Constant: " + value);
        var intObject = c.IntObject();
        c.PushConstant(intObject, int.Parse(value));
        return null;
    }

    // VisitFloat

    public override Object? VisitFloat(LanguageParser.FloatContext context)
    {
        var value = context.FLOAT().GetText();
        c.Comment("Float constant: " + value);
        var floatObject = c.FloatObject();
        c.PushConstant(floatObject, double.Parse(value));
        return null;
    }

    //VisitBoolean
    public override object? VisitBoolean(LanguageParser.BooleanContext context)
    {
        var val = context.BOOL().GetText() == "true";
        c.Comment($"Boolean constant: {val}");
        var boolObj = c.BoolObject();
        c.PushConstant(boolObj, val);
        return null;
    }

   
    // VisitString
   public override Object? VisitString(LanguageParser.StringContext context)
    {
        var value = context.STRING().GetText().Trim('"');
        c.Comment("String constant: " + value);
        var stringObject = c.StringObject();
        c.PushConstant(stringObject, value);
        return null;
    }

    // VisitRune
   public override object? VisitRune(LanguageParser.RuneContext context)
    {
        var content = context.RUNE().GetText(); 
        char runeChar = content[1]; 
        c.Comment($"Rune constant: {runeChar}");
        var runeObj = c.RuneObject();
        c.PushConstant(runeObj, (int)runeChar);
        return null;
    }


    // VisitNil
    public override Object? VisitNil(LanguageParser.NilContext context)
    {
      return null;   
    }

    // VisitMulDivMod
    public override Object? VisitMulDivMod(LanguageParser.MulDivModContext context)
    {
        var op = context.op.Text;
        c.Comment($"Operación: {op}");

        Visit(context.expresion(0));
        Visit(context.expresion(1));

        var isRightDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var right = c.PopObject(isRightDouble ? Register.D1 : Register.X0);
        var isLeftDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var left = c.PopObject(isLeftDouble ? Register.D0 : Register.X1);

        if (isLeftDouble || isRightDouble)
        {
            if (!isLeftDouble) c.Scvtf(Register.D1, Register.X1);
            if (!isRightDouble) c.Scvtf(Register.D0, Register.X0);

            if (op == "*") c.Fmul(Register.D0, Register.D0, Register.D1);
            else if (op == "/") c.Fdiv(Register.D0, Register.D1, Register.D0);

            c.Comment("Pushing double result");
            c.Push(Register.D0);
            c.PushObject(c.CloneObject(isLeftDouble ? left : right));

            return null;
        }
        if (left.Type == StackObject.StackObjectType.Int && right.Type == StackObject.StackObjectType.Int)
        {
            if (op == "*") c.Mul(Register.X0, Register.X0, Register.X1);
            else if (op == "/") c.Div(Register.X0, Register.X0, Register.X1);
            else if (op == "%") c.Mod(Register.X0, Register.X0, Register.X1);

            c.Push(Register.X0);
            c.PushObject(c.IntObject());
        }
        else if (left.Type == StackObject.StackObjectType.Float || right.Type == StackObject.StackObjectType.Float)
        {
            throw new NotImplementedException("Operación con floats no implementada.");
        }

        return null;
    }


    // VisitAddSub
    public override Object? VisitAddSub(LanguageParser.AddSubContext context)
    {
        var op = context.op.Text;
        c.Comment($"Operación: {op}");

        Visit(context.expresion(0));
        Visit(context.expresion(1));

        var isRightDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var right = c.PopObject(isRightDouble ? Register.D1 : Register.X0);
        var isLeftDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var left = c.PopObject(isLeftDouble ? Register.D0 : Register.X1);

        if (isLeftDouble || isRightDouble)
        {
            if (!isLeftDouble) c.Scvtf(Register.D1, Register.X1);
            if (!isRightDouble) c.Scvtf(Register.D0, Register.X0);

            if (op == "+") c.Fadd(Register.D0, Register.D0, Register.D1);
            else if (op == "-") c.Fsub(Register.D0, Register.D1, Register.D0);

            c.Comment("Pushing double result");
            c.Push(Register.D0);
            c.PushObject(c.CloneObject(isLeftDouble ? left : right));


            return null;
        }
        else if (left.Type == StackObject.StackObjectType.Int && right.Type == StackObject.StackObjectType.Int)
        {
            if (op == "+") c.Add(Register.X0, Register.X0, Register.X1);
            else if (op == "-") c.Sub(Register.X0, Register.X1, Register.X0);

            c.Push(Register.X0);
            c.PushObject(c.IntObject());
        }
        else if (left.Type == StackObject.StackObjectType.String && right.Type == StackObject.StackObjectType.String && op == "+")
        {
            c.ConcatStrings("x1", "x0");
            c.Push("x0");
            c.PushObject(c.StringObject());
        }

        return null;
    }

    //VisitAssignVar
    public override Object? VisitAssignVar(LanguageParser.AssignVarContext context)
    {
        string varName = context.ID().GetText();
        string op = context.op.Text;
        
        c.Comment("Assigning to variable: " + varName + " with operator " + op);

        Visit(context.expresion());

        var valueObject = c.PopObject(Register.X0);
        var (offset, varObject) = c.GetObject(varName);

        // dirección de la variable
        c.Mov(Register.X1, offset);
        c.Add(Register.X1, Register.SP, Register.X1);

        if (op == "=")
        {
            // Asignación directa
            c.Str(Register.X0, Register.X1);
        }
        else
        {
            // valor actual de la variable
            c.Ldr(Register.X2, Register.X1);

            if (op == "+=")
            {
                c.Add(Register.X0, Register.X2, Register.X0);
            }
            else if (op == "-=")
            {
                c.Sub(Register.X0, Register.X2, Register.X0);
            }

            c.Str(Register.X0, Register.X1);
        }

        varObject.Type = valueObject.Type;

        c.Push(Register.X0);
        c.PushObject(c.CloneObject(varObject));

        return null;
    }
    
    // VisitRelational
    public override object? VisitRelational(LanguageParser.RelationalContext context)
    {
        var op = context.op.Text;
        c.Comment($"Operación relacional: {op}");

        Visit(context.expresion(0));
        Visit(context.expresion(1));

        var isRightDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var right = c.PopObject(isRightDouble ? Register.D1 : Register.X0);
        var isLeftDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var left = c.PopObject(isLeftDouble ? Register.D0 : Register.X1);

        bool usaFlotantes = (left.Type == StackObject.StackObjectType.Float || right.Type == StackObject.StackObjectType.Float);

        string trueLabel = c.NewLabel("rel_true");
        string endLabel = c.NewLabel("rel_end");

        if (usaFlotantes)
        {
            c.Comment("Comparando como flotantes");
            c.Fcmp(Register.D0, Register.D1); 
        }
        else
        {
            c.Comment("Comparando como enteros/runes");
            c.Cmp(Register.X1, Register.X0); 
        }

        switch (op)
        {
            case "<":
                c.Blt(trueLabel);
                break;
            case "<=":
                c.Ble(trueLabel);
                break;
            case ">":
                c.Bgt(trueLabel);
                break;
            case ">=":
                c.Bge(trueLabel);
                break;
            case "==":
                c.Beq(trueLabel);
                break;
            case "!=":
                c.Bne(trueLabel);
                break;
            default:
                throw new Exception($"Operador relacional no soportado: {op}");
        }

        // Falso
        c.Mov(Register.X0, 0);
        c.B(endLabel);

        // Verdadero
        c.Label(trueLabel);
        c.Mov(Register.X0, 1);

        // Final
        c.Label(endLabel);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());

        return null;
    }

    // VisitEquality
    public override object? VisitEquality(LanguageParser.EqualityContext context)
    {
        var op = context.op.Text;
        c.Comment($"Operación de igualdad: {op}");

        Visit(context.expresion(0));
        Visit(context.expresion(1));


        var isRightDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var right = c.PopObject(isRightDouble ? Register.D1 : Register.X1);
        var isLeftDouble = c.TopObject().Type == StackObject.StackObjectType.Float;
        var left = c.PopObject(isLeftDouble ? Register.D0 : Register.X0);

        string trueLabel = c.NewLabel("eq_true");
        string endLabel = c.NewLabel("eq_end");

        switch (left.Type)
        {
            case StackObject.StackObjectType.Int:
            case StackObject.StackObjectType.Rune:
            case StackObject.StackObjectType.Bool:
                c.Cmp(Register.X0, Register.X1);
                if (op == "==")
                    c.Beq(trueLabel);
                else
                    c.Bne(trueLabel);
                break;

            case StackObject.StackObjectType.Float:
                c.Comment("Comparar flotantes");
                c.Fcmp(Register.D0, Register.D1);
                if (op == "==")
                    c.Beq(trueLabel);
                else
                    c.Bne(trueLabel);
                break;

            case StackObject.StackObjectType.String:
                c.Comment("Comparar strings con función externa");
                c.UseStdLib("string_equals");

                c.Mov("x0", Register.X0);
                c.Mov("x1", Register.X1);
                c.Bl("string_equals");

                if (op == "==")
                    c.Cmp("x0", "#1");
                else
                    c.Cmp("x0", "#0");

                c.Beq(trueLabel);
                break;

            default:
                throw new Exception($"Tipo no soportado en igualdad: {left.Type}");
        }

        // Falso
        c.Mov(Register.X0, 0);
        c.B(endLabel);

        // Verdadero
        c.Label(trueLabel);
        c.Mov(Register.X0, 1);

        // Final
        c.Label(endLabel);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());

        return null;
    }

    // VisitLogicalAnd
    public override object? VisitLogicalAnd(LanguageParser.LogicalAndContext context)
    {
        string falseLabel = c.NewLabel("and_false");
        string endLabel = c.NewLabel("and_end");

        c.Comment("Lado izquierdo del AND");
        Visit(context.expresion(0));
        c.PopObject(Register.X0);

        // caso falso, salta al falseLabel
        c.Cmp(Register.X0, "#0");
        c.Beq(falseLabel);

        c.Comment("Lado derecho del AND");
        Visit(context.expresion(1));
        c.PopObject(Register.X0);
        c.Cmp(Register.X0, "#0");
        c.Beq(falseLabel);

        // Ambos son true
        c.Mov(Register.X0, 1);
        c.B(endLabel);

        c.Label(falseLabel);
        c.Mov(Register.X0, 0);

        c.Label(endLabel);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());

        return null;
    }

    // VisitLogicalOr
    public override object? VisitLogicalOr(LanguageParser.LogicalOrContext context)
    {
        string trueLabel = c.NewLabel("or_true");
        string endLabel = c.NewLabel("or_end");

        c.Comment("Lado izquierdo del OR");
        Visit(context.expresion(0));
        c.PopObject(Register.X0);

        c.Cmp(Register.X0, "#1");
        c.Beq(trueLabel);

        c.Comment("Lado derecho del OR");
        Visit(context.expresion(1));
        c.PopObject(Register.X0);
        c.Cmp(Register.X0, "#1");
        c.Beq(trueLabel);

        c.Mov(Register.X0, 0);
        c.B(endLabel);

        c.Label(trueLabel);
        c.Mov(Register.X0, 1);

        c.Label(endLabel);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());

        return null;
    }


    // VisitLogicalNot
    public override object? VisitLogicalNot(LanguageParser.LogicalNotContext context)
    {
        c.Comment("Operador lógico NOT");
        Visit(context.expresion());
        c.PopObject(Register.X0);

        c.Cmp(Register.X0, "#0");
        string trueLabel = c.NewLabel("not_true");
        string endLabel = c.NewLabel("not_end");

        c.Beq(trueLabel);

        c.Mov(Register.X0, 0); // true a false
        c.B(endLabel);

        c.Label(trueLabel);
        c.Mov(Register.X0, 1); // false a true

        c.Label(endLabel);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());

        return null;
    }


    // VisitIncrementeDecrement
    public override object? VisitIncrementDecrement(LanguageParser.IncrementDecrementContext context)
    {
        var id = context.ID().GetText();
        var op = context.op.Text;

        c.Comment($"Increment/Decrement variable: {id} {op}");

        var (offset, obj) = c.GetObject(id);

        if (obj.Type != StackObject.StackObjectType.Int)
            throw new Exception("Increment/Decrement sólo soportado para enteros");

        c.Ldr(Register.X0, Register.SP, offset); 

        if (op == "++")
        {
            c.Add(Register.X0, Register.X0, "#1");
        }
        else if (op == "--")
        {
            c.Sub(Register.X0, Register.X0, "#1");
        }

        c.Str(Register.X0, Register.SP, offset); 
        return null;
    }



    //VisitEmebbedFuncAtoi
    public override Object? VisitEmebbedFuncAtoi(LanguageParser.EmebbedFuncAtoiContext context)
    {
       return null;
    }

    //VisitEmbebbedFuncParseFloat
    public override Object? VisitEmebbedFuncParseFloat(LanguageParser.EmebbedFuncParseFloatContext context)
    {
        return null;
    }

    // VisitEmebbedFuncTypeOf

    public override Object? VisitEmebbedFuncTypeOf(LanguageParser.EmebbedFuncTypeOfContext context)
    {
        return null;
    }

    // VisitDeclaracionSliceVacio
    public override Object? VisitDeclaracionSliceVacio(LanguageParser.DeclaracionSliceVacioContext context)
    {
        return null;
    }

    // VisitDeclaracionSliceValores
    public override Object? VisitDeclaracionSliceValores(LanguageParser.DeclaracionSliceValoresContext context)
    {
        return null;
    }       

    // VisitSliceLiteral
    public override Object? VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
    {
        return null;
    }
    

    //VisitSliceFuncIndex
    public override Object? VisitSliceFuncIndex(LanguageParser.SliceFuncIndexContext context)
    {
        return null;
    }


    // VisitSliceStringFuncJoin
    public override Object? VisitSliceStringFuncJoin(LanguageParser.SliceStringFuncJoinContext context)
    {
        return null;
    }


    // VisitSliceLenFunc
    public override Object? VisitSliceLenFunc(LanguageParser.SliceLenFuncContext context)
    {
        return null;
    }


    // VisitSliceAppendFunc
    public override Object? VisitSliceAppendFunc(LanguageParser.SliceAppendFuncContext context)
    {
        return null;
    }

    // VisitSliceAccess
    public override Object? VisitSliceAccess(LanguageParser.SliceAccessContext context)
    {
        return null;
    }

    // VisitAssignSlice
    public override Object? VisitAssignSlice(LanguageParser.AssignSliceContext context)
    {
        return null;
    }

    // VisitIfStmt
    public override object? VisitIfStmt(LanguageParser.IfStmtContext context)
    {
        c.Comment("If statement");

        Visit(context.expresion());

        c.PopObject(Register.X0);

        bool hayElse = context.sentencia().Length == 2;
        string elseLabel = c.NewLabel("if_else");
        string endLabel = c.NewLabel("if_end");

        c.Cbz(Register.X0, hayElse ? elseLabel : endLabel);

        // Bloque verdadero
        Visit(context.sentencia(0));
        c.B(endLabel);

        if (hayElse)
        {
            // Bloque falso
            c.Label(elseLabel);
            Visit(context.sentencia(1));
        }

        c.Label(endLabel);

        return null;
    }

    //VisitBreakStmt
    public override Object? VisitBreakStmt(LanguageParser.BreakStmtContext context)
    {
        c.Comment("Break statement");
        if (breakLabel != null)
        {
            c.B(breakLabel);
        }
        return null;
    }

    //VisitContinueStmt
    public override Object? VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
        c.Comment("Continue statement");
        if (continueLabel != null)
        {
            c.B(continueLabel);
        }

        return null;
    }

    // VisitReturnStmt
    public override Object? VisitReturnStmt(LanguageParser.ReturnStmtContext context)
    {
        return null;
    }

    // VisitSwitchStmt
    public override Object? VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
    {
        return null;
    }

    // VisitForWhileStmt
    public override Object? VisitForWhileStmt(LanguageParser.ForWhileStmtContext context)
    {
        c.Comment("For while statement");
        var startLabel = c.NewLabel("for_start");
        var endLabel = c.NewLabel("for_end");

        var prevContinueLabel = continueLabel;
        var prevBreakLabel = breakLabel;
        continueLabel = startLabel;
        breakLabel = endLabel;

        c.Label(startLabel);
        Visit(context.expresion());
        c.PopObject(Register.X0);
        c.Cbz(Register.X0, endLabel);
        Visit(context.sentencia());
        c.B(startLabel);
        c.Label(endLabel);

        c.Comment("End of for while statement");
        continueLabel = prevContinueLabel;
        breakLabel = prevBreakLabel;

        return null;
    }


    // VisitForStmt
    public override object? VisitForStmt(LanguageParser.ForStmtContext context)
    {
        var startLabel = c.NewLabel("for_start");
        var condLabel = c.NewLabel("for_cond");
        var incrLabel = c.NewLabel("for_incr");
        var endLabel = c.NewLabel("for_end");

        var prevContinueLabel = continueLabel;
        var prevBreakLabel = breakLabel;
        continueLabel = incrLabel;
        breakLabel = endLabel;

        c.Comment("For clásico statement");
        c.NewScope();

        
        Visit(context.forInit());
        c.B(condLabel); 

        
        c.Label(startLabel);
        Visit(context.sentencia());

        
        c.Label(incrLabel);
        Visit(context.expresion(1));

        c.B(condLabel);

        
        c.Label(condLabel);
        Visit(context.expresion(0));
        c.PopObject(Register.X0);
        c.Cbz(Register.X0, endLabel);
        c.B(startLabel);

        
        c.Label(endLabel);
        c.Comment("End of for clásico");

        var bytesToRemove = c.endScope();
        if (bytesToRemove > 0)
        {
            c.Comment($"Removing {bytesToRemove} bytes from stack");
            c.Mov(Register.X0, bytesToRemove);
            c.Add(Register.SP, Register.SP, Register.X0);
            c.Comment("Stack pointer adjusted");
        }

        continueLabel = prevContinueLabel;
        breakLabel = prevBreakLabel;

        return null;
    }


    // VisitForRangeStmt
    public override Object? VisitForRangeStmt(LanguageParser.ForRangeStmtContext context)
    {
        return null;
    }


    // VisitCallee
    public override Object? VisitCallee(LanguageParser.CalleeContext context)
    {
        return null;
    }

    public Object? VisitCall(Invocable invocable, LanguageParser.ArgsContext context)
    {
        return null;

    }

    // VisitdeclaracionFuncForanea
    public override Object? VisitDeclaracionFuncForanea(LanguageParser.DeclaracionFuncForaneaContext context)
    {   
        return null;
    }


}

