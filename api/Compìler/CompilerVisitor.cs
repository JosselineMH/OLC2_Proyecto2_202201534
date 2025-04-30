using analyzer;
using Antlr4.Runtime.Misc;
using System.Globalization;
using System.Text;
using Antlr4.Runtime.Tree;
using Microsoft.Extensions.Logging.Console;
using System.Runtime.ExceptionServices;
using System.Linq.Expressions;

public class FunctionMetadata
{
    public int FrameSize;
    public StackObject.StackObjectType ReturnType;
}


public class CompilerVisitor : LanguageBaseVisitor<Object?>
{

    public ArmGenerator c = new ArmGenerator();
    private String? continueLabel = null;
    private String? breakLabel = null;
    private String? returnLabel = null;  
    private Dictionary<string, FunctionMetadata> functions = new Dictionary<string, FunctionMetadata>();
    private string? insideFunction = null;
    private int framePointerOffset = 0;
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

        if (insideFunction != null)
        {
            var localObject = c.GetFrameLocal(framePointerOffset);
            var valueObject = c.PopObject(Register.X0); // Pop the value as X0

            c.Mov(Register.X1, framePointerOffset * 8); // Move the offset to X1
            c.Sub(Register.X1, Register.FP, Register.X1); // Add the offset to the FP
            c.Str(Register.X0, Register.X1); // Store the value at the address

            localObject.Type = valueObject.Type;
            framePointerOffset++;
            
            return null;
        }
       
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
                    c.PrintSlice(value.ElementType);
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

        if (insideFunction != null)
        {
            c.Mov(Register.X0, obj.Offset * 8); // Move the offset to X0
            c.Sub(Register.X0, Register.FP, Register.X0); // Add the offset to FP to get the address
            c.Ldr(Register.X0, Register.X0); // Load the value from the address
            c.Push(Register.X0); // Push the value to the stack
            var cloneObject = c.CloneObject(obj); // Clone the object
            cloneObject.Id = null;
            c.PushObject(cloneObject); // Push the object to the stack
            return null;
        }


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
            if (op == "*") c.Mul(Register.X0, Register.X1, Register.X0);
            else if (op == "/") c.Div(Register.X0, Register.X1, Register.X0);
            else if (op == "%") c.Mod(Register.X0, Register.X1, Register.X0);

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

        if (insideFunction != null)
        {
            c.Mov(Register.X1, varObject.Offset * 8); 
            c.Sub(Register.X1, Register.FP, Register.X1); 
            c.Str(Register.X0, Register.X1);
            return null;
        }


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
    public override object? VisitEmebbedFuncAtoi(LanguageParser.EmebbedFuncAtoiContext context)
    {
        Visit(context.expresion());

        var obj = c.PopObject(Register.X0);

        if (obj.Type != StackObject.StackObjectType.String)
        {
            throw new Exception("Error: strconv.Atoi espera un argumento de tipo string.");
        }

        c.UseStdLib("string_to_integer");
        c.Bl("string_to_integer");

        c.Push(Register.X0); 
        c.PushObject(c.IntObject());

        return null;
    }



    //VisitEmbebbedFuncParseFloat
    public override Object? VisitEmebbedFuncParseFloat(LanguageParser.EmebbedFuncParseFloatContext context)
    {
        Visit(context.expresion());

        var obj = c.PopObject(Register.X0);

        if (obj.Type != StackObject.StackObjectType.String)
        {
            throw new Exception("Error: strconv.ParseFloat espera un argumento de tipo string.");
        }

        c.UseStdLib("string_to_float");

        c.Bl("string_to_float");

        c.Push(Register.D0); 
        c.PushObject(c.FloatObject());

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
        string id = context.ID().GetText();
        Visit(context.expresion());

        c.TagObject(id);

        return null;
    }   

    // VisitSliceLiteral
    public override object? VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
    {
        var sliceType = ResolveSliceType(context.tipoDeclaracion().GetText());
        var elements = context.expresion();
        var elementCount = elements.Length;

        c.Comment($"[Slice] Creating slice of type {sliceType} with {elementCount} elements");

        var baseAddress = AllocateSliceHeader(elementCount);
        FillSliceElements(elements, baseAddress);

        var sliceObject = c.SliceObject(sliceType);
        c.PushObject(sliceObject);

        return null;
    }

    private StackObject.StackObjectType ResolveSliceType(string typeStr) => typeStr switch
    {
        "int"     => StackObject.StackObjectType.Int,
        "float64" => StackObject.StackObjectType.Float,
        "string"  => StackObject.StackObjectType.String,
        "bool"    => StackObject.StackObjectType.Bool,
        "rune"    => StackObject.StackObjectType.Rune,
        _         => throw new Exception($"Unsupported slice type: {typeStr}")
    };

    private string AllocateSliceHeader(int count)
    {
        c.Push(Register.HP);              
        c.Mov(Register.X0, count);
        c.Str(Register.X0, Register.HP);  
        c.Mov(Register.X0, 8);
        c.Add(Register.HP, Register.HP, Register.X0); 

        c.Pop(Register.X1);  
        c.Push(Register.X1); 

        return Register.X1;
    }

    private void FillSliceElements(IReadOnlyList<LanguageParser.ExpresionContext> elements, string baseAddress)
    {
        for (int i = 0; i < elements.Count; i++)
        {
            c.Comment($"[Slice] Processing element {i}");

            Visit(elements[i]);
            c.PopObject(Register.X0); 

            c.Mov(Register.X2, 8);           
            c.Mov(Register.X3, i);
            c.Mul(Register.X3, Register.X3, Register.X2);
            c.Add(Register.X3, Register.X3, "8"); 
            c.Add(Register.X3, baseAddress, Register.X3);
            c.Str(Register.X0, Register.X3);      
        }

        var totalSize = elements.Count * 8;
        c.Mov(Register.X0, totalSize);
        c.Add(Register.HP, Register.HP, Register.X0); 
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
    
    public override object? VisitReturnStmt(LanguageParser.ReturnStmtContext context)
    {
        c.Comment("Return statement");

        if (context.expresion() == null)
        {
            if(returnLabel != null) c.B(returnLabel); 
            return null;
        }

        if (insideFunction == null) 
            throw new Exception("Return statement outside function");

        Visit(context.expresion()); 
        c.PopObject(Register.X0); 

        var frameSize = functions[insideFunction].FrameSize;
        var returnOffset = frameSize - 1;

        c.Mov(Register.X1, returnOffset * 8); 
        c.Sub(Register.X1, Register.FP, Register.X1); 
        c.Str(Register.X0, Register.X1); 

        if(returnLabel != null) c.B(returnLabel); 

        c.Comment("End of return statement");
        return null;
    }




    // VisitSwitchStmt
    public override object? VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
    {
        c.Comment("Switch statement");
        
        Visit(context.expresion());
        c.PopObject(Register.X9); 
        
        var endSwitchLabel = c.NewLabel("switch_end");
        var prevBreakLabel = breakLabel;
        breakLabel = endSwitchLabel;
        
        var caseCount = context.stmtCase().Length;
        
        for (int i = 0; i < caseCount; i++)
        {
            var caseContext = context.stmtCase(i);
            var nextCaseLabel = c.NewLabel($"case_{i+1}");
            
            c.Comment($"Case {i+1}");
            
            Visit(caseContext.expresion());
            c.PopObject(Register.X0);
            
            c.Cmp(Register.X9, Register.X0);
            c.Bne(nextCaseLabel);
            
            foreach (var stmt in caseContext.dcl())
            {
                Visit(stmt);
            }
            
            c.B(endSwitchLabel);
            c.Label(nextCaseLabel);
        }
        
        if (context.stmtDefault() != null)
        {
            c.Comment("Default case");
            foreach (var stmt in context.stmtDefault().dcl())
            {
                Visit(stmt);
            }
        }
        
        c.Label(endSwitchLabel);
        c.Comment("End of switch statement");
        
        breakLabel = prevBreakLabel;
        
        return null;
    }

    // VisitForWhileStmt
    public override Object? VisitForWhileStmt(LanguageParser.ForWhileStmtContext context)
    {
        c.Comment("For while statement");

        var condLabel = c.NewLabel("for_cond");
        var bodyLabel = c.NewLabel("for_body");
        var endLabel = c.NewLabel("for_end");

        var prevContinueLabel = continueLabel;
        var prevBreakLabel = breakLabel;

        continueLabel = condLabel;
        breakLabel = endLabel;

        c.Label(condLabel);
        Visit(context.expresion());
        c.PopObject(Register.X0);
        c.Cbz(Register.X0, endLabel); 
        c.B(bodyLabel); 

        c.Label(bodyLabel);
        Visit(context.sentencia());

        c.B(condLabel);

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


    //VisitCallee
    public override Object? VisitCallee(LanguageParser.CalleeContext context)
    {
        if (context.expresion() is not LanguageParser.IdentifierContext idContext) return null;
        string funcName = idContext.ID().GetText();
        var call = context.call()[0];
        if (call is not LanguageParser.CallContext callContext) return null;
        
        // Verificar si la función existe
        if (!functions.ContainsKey(funcName))
            throw new Exception($"Function '{funcName}' not declared");
        
        var postFuncCallLabel = c.GetLabel();
        int baseOffset = 2;
        int stackElementSize = 8;
        
        // Determinar el número de parámetros
        int paramCount = 0;
        if (callContext.args() != null && callContext.args().expresion() != null)
        {
            paramCount = callContext.args().expresion().Length;
        }
        
        // Ajustar el stack para la llamada
        c.Mov(Register.X0, baseOffset * stackElementSize);
        c.Sub(Register.SP, Register.SP, Register.X0);
        
        // Procesar los parámetros si existen
        if (paramCount > 0)
        {
            c.Comment("Visiting function parameters");
            foreach (var param in callContext.args().expresion())
            {
                Visit(param); // Visit the parameters
            }
        }
        
        // Calcular el valor del fp
        // Regresar el SP al inicio del frame
        c.Mov(Register.X0, stackElementSize * (baseOffset + paramCount));
        c.Add(Register.SP, Register.SP, Register.X0);
        
        // Calcular la posición donde se almacenará el FP
        c.Mov(Register.X0, stackElementSize);
        c.Sub(Register.X0, Register.SP, Register.X0); // En X0 se debería de almacenar el FP
        c.Adr(Register.X1, postFuncCallLabel); // Get the address of the function
        c.Push(Register.X1); // Push the address to the stack
        c.Push(Register.FP); // Guardar el FP anterior
        c.Add(Register.FP, Register.X0, Register.XZR); // Actualizar el FP
        
        // Alterar el SP al final del frame
        int frameSize = functions[funcName].FrameSize;
        c.Mov(Register.X0, (frameSize - 2) * stackElementSize); // Move the frame size to X0
        c.Sub(Register.SP, Register.SP, Register.X0); // Subtract the frame size from SP
        
        c.Comment("Calling function: " + funcName);
        c.Bl(funcName);
        c.Comment("Function call complete");
        c.SetLabel(postFuncCallLabel);
        
        // Manejar el valor de retorno si la función no es void
        if (functions[funcName].ReturnType != StackObject.StackObjectType.Undefined)
        {
            // Obtener el valor de retorno
            var returnOffset = frameSize - 1;
            c.Mov(Register.X4, returnOffset * stackElementSize); // Move the return offset to X4
            c.Sub(Register.X4, Register.FP, Register.X4); // Add the return offset to FP
            c.Ldr(Register.X4, Register.X4); // Load the return value from the frame pointer
        }
        
        // Regresar el FP al contexto de ejecución anterior
        c.Mov(Register.X1, stackElementSize);
        c.Sub(Register.X1, Register.FP, Register.X1); // Add the stack element size to SP
        c.Ldr(Register.FP, Register.X1); // Load the previous frame pointer
        
        // Regresar el SP al contexto de ejecución anterior
        c.Mov(Register.X0, stackElementSize * frameSize); // Move the frame size to X0
        c.Add(Register.SP, Register.SP, Register.X0); // Add the frame size to SP
        
        // Empujar el valor de retorno si la función no es void
        if (functions[funcName].ReturnType != StackObject.StackObjectType.Undefined)
        {
            // Regresar el valor de retorno
            c.Push(Register.X4); // Push the return value to the stack
            c.PushObject(new StackObject
            {
                Type = functions[funcName].ReturnType,
                Id = null,
                Offset = 0,
                Lenght = 8
            });
        }
        else
        {
            // Para funciones void, empujamos un valor nulo para mantener consistencia en la pila
            c.Mov(Register.X4, 0); // Valor nulo en X4
            c.Push(Register.X4); // Push el valor nulo a la pila
            c.PushObject(new StackObject
            {
                Type = StackObject.StackObjectType.Undefined,
                Id = null,
                Offset = 0,
                Lenght = 8
            });
        }
        
        c.Comment("End of function call: " + funcName);
        return null;
    }


    //VisitDeclaracionFuncForanea
    public override Object? VisitDeclaracionFuncForanea(LanguageParser.DeclaracionFuncForaneaContext context)
    {
        int baseOffset = 2;
        int paramsOffset = 0;
        
        // Manejo de parámetros (pueden ser 0)
        if (context.parametros() != null && context.parametros().ID() != null)
        {
            paramsOffset = context.parametros().ID().Length;
        }
        
        FrameVisitor frameVisitor = new FrameVisitor(baseOffset + paramsOffset);
        foreach (var dcl in context.dcl())
        {
            frameVisitor.Visit(dcl);
        }
        
        var frame = frameVisitor.Frame;
        int localOffset = frame.Count;
        int returnOffset = 1; // Siempre reservamos espacio para un valor de retorno, incluso para void
        int totalFrameSize = baseOffset + paramsOffset + localOffset + returnOffset;
        
        string funcName = context.ID().GetText();
        
        // Determinar el tipo de retorno de la función (puede ser void)
        StackObject.StackObjectType funcType;
        if (context.tipoDeclaracion() != null)
        {
            funcType = GetType(context.tipoDeclaracion().GetText());
        }
        else
        {
            // Si no hay tipo de declaración, es una función void
            funcType = StackObject.StackObjectType.Undefined;
        }
        
        Console.WriteLine("TOTAL FRAME: " + totalFrameSize);
        functions.Add(funcName, new FunctionMetadata
        {
            FrameSize = totalFrameSize,
            ReturnType = funcType
        });
        
        var prevInstructions = c.Instructions;
        c.Instructions = new List<string>();
        
        // Manejar los parámetros si existen
        var paramCounter = 0;
        if (context.parametros() != null && context.parametros().ID() != null)
        {
            for(int i = 0; i < context.parametros().ID().Length; i++)
            {
                c.PushObject(new StackObject
                {
                    Type = GetType(context.parametros().tipoFunc(i).GetText()),
                    Id = context.parametros().ID(i).GetText(),
                    Offset = paramCounter + baseOffset,
                    Lenght = 8
                });
                paramCounter++;
            }
        }
        
        foreach (FrameElement element in frame)
        {
            c.PushObject(new StackObject
            {
                Type = StackObject.StackObjectType.Undefined,
                Id = element.Name,
                Offset = element.Offset,
                Lenght = 8
            });
        }
        
        insideFunction = funcName;
        framePointerOffset = 0;
        returnLabel = c.GetLabel();
        
        c.Comment("Function declaration: " + funcName);
        c.Label(funcName);
        
        foreach(var dcl in context.dcl())
        {
            Visit(dcl);
        }
        
        // Generar el código para el retorno de la función
        c.Label(returnLabel);
        c.Add(Register.X0, Register.FP, Register.XZR);
        c.Ldr(Register.LR, Register.X0);
        c.Br(Register.LR);
        c.Comment("End of function: " + funcName);
        
        for(int i = 0; i < paramsOffset + localOffset; i++)
        {
            c.PopObject();
        }
        
        foreach (var instruccion in c.Instructions)
        {
            c.funcInstructions.Add(instruccion);
        }
        
        c.Instructions = prevInstructions;
        insideFunction = null;
        return null;
    }

    StackObject.StackObjectType GetType(string name)
    {
        switch (name)
        {
            case "int":
                return StackObject.StackObjectType.Int;
            case "float":
                return StackObject.StackObjectType.Float;
            case "string":
                return StackObject.StackObjectType.String;
            case "bool":
                return StackObject.StackObjectType.Bool;
            default:
                throw new ArgumentException("Invalid function type");
        }
    }


}

