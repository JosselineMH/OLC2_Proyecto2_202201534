
using System.Text;

public class SymbolTableEntry
{
    public string ID { get; set; }
    public string TipoSimbolo { get; set; } // Variable, Función, etc.
    public string TipoDato { get; set; }    // int, float64, etc.
    public int Linea { get; set; }          
    public int Columna { get; set; }        
}

public class Environment
{

   private List<SymbolTableEntry> SymbolTable { get; set; } = new List<SymbolTableEntry>();

    public void AddSymbol(string id, string tipoSimbolo, string tipoDato, int linea, int columna)
    {
        SymbolTable.Add(new SymbolTableEntry
        {
            ID = id,
            TipoSimbolo = tipoSimbolo,
            TipoDato = tipoDato,
            Linea = linea,
            Columna = columna
        });
    }

    public List<SymbolTableEntry> GetSymbolTable()
    {
        return SymbolTable;
    }

    public Dictionary<string, ValueWrapper> variables = new Dictionary<string, ValueWrapper>();
    public Dictionary<string, Dictionary<string, string>> Struct = new();

    private Environment? parent;

    public Environment(Environment? parent)
    {
        this.parent = parent;
    }




    public ValueWrapper GetVariable(string id, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            return variables[id];
        }
        if (parent != null)
        {
            return parent.GetVariable(id, token);
        }

        throw new SemanticError("Variable " + id + " no encontrada", token);   
    }


    public void DeclaracionVariable(string id, ValueWrapper value, string tipoSimbolo, int linea, int columna, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            throw new SemanticError($"La variable {id} ya fue declarada.", token);
        }
        
        variables[id] = value;

        string tipoDato = ObtenerTipoDato(value);

        SymbolTable.Add(new SymbolTableEntry
        {
            ID = id,
            TipoSimbolo = tipoSimbolo,
            TipoDato = tipoDato,
            Linea = linea,
            Columna = columna
        });

    }


    
    public ValueWrapper AsgnVariable(string id, ValueWrapper value, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            variables[id] = value;
            return value;
        }
        if (parent != null)
        {
            return parent.AsgnVariable(id, value, token);
        }

        throw new SemanticError("Variable " + id + " no encontrada", token);
        
    }

    public void DeclaracionStruct(string name, Dictionary<string, string> atribs, Antlr4.Runtime.IToken? token)
    {
        if (Struct.ContainsKey(name))
        {
            throw new SemanticError($"Struct {name} ya fue declarado.", token);
        }

        Struct[name] = atribs;

        int linea = token?.Line ?? -1;
        int columna = token?.Column ?? -1;

        SymbolTable.Add(new SymbolTableEntry
        {
            ID = name,
            TipoSimbolo = "Struct",
            TipoDato = "struct",
            Linea = linea,
            Columna = columna
        });
    }


    public Dictionary<string, string> GetStruct(string nombre, Antlr4.Runtime.IToken token)
    {
        if (Struct.ContainsKey(nombre))
        {
            return Struct[nombre];
        }
        if (parent != null)
        {
            return parent.GetStruct(nombre, token);
        }
    
        throw new SemanticError($"Error: El struct '{nombre}' no está definido.", token);
    }

     public bool ExistStruct(string nombre)
    {
        if (Struct.ContainsKey(nombre))
        {
            return true;
        }
        return parent?.ExistStruct(nombre) ?? false;
    }


    public string GenerateSymbolTableHtml()
    {
        var html = new StringBuilder();

        html.Append("<html><head><style>");
        html.Append("body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; text-align: center; }");
        html.Append("h2 { color: #333; }");
        html.Append("table { width: 80%; margin: auto; border-collapse: collapse; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); background: white; }");
        html.Append("th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
        html.Append("th { background-color: #004080; color: white; font-weight: bold; }");
        html.Append("tr:nth-child(even) { background-color: #f2f2f2; }");
        html.Append("tr:hover { background-color: #ddd; }");
        html.Append("</style></head><body>");
        html.Append("<h2>Tabla de Símbolos</h2>");
        html.Append("<table>");
        html.Append("<tr><th>ID</th><th>Tipo Símbolo</th><th>Tipo Dato</th><th>Línea</th><th>Columna</th></tr>");

        foreach (var entry in SymbolTable)
        {
            html.Append($"<tr><td>{entry.ID}</td><td>{entry.TipoSimbolo}</td><td>{entry.TipoDato}</td><td>{entry.Linea}</td><td>{entry.Columna}</td></tr>");
        }

        html.Append("</table></body></html>");
        return html.ToString();
    }


    private string ObtenerTipoDato(ValueWrapper value)
    {
        return value switch
        {
            IntValue => "int",
            FloatValue => "float64",
            BoolValue => "bool",
            StringValue => "string",
            RunValue => "rune",
            SliceValue => "Slice",
            VoidValue => "void",
            StructValue => "struct",
            FunctionValue => "func",
            _ => "desconocido"
        };
    }

   
}

