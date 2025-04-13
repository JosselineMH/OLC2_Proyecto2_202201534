using analyzer;
using Antlr4.Runtime.Misc;
using System.Globalization;
using System.Text;
using Antlr4.Runtime.Tree;
using Microsoft.Extensions.Logging.Console;


public class CompilerVisitor : LanguageBaseVisitor<Object?>
{

    public ArmGenerator c = new ArmGenerator();
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
        c.Comment("Variable: " + varName);

        Visit(context.expresion());
        c.TagObject(varName);

        return null;
    }

    // VisitDeclaracionPorDefecto


    public override object? VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        var varName = context.ID().GetText();
        var tipo = context.tipoDeclaracion().GetText();

        c.Comment($"Declaración por defecto: {varName} ({tipo})");

        StackObject obj;

        switch (tipo)
        {
            case "int":
                obj = c.IntObject();
                c.Mov(Register.X0, 0); 
                break;
            case "float64":
                obj = c.FloatObject();
             
                c.Mov(Register.X0, 0); // por ahora
                break;
            case "string":
                obj = c.StringObject();
                c.Mov(Register.X0, 0); //puntero vacío
                break;
            case "rune":
                obj = new StackObject { Type = StackObject.StackObjectType.Rune, Lenght = 8, Depth = 0, Id = null };
                c.Mov(Register.X0, 0);
                break;
            default:
                throw new Exception("Tipo no soportado: " + tipo);
        }

        c.Push(Register.X0);
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

        foreach (var expr in context.expresion())
        {
            Visit(expr);               
            var value = c.PopObject(Register.X0);   
            if (value.Type == StackObject.StackObjectType.Int)
            {
                c.PrintInt(Register.X0);
            }
            else if (value.Type == StackObject.StackObjectType.String)
            {
                c.PrintString(Register.X0);
            }
            else if (value.Type== StackObject.StackObjectType.Float)
            {
                //c.PrintFloat(Register.X0);
            }
            else if (value.Type == StackObject.StackObjectType.Rune)
            {
               // c.PrintRune(Register.X0);
            }   
        }

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
        return null;
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
    public override Object? VisitNegate(LanguageParser.NegateContext context)
    {
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
        return null;
    }

    //VisitBoolean
    public override Object? VisitBoolean(LanguageParser.BooleanContext context)
    {
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

    public override Object? VisitRune(LanguageParser.RuneContext context)
    {
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
        var operation = context.op.Text;
        Visit(context.expresion(0));
        Visit(context.expresion(1));

        c.Pop(Register.X1);
        c.Pop(Register.X0);
        
        if (operation == "*")
        {
            c.Mul(Register.X0, Register.X0, Register.X1);
        }
        else if (operation == "/")
        {
            c.Div(Register.X0, Register.X0, Register.X1);
        }
        else if (operation == "%")
        {
            c.Mod(Register.X0, Register.X0, Register.X1);
        }

        c.Push(Register.X0);

        return null;
    }

    // VisitAddSub
    public override Object? VisitAddSub(LanguageParser.AddSubContext context)
    {
        c.Comment("Add/Sub operation");
        var operation = context.op.Text;

        Visit(context.expresion(0));
        Visit(context.expresion(1));

       
        var right = c.PopObject(Register.X1);
        var left = c.PopObject(Register.X0);
        
        if (operation == "+")
        {
            c.Add(Register.X0, Register.X0, Register.X1);
        }
        else if (operation == "-")
        {
            c.Sub(Register.X0, Register.X0, Register.X1);
        }

        c.Push(Register.X0);
        c.PushObject(c.CloneObject(left));

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

        // Dirección en memoria de la variable
        c.Mov(Register.X1, offset);
        c.Add(Register.X1, Register.SP, Register.X1);

        if (op == "=")
        {
            // Asignación directa
            c.Str(Register.X0, Register.X1);
        }
        else
        {
            // Obtener el valor actual de la variable
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

    public override Object? VisitRelational(LanguageParser.RelationalContext context)
    {
        return null;
    }

    // VisitLogicalAnd

    public override Object? VisitLogicalAnd(LanguageParser.LogicalAndContext context)
    {
       return null;
    }

    

    public override Object? VisitEquality(LanguageParser.EqualityContext context)
    {
        return null; 
    }


    // VisitLogicalOr

    public override Object? VisitLogicalOr(LanguageParser.LogicalOrContext context)
    {
       return null; 
    }

    // VisitLogicalNot

    public override Object? VisitLogicalNot(LanguageParser.LogicalNotContext context)
    {
        return null;
    }

    // VisitIncrementeDecrement

    public override Object? VisitIncrementDecrement(LanguageParser.IncrementDecrementContext context)
    {
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

    // VisitDeclaracionSliceValores
    
    public override Object? VisitDeclaracionSliceValores(LanguageParser.DeclaracionSliceValoresContext context)
    {
       return null;
    }

    //  VisitSliceLiteral

    public override Object? VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
    {
        return null;
    }


    // VisitDeclaracionSliceVacio

    public override Object? VisitDeclaracionSliceVacio(LanguageParser.DeclaracionSliceVacioContext context)
    {
        return null;
    }  
      


    // VisitDeclaracionSliceCopia
    public override Object? VisitDeclaracionSliceCopia(LanguageParser.DeclaracionSliceCopiaContext context)
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

    public override Object? VisitIfStmt(LanguageParser.IfStmtContext context)
    {
        return null;
    }

    //VisitBreakStmt

    public override Object? VisitBreakStmt(LanguageParser.BreakStmtContext context)
    {
        return null;
    }

    //VisitContinueStmt
    
    public override Object? VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
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

    public override Object? VisitForWhileStmt([NotNull] LanguageParser.ForWhileStmtContext context)
    {
        return null;
    }



    // VisitForStmt

    public override Object? VisitForStmt(LanguageParser.ForStmtContext context)
    {
        return null;
    }

/*
    public void VisitBodyFor(LanguageParser.ForStmtContext context)
    {
        return null;
    }
*/


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

