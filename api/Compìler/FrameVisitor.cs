using analyzer;

public class FrameElement
{
    public string Name { get; set; }
    public int Offset { get; set; }

    public FrameElement(string name, int offset)
    {
        Name = name;
        Offset = offset;
    }
}

public class FrameVisitor : LanguageBaseVisitor<Object?>
{
    public List<FrameElement> Frame;
    public int LocalOffset;
    public int BaseOffset;
    public FrameVisitor(int baseOffset)
    {
        Frame = new List<FrameElement>();
        LocalOffset = 0;
        BaseOffset = baseOffset;
    }

    public override Object? VisitDclFuera(LanguageParser.DclFueraContext context)
    {
        Visit(context.declaracionVariable());
        return null;
    }


    public override Object? VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    { 
        string name = context.ID().GetText();
        Frame.Add(new FrameElement(name,BaseOffset + LocalOffset));
        LocalOffset += 1;
        return null;
    }

    public override object? VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        string name = context.ID().GetText();
        Frame.Add(new FrameElement(name, BaseOffset + LocalOffset));
        LocalOffset += 1;
        return null;
    }

    public override object? VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string name = context.ID().GetText();
        Frame.Add(new FrameElement(name, BaseOffset + LocalOffset));
        LocalOffset += 1;
        return null;
    }

    public override Object? VisitBlockStmt(LanguageParser.BlockStmtContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        } 

        return null;        
    }

    public override object? VisitIfStmt(LanguageParser.IfStmtContext context)
    {
        Visit(context.sentencia(0));
        if(context.sentencia().Length > 1) Visit(context.sentencia(1));    
        return null; 
    }

    public override Object? VisitForWhileStmt(LanguageParser.ForWhileStmtContext context)
    {
        Visit(context.sentencia());
        return null;
    }

    public override object? VisitForStmt(LanguageParser.ForStmtContext context)
    {
        if(context.forInit().declaracionVariable( ) != null)
        {
            Visit(context.forInit().declaracionVariable());
        }
        Visit(context.sentencia());
        return null;
    }

}
