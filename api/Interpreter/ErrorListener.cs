using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;

public class DatosTablaErrores
{
    public int No { get; set; }
    public string Descripcion { get; set; } = "";
    public int Linea { get; set; }
    public int Columna { get; set; }
    public string Tipo { get; set; } = "";
}
public class Error
{
    public static List<DatosTablaErrores> TableError = new();

    public string GenerateErrorTable()
    {
        var sb = new StringBuilder();

        sb.Append("<html><head><style>");
        sb.Append("body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; text-align: center; }");
        sb.Append("h2 { color: #333; }");
        sb.Append("table { width: 80%; margin: auto; border-collapse: collapse; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); background: white; }");
        sb.Append("th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
        sb.Append("th { background-color: #800000; color: white; font-weight: bold; }");  
        sb.Append("tr:nth-child(even) { background-color: #f2f2f2; }");
        sb.Append("tr:hover { background-color: #ffd1d1; }");  
        sb.Append("</style></head><body>");
        sb.Append("<h2>Reporte de Errores</h2>");
        sb.Append("<table>");
        sb.Append("<tr><th>No</th><th>Descripción</th><th>Línea</th><th>Columna</th><th>Tipo</th></tr>");

        foreach (var error in TableError)
        {
            sb.Append($"<tr><td>{error.No}</td><td>{error.Descripcion}</td><td>{error.Linea}</td><td>{error.Columna}</td><td>{error.Tipo}</td></tr>");
        }

        sb.Append("</table></body></html>");

        return sb.ToString();
    }
}

public class SemanticError : Exception
{
    public int Linea { get; }
    public int Columna { get; }
    public string Tipo { get; } = "Semántico";

    public SemanticError(string message, IToken token) : base(message)
    {
        Linea = token.Line;
        Columna = token.Column;

        Error.TableError.Add(new DatosTablaErrores
        {
            No = Error.TableError.Count + 1,
            Descripcion = message,
            Linea = token.Line,
            Columna = token.Column,
            Tipo = "Semántico"
        });
    }
}



public class LexicalErrorListener : BaseErrorListener, IAntlrErrorListener<int>
{
    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
       Error.TableError.Add(new DatosTablaErrores
        {
            No = Error.TableError.Count + 1,
            Descripcion = msg,
            Linea = line,
            Columna = charPositionInLine,
            Tipo = "Léxico"
        });
        throw new ParseCanceledException($"Error léxico en línea {line}:{charPositionInLine} - {msg}");
    }

}


public class SyntaxErrorListener : BaseErrorListener
{
    public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        Error.TableError.Add(new DatosTablaErrores
        {
            No = Error.TableError.Count + 1,
            Descripcion = msg,
            Linea = line,
            Columna = charPositionInLine,
            Tipo = "Léxico"
        });
        throw new ParseCanceledException($"Error sintáctico en línea {line}:{charPositionInLine} - {msg}");
    }
}