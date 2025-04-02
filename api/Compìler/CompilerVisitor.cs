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
        return null;
       
    }

    // VisitDeclaracionPorDefecto


    public override Object? VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        return null;
    }
    


    // VisitDeclaracionImplicita

    public override Object? VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        return null;
    }


    // VisitExprStmt
    public override Object? VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return null;
    }

    // VisitPrintStmt
    public override Object? VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {
        c.Comment("Print statement");

        foreach (var expr in context.expresion())
        {
            Visit(expr);               
            c.Pop(Register.X0);        
            c.PrintInt(Register.X0);   
        }

        return null;
    }




    // VisitIdentifier
    public override Object? VisitIdentifier(LanguageParser.IdentifierContext context)
    {
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
        c.Mov(Register.X0, int.Parse(value));
        c.Push(Register.X0);
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

        var operation = context.op.Text;
        Visit(context.expresion(0));
        Visit(context.expresion(1));

        c.Pop(Register.X1);
        c.Pop(Register.X0);
        
        if (operation == "+")
        {
            c.Add(Register.X0, Register.X0, Register.X1);
        }
        else if (operation == "-")
        {
            c.Sub(Register.X0, Register.X0, Register.X1);
        }

        c.Push(Register.X0);

        return null;
    }

    //VisitAssignVar
    
    public override Object? VisitAssignVar(LanguageParser.AssignVarContext context)
    {
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

