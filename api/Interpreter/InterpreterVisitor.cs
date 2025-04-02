using analyzer;
using Antlr4.Runtime.Misc;
using System.Globalization;
using System.Text;
using Antlr4.Runtime.Tree;
using Microsoft.Extensions.Logging.Console;


public class InterpreterVisitor : LanguageBaseVisitor<ValueWrapper>
{
    public ValueWrapper defaultValue = new VoidValue();

    public string output = "";
    
    public Environment entornoActual = new Environment(null);
  

    // VisitProgram

    public override ValueWrapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var dclFuera in context.dclFuera())
        {
            Visit(dclFuera);
        }

        // Buscar la función main y sus declaraciones
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }

        return defaultValue;
   
    }


    // VisitDeclaracionExplicita

    public override ValueWrapper VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string id = context.ID().GetText(); 
        ValueWrapper value = Visit(context.expresion()); 
        string tipo = context.tipoDeclaracion().GetText(); 

        if (value is IntValue && tipo != "int")
        {
            if (tipo == "float64")
            {
                value = new FloatValue(((IntValue)value).Value);
            }
            else
            throw new SemanticError("La variable es de tipo " + tipo + " y se le esta asignando un valor de tipo int", context.Start);
        }
        else if (value is FloatValue && tipo != "float64")
        {
            throw new SemanticError("La variable es de tipo " + tipo + " y se le esta asignando un valor de tipo float64", context.Start);
        }
        else if (value is BoolValue && tipo != "bool")
        {
            throw new SemanticError("La variable es de tipo " + tipo + " y se le esta asignando un valor de tipo bool", context.Start);
        }
        else if (value is StringValue && tipo != "string")
        {
            throw new SemanticError("La variable es de tipo " + tipo + " y se le esta asignando un valor de tipo string", context.Start);
        }
        else if (value is RunValue && tipo != "rune")
        {
            throw new SemanticError("La variable es de tipo " + tipo + " y se le esta asignando un valor de tipo rune", context.Start);
            
        }
       
        entornoActual.DeclaracionVariable(id, value, "Variable", context.Start.Line, context.Start.Column, context.Start);
        return defaultValue;
    }

    // VisitDeclaracionPorDefecto


    public override ValueWrapper VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        string id = context.ID().GetText(); 
        string tipo = context.tipoDeclaracion().GetText(); 
        ValueWrapper defaultValue = tipo switch
        {
            "int" => new IntValue(0),
            "float64" => new FloatValue(0.0f),  
            "bool" => new BoolValue(false),
            "string" => new StringValue(""),
            "rune" => new RunValue('0'),
            _ => throw new SemanticError("Tipo de dato no valido", context.Start)
        };

        int linea = context.Start.Line;
        int columna = context.Start.Column;

        entornoActual.DeclaracionVariable(id, defaultValue, "Variable", linea, columna, context.Start);
        return defaultValue;
    }
    


    // VisitDeclaracionImplicita

    public override ValueWrapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string id = context.ID().GetText(); 
        ValueWrapper value = Visit(context.expresion()); 
        entornoActual.DeclaracionVariable(id, value, "Variable", context.Start.Line, context.Start.Column, context.Start); 
        return defaultValue;
    }


    // VisitExprStmt
    public override ValueWrapper VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expresion());
    }

    // VisitPrintStmt
    public override ValueWrapper VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {

        if (context.expresion().Length == 0)
        {
            output += "\n";
            return defaultValue;
        }


        List<string> valores = new List<string>();

        foreach (var expr in context.expresion())
        {
            ValueWrapper value = Visit(expr);

            string valorStr = value switch
            {
                IntValue i => i.Value.ToString(),
                FloatValue f => f.Value.ToString("0.00", CultureInfo.InvariantCulture),
                StringValue s => s.Value,
                BoolValue b => b.Value.ToString().ToLower(),
                RunValue r => r.Value.ToString(),
                VoidValue _ => "null",
                SliceValue slice => "[" + ConvertirSliceAString(slice, context.Start) + "]",
                StructValue structVal => ConvertirStructAString(structVal, context.Start),
                _ => throw new SemanticError("Tipo de dato no soportado en PrintStmt", context.Start)
            };

            valores.Add(valorStr);
        }

        output += string.Join(" ", valores) + "\n";

        return defaultValue;
    }



    private string ConvertirStructAString(StructValue structVal, Antlr4.Runtime.IToken token)
    {
        List<string> campos = new List<string>();
        foreach (var kvp in structVal.Attributes)
        {
            campos.Add($"{kvp.Key}: {ConvertirAString(kvp.Value, token)}");
        }
        return $"{structVal.StructName}{{{string.Join(", ", campos)}}}";
    }


    private string ConvertirSliceAString(SliceValue slice, Antlr4.Runtime.IToken token)
    {
        List<string> elementosStr = new List<string>();

        foreach (var elemento in slice.Values)
        {
            string elementoStr = elemento switch
            {
                SliceValue subSlice => "[" + ConvertirSliceAString(subSlice, token) + "]", 
                _ => ConvertirAString(elemento, token ) 
            };

            elementosStr.Add(elementoStr);
        }

        return string.Join(", ", elementosStr);
    }


     private string ConvertirAString(ValueWrapper value, Antlr4.Runtime.IToken token)
    {
        return value switch
        {
            IntValue i => i.Value.ToString(),
            FloatValue f => f.Value.ToString("0.00", CultureInfo.InvariantCulture),
            StringValue s => s.Value,
            BoolValue b => b.Value.ToString().ToLower(),
            RunValue r => r.Value.ToString(),
            VoidValue _ => "null",
            _ => throw new SemanticError("Tipo de dato no soportado en Slice",token )
        };
    }



    // VisitIdentifier
    public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return entornoActual.GetVariable(id, context.Start);
       //hola
    }

    // VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expresion());
    }

    // VisitBlockStmt

    public override ValueWrapper VisitBlockStmt(LanguageParser.BlockStmtContext context)
    {
        Environment entornoPrevio = entornoActual;
        entornoActual = new Environment(entornoPrevio);

        foreach (var stmt in context.dcl())
        {
            Visit(stmt);
        }

        entornoActual = entornoPrevio;
        return defaultValue;
    }

     // VisitNegate
    public override ValueWrapper VisitNegate(LanguageParser.NegateContext context)
    {
        ValueWrapper value = Visit(context.expresion());
        return value switch
        {
            IntValue i => new IntValue(-i.Value),
            FloatValue f => new FloatValue(-f.Value),
            _ => throw new SemanticError("Operación no válida", context.Start)
        };

    }

    // VisitNumber
    public override ValueWrapper VisitNumber(LanguageParser.NumberContext context)
    {
        return new IntValue(int.Parse(context.INT().GetText()));
    }

    // VisitFloat

    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context)
    {
        return new FloatValue(float.Parse(context.FLOAT().GetText(), CultureInfo.InvariantCulture));
    }

    //VisitBoolean
    public override ValueWrapper VisitBoolean(LanguageParser.BooleanContext context)
    {
        return new BoolValue(bool.Parse(context.BOOL().GetText()));
    }
   
    // VisitString

   public override ValueWrapper VisitString(LanguageParser.StringContext context)
    {
        string cadenacomillas = context.STRING().GetText();
        
        string cadenasincomillas = cadenacomillas.Substring(1, cadenacomillas.Length - 2);
        
        cadenasincomillas = cadenasincomillas
            .Replace("\\n", "\n")
            .Replace("\\r", "\r")
            .Replace("\\t", "\t")
            .Replace("\\\"", "\"")
            .Replace("\\\\", "\\");

        return new StringValue(cadenasincomillas);
    }

    // VisitRune

    public override ValueWrapper VisitRune(LanguageParser.RuneContext context)
    {
        return new RunValue(context.RUNE().GetText()[1]);
    }

    // VisitNil

    public override ValueWrapper VisitNil(LanguageParser.NilContext context)
    {
        return new NilValue();
    }

    // VisitMulDivMod
    public override ValueWrapper VisitMulDivMod(LanguageParser.MulDivModContext context)
    {
        var left = Visit(context.expresion(0));
        var right = Visit(context.expresion(1));
        var op = context.op.Text;

        if (op == "/" || op == "%")
        {
            if ((right is IntValue intDerecha && intDerecha.Value == 0) ||
                (right is FloatValue floatDerecha && floatDerecha.Value == 0.0))
            {
                throw new SemanticError("División por cero no está permitida", context.Start);
            }
        }

        return (left, right, op)  switch
        {
            //multiplicaciones
            (IntValue l, IntValue r, "*")=> new IntValue(l.Value * r.Value),
            (IntValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value),
            (FloatValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value),
            (FloatValue l, IntValue r, "*") => new FloatValue(l.Value * r.Value),

            //divisiones
            (IntValue l,  IntValue r, "/") => new IntValue(l.Value / r.Value),
            //(IntValue l, IntValue r, "/") => new FloatValue((double)l.Value / r.Value),
            (IntValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value),
            (FloatValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value),
            (FloatValue l, IntValue r, "/") => new FloatValue(l.Value / r.Value),

            //modlulos
            (IntValue l, IntValue r, "%") => new IntValue(l.Value % r.Value),

            //error
            _   => throw new SemanticError("Operación no válida", context.Start)
        };
    }

    // VisitAddSub
     public override ValueWrapper VisitAddSub(LanguageParser.AddSubContext context)
    {
        var left = Visit(context.GetChild(0));
        var right = Visit(context.expresion(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            //sumas
            (IntValue l, IntValue r, "+") => new IntValue(l.Value + r.Value),
            (IntValue l, FloatValue r, "+") => new FloatValue(l.Value + r.Value),
            (FloatValue l, FloatValue r, "+") => new FloatValue(l.Value + r.Value),
            (FloatValue l, IntValue r, "+") => new FloatValue(l.Value + r.Value),
            (StringValue l, StringValue r, "+") => new StringValue(l.Value + r.Value),

            //restas
            (IntValue l, IntValue r, "-") => new IntValue(l.Value - r.Value),
            (IntValue l, FloatValue r, "-") => new FloatValue(l.Value - r.Value),
            (FloatValue l, FloatValue r, "-") => new FloatValue(l.Value - r.Value),
            (FloatValue l, IntValue r, "-") => new FloatValue(l.Value - r.Value),

            //error
            _ => throw new SemanticError("Operación no válida", context.Start)
        };
        
    }


    
    //VisitAssignVar
    
    public override ValueWrapper VisitAssignVar(LanguageParser.AssignVarContext context)
    {
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expresion());
        var op = context.op.Text;

        ValueWrapper valorActual = entornoActual.GetVariable(id, context.Start);

        if (valorActual == null)
        {
            throw new SemanticError($"Variable '{id}' no ha sido declarada.", context.Start);
        }

        // Manejo de operadores compuestos como +=
        switch (op)
        {
            case "=":
                if(valorActual is IntValue && value is IntValue)
                {
                    return entornoActual.AsgnVariable(id, value, context.Start);
                }
                if (valorActual is FloatValue && value is FloatValue)
                {
                    return entornoActual.AsgnVariable(id, value, context.Start);
                }
                if (valorActual is FloatValue && value is IntValue)
                {
                    return entornoActual.AsgnVariable(id, new FloatValue(((IntValue)value).Value), context.Start);
                }
                if (valorActual is StringValue && value is StringValue)
                {
                    return entornoActual.AsgnVariable(id, value, context.Start);
                }
                if (valorActual is BoolValue && value is BoolValue)
                {
                    return entornoActual.AsgnVariable(id, value, context.Start);
                }
                if (valorActual is RunValue && value is RunValue)
                {
                    return entornoActual.AsgnVariable(id, value, context.Start);
                }
                if (valorActual is SliceValue && value is SliceValue)
                {
                    return entornoActual.AsgnVariable(id, value, context.Start);
                }
                throw new SemanticError($"No se puede asignar un valor de tipo '{value.GetType().Name}' a una variable de tipo '{valorActual.GetType().Name}'.", context.Start);
            case "+=":
                if (valorActual is IntValue intVar && value is IntValue intVal)
                {
                    return entornoActual.AsgnVariable(id, new IntValue(intVar.Value + intVal.Value), context.Start);
                }
                if (valorActual is FloatValue floatVar && value is FloatValue floatVal)
                {
                    return entornoActual.AsgnVariable(id, new FloatValue(floatVar.Value + floatVal.Value), context.Start);
                }
                if (valorActual is FloatValue floatVal2 && value is IntValue intVal2)
                {
                    return entornoActual.AsgnVariable(id, new FloatValue(intVal2.Value + floatVal2.Value), context.Start);
                }
                if (valorActual is StringValue strVar && value is StringValue strVal)
                {
                    return entornoActual.AsgnVariable(id, new StringValue(strVar.Value + strVal.Value), context.Start);
                }
                
                throw new SemanticError($"Operador de asignación '{op}' no soportado.", context.Start);
            case "-=":
               if (valorActual is IntValue intVarDr1 && value is IntValue intValDr2)
                {
                    return entornoActual.AsgnVariable(id, new IntValue(intVarDr1.Value - intValDr2.Value), context.Start);
                }
                if (valorActual is FloatValue floatVarDr1 && value is FloatValue floatValDr2)
                {
                    return entornoActual.AsgnVariable(id, new FloatValue(floatVarDr1.Value - floatValDr2.Value), context.Start);
                }
                if (valorActual is FloatValue floatValdr && value is IntValue intValdr)
                {
                    return entornoActual.AsgnVariable(id, new FloatValue(floatValdr.Value - intValdr.Value), context.Start);
                }
                throw new SemanticError($"Operador de asignación '{op}' no soportado.", context.Start);
            default:
                throw new SemanticError($"Operador de asignación '{op}' no soportado.", context.Start);
        }
    }
    
    
    // VisitRelational

    public override ValueWrapper VisitRelational(LanguageParser.RelationalContext context)
    {
        var left = Visit(context.expresion(0));
        var right = Visit(context.expresion(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            //menor que
            (IntValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (IntValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value),
            (RunValue l, RunValue r, "<") => new BoolValue(l.Value < r.Value),

            //mayor que
            (IntValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (IntValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (RunValue l, RunValue r, ">") => new BoolValue(l.Value > r.Value),

            //menor o igual que
            (IntValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (IntValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (RunValue l, RunValue r, "<=") => new BoolValue(l.Value <= r.Value),

            //mayor o igual que
            (IntValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (FloatValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (IntValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (FloatValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (RunValue l, RunValue r, ">=") => new BoolValue(l.Value >= r.Value),

            //error
            _ => throw new SemanticError("Operación relacional no válida", context.Start)
        };
    }

    // VisitLogicalAnd

    public override ValueWrapper VisitLogicalAnd(LanguageParser.LogicalAndContext context)
    {
        var left = Visit(context.expresion(0));
        var right = Visit(context.expresion(1));
        Console.WriteLine($"Evaluating: {left} && {right}");

        if (left is BoolValue l && right is BoolValue r)
        {
            return new BoolValue(l.Value && r.Value);
        }

        throw new SemanticError("Operación lógica AND no válida", context.Start);
    }

    

    public override ValueWrapper VisitEquality(LanguageParser.EqualityContext context)
    {
        var left = Visit(context.expresion(0));
        var right = Visit(context.expresion(1));
        var op = context.op.Text;

        Console.WriteLine($"Comparando {left} {op} {right}");

        return (left, right, op) switch
        {
            // Igualdad
            (IntValue l, IntValue r, "==") => new BoolValue(l.Value == r.Value),
            (FloatValue l, FloatValue r, "==") => new BoolValue(l.Value == r.Value),
            (IntValue l, FloatValue r, "==") => new BoolValue(l.Value == r.Value),
            (FloatValue l, IntValue r, "==") => new BoolValue(l.Value == r.Value),
            (BoolValue l, BoolValue r, "==") => new BoolValue(l.Value == r.Value),
            (StringValue l, StringValue r, "==") => new BoolValue(l.Value == r.Value),
            (RunValue l, RunValue r, "==") => new BoolValue(l.Value == r.Value),
            (NilValue _, NilValue _, "==") => new BoolValue(true),

            // Desigualdad
            (IntValue l, IntValue r, "!=") => new BoolValue(l.Value != r.Value),
            (FloatValue l, FloatValue r, "!=") => new BoolValue(l.Value != r.Value),
            (IntValue l, FloatValue r, "!=") => new BoolValue(l.Value != r.Value),
            (FloatValue l, IntValue r, "!=") => new BoolValue(l.Value != r.Value),
            (BoolValue l, BoolValue r, "!=") => new BoolValue(l.Value != r.Value),
            (StringValue l, StringValue r, "!=") => new BoolValue(l.Value != r.Value),
            (RunValue l, RunValue r, "!=") => new BoolValue(l.Value != r.Value),

            // Error
            _ => throw new SemanticError($"Operación de igualdad no válida entre {left} y {right}", context.Start)
        };
    }


    // VisitLogicalOr

    public override ValueWrapper VisitLogicalOr(LanguageParser.LogicalOrContext context)
    {
        var left = Visit(context.expresion(0));
        var right = Visit(context.expresion(1));

        if (left is BoolValue l && right is BoolValue r)
        {
            return new BoolValue(l.Value || r.Value);
        }

        throw new SemanticError("Operación lógica OR no válida", context.Start);
    }

    // VisitLogicalNot

    public override ValueWrapper VisitLogicalNot(LanguageParser.LogicalNotContext context)
    {
        var value = Visit(context.expresion());

        if (value is BoolValue b)
        {
            return new BoolValue(!b.Value);
        }

        throw new SemanticError("Operación lógica NOT no válida", context.Start);
    }

    // VisitIncrementeDecrement

   public override ValueWrapper VisitIncrementDecrement(LanguageParser.IncrementDecrementContext context)
    {
        string id = context.ID().GetText();
        string op = context.op.Text; 

        var valorActual = entornoActual.GetVariable(id, context.Start);
        if (valorActual == null)
        {
            throw new SemanticError($"Variable '{id}' no ha sido declarada.", context.Start);
        }


        ValueWrapper nuevoValor;
        if (valorActual is IntValue intVal)
        {
            int cambio = (op == "++") ? (intVal.Value + 1) : (intVal.Value - 1);
            nuevoValor = new IntValue(cambio);
        }
        else if (valorActual is FloatValue floatVal)
        {
            float cambio = (op == "++") ? (floatVal.Value + 1.0f) : (floatVal.Value - 1.0f);
            nuevoValor = new FloatValue(cambio);
        }
        else
        {
            throw new SemanticError($"La variable '{id}' no es de tipo int ni float64.", context.Start);
        }

        entornoActual.AsgnVariable(id, nuevoValor, context.Start);

        return nuevoValor;
    }


    //VisitEmebbedFuncAtoi

    public override ValueWrapper VisitEmebbedFuncAtoi(LanguageParser.EmebbedFuncAtoiContext context)
    {
        ValueWrapper value = Visit(context.expresion());

        return value switch
        {
            StringValue s when int.TryParse(s.Value, out int intValue) => new IntValue(intValue),
            _ => throw new SemanticError($"La función strconv.Atoi solo puede convertir cadenas a enteros", context.Start)
        };
    }

    //VisitEmbebbedFuncParseFloat

    public override ValueWrapper VisitEmebbedFuncParseFloat(LanguageParser.EmebbedFuncParseFloatContext context)
    {
        ValueWrapper value = Visit(context.expresion());

        return value switch
        {
            StringValue s when float.TryParse(s.Value, NumberStyles.Float, CultureInfo.InvariantCulture, out float floatValue)
                => new FloatValue(floatValue),

            IntValue i => new FloatValue((float)i.Value),

            _ => throw new SemanticError($"La función strconv.ParseFloat solo puede convertir cadenas o enteros a flotantes", context.Start)
        };
    }

    // VisitEmebbedFuncTypeOf

    public override ValueWrapper VisitEmebbedFuncTypeOf(LanguageParser.EmebbedFuncTypeOfContext context)
    {
        ValueWrapper value = Visit(context.expresion());

        if (value is SliceValue arreglo)
        {
            return new StringValue($"[]{arreglo.Tipo}");
        }

        return value switch
        {
            IntValue _ => new StringValue("int"),
            FloatValue _ => new StringValue("float64"),
            BoolValue _ => new StringValue("bool"),
            StringValue _ => new StringValue("string"),
            RunValue _ => new StringValue("rune"),
            _ => throw new SemanticError("Tipo de dato no soportado", context.Start)
        };
    }

    // VisitDeclaracionSliceValores
    
    public override ValueWrapper VisitDeclaracionSliceValores(LanguageParser.DeclaracionSliceValoresContext context)
    {
        string id = context.ID().GetText(); 
        ValueWrapper valor = Visit(context.expresion());

        entornoActual.DeclaracionVariable(id, valor, "Variable", context.Start.Line, context.Start.Column, context.Start);

        return defaultValue;
    }

    //  VisitSliceLiteral

    public override ValueWrapper VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
    {
        string tipo = context.tipoDeclaracion().GetText(); 

        List<ValueWrapper> valores = new List<ValueWrapper>();
        foreach (var expr in context.expresion())
        {
            ValueWrapper valor = Visit(expr);
            if (!EsTipoValido(valor, tipo))
            {
                throw new SemanticError($"Tipo incompatible en slice literal: se esperaba {tipo}, pero se obtuvo uno distinto", context.Start);
            }
            valores.Add(valor);
        }

        return new SliceValue(valores, tipo);
    }


    private bool EsTipoValido(ValueWrapper valor, string tipoEsperado)
    {
        // revisamos si su tipo base coincide
        if (valor is SliceValue sliceVal)
        {
            return sliceVal.Tipo == tipoEsperado;
        }

        return (valor is IntValue   && tipoEsperado == "int")    ||
            (valor is FloatValue && tipoEsperado == "float64")||
            (valor is StringValue&& tipoEsperado == "string") ||
            (valor is BoolValue  && tipoEsperado == "bool")   ||
            (valor is RunValue   && tipoEsperado == "rune");
    }


    // VisitDeclaracionSliceVacio

    public override ValueWrapper VisitDeclaracionSliceVacio(LanguageParser.DeclaracionSliceVacioContext context)
    {
        string id = context.ID().GetText();
        string tipo = context.tipoDeclaracion().GetText(); 

        var tiposSlice = new Dictionary<string, List<ValueWrapper>>()
        {
            { "int", new List<ValueWrapper>() },
            { "float64", new List<ValueWrapper>() },
            { "string", new List<ValueWrapper>() },
            { "bool", new List<ValueWrapper>() },
            { "rune", new List<ValueWrapper>() }
        };

        if (!tiposSlice.ContainsKey(tipo))
        {
            throw new SemanticError($"Tipo de slice no soportado: {tipo}", context.Start);
        }

        var valores = tiposSlice[tipo];

        entornoActual.DeclaracionVariable(id, new SliceValue(valores, tipo), "Variable", context.Start.Line, context.Start.Column, context.Start);

        return defaultValue;
    }


    // VisitDeclaracionSliceCopia
    public override ValueWrapper VisitDeclaracionSliceCopia(LanguageParser.DeclaracionSliceCopiaContext context)
    {
        
        string idDestino = context.ID(0).GetText();
        string idOrigen = context.ID(1).GetText();

        var sliceDestino = entornoActual.GetVariable(idDestino, context.Start) as SliceValue;
        var sliceOrigen = entornoActual.GetVariable(idOrigen, context.Start) as SliceValue;

     
        if (sliceDestino == null || sliceOrigen == null)
        {
            throw new SemanticError($"Una de las variables no está definida o no es del tipo esperado: {idDestino} o {idOrigen}", context.Start);
        }

    
        if (sliceDestino.Tipo != sliceOrigen.Tipo)
        {
            throw new SemanticError($"No se puede asignar un slice de tipo {sliceOrigen.Tipo} a un slice de tipo {sliceDestino.Tipo}", context.Start);
        }

       
        var nuevoSliceDestino = new SliceValue(new List<ValueWrapper>(sliceOrigen.Values), sliceDestino.Tipo);

       
        entornoActual.AsgnVariable(idDestino, nuevoSliceDestino, context.Start);

        return nuevoSliceDestino;
       
    }

    //VisitSliceFuncIndex

    public override ValueWrapper VisitSliceFuncIndex(LanguageParser.SliceFuncIndexContext context)
    {
        string sliceId = context.ID().GetText();
        ValueWrapper valorBuscado = Visit(context.expresion());

        var slice = entornoActual.GetVariable(sliceId, context.Start) as SliceValue;
        if (slice == null)
        {
            throw new SemanticError($"La variable {sliceId} no está definida o no es un slice.", context.Start);
        }

        for (int i = 0; i < slice.Values.Count; i++)
        {
            if (SonValoresIguales(slice.Values[i], valorBuscado))
            {
                return new IntValue(i);
            }
        }

        return new IntValue(-1);
    }

    private bool SonValoresIguales(ValueWrapper valorAComparar, ValueWrapper valorBuscado)
    {
        return (valorAComparar is IntValue intA && valorBuscado is IntValue intB && intA.Value == intB.Value) ||
            (valorAComparar is FloatValue floatA && valorBuscado is FloatValue floatB && floatA.Value == floatB.Value) ||
            (valorAComparar is StringValue stringA && valorBuscado is StringValue stringB && stringA.Value == stringB.Value) ||
            (valorAComparar is BoolValue boolA && valorBuscado is BoolValue boolB && boolA.Value == boolB.Value) ||
            (valorAComparar is RunValue runeA && valorBuscado is RunValue runeB && runeA.Value == runeB.Value);
    }

    // VisitSliceStringFuncJoin
    public override ValueWrapper VisitSliceStringFuncJoin(LanguageParser.SliceStringFuncJoinContext context)
    {
        string sliceId = context.ID().GetText();
        ValueWrapper separador = Visit(context.expresion());

        var slice = entornoActual.GetVariable(sliceId, context.Start) as SliceValue;
        if (slice == null)
        {
            throw new SemanticError($"La variable {sliceId} no está definida o no es un slice.", context.Start);
        }

        if (slice.Tipo != "string")
        {
            throw new SemanticError($"El slice {sliceId} debe ser un slice de strings.", context.Start);
        }

        if (separador is not StringValue separadorString)
        {
            throw new SemanticError("El separador para la función string.Join debe ser string.", context.Start);
        }

        List<string> valores = slice.Values
            .Cast<StringValue>() //cada elemento a string
            .Select(v => v.Value)   //extraer valores
            .ToList(); //lista de valores


        string resultado = string.Join(((StringValue)separador).Value, valores);
        return new StringValue(resultado);
    }


    // VisitSliceLenFunc
    public override ValueWrapper VisitSliceLenFunc(LanguageParser.SliceLenFuncContext context)
    {
        ValueWrapper valor = Visit(context.expresion());

        if (valor is SliceValue slice)
        {
            return new IntValue(slice.Values.Count);
        }
        else
        {
            throw new SemanticError("La expresión dada a len() no es un slice válido.", context.Start);
        }
    }


    // VisitSliceAppendFunc
    public override ValueWrapper VisitSliceAppendFunc(LanguageParser.SliceAppendFuncContext context)
    {
        string sliceId = context.ID().GetText();
        ValueWrapper elementoNuevo = Visit(context.expresion());

        var slice = entornoActual.GetVariable(sliceId, context.Start) as SliceValue;
        if (slice == null)
        {
            throw new SemanticError($"La variable {sliceId} no está definida o no es un slice.", context.Start);
        }

        if (!EsTipoValido(elementoNuevo, slice.Tipo))
        {
            throw new SemanticError($"Tipo incompatible en slice {sliceId}: se esperaba {slice.Tipo}, pero se obtuvo uno distinto", context.Start);
        }

        slice.Values.Add(elementoNuevo); 
        entornoActual.AsgnVariable(sliceId, slice, context.Start); 

        return slice;
    }

    // VisitSliceAccess

    public override ValueWrapper VisitSliceAccess(LanguageParser.SliceAccessContext context)
    {
        string sliceId = context.ID().GetText();
        ValueWrapper indice = Visit(context.expresion());

        var slice = entornoActual.GetVariable(sliceId, context.Start) as SliceValue;
        if (slice == null)
        {
            throw new SemanticError($"La variable {sliceId} no está definida o no es un slice.", context.Start);
        }

        if (indice is not IntValue intIndice)
        {
            throw new SemanticError("El índice de acceso a un slice debe ser un entero.", context.Start);
        }

        if (intIndice.Value < 0 || intIndice.Value >= slice.Values.Count)
        {
            throw new SemanticError($"Índice {intIndice.Value} fuera de rango para el slice {sliceId}.", context.Start);
        }

        return slice.Values[intIndice.Value];
    }

    // VisitAssignSlice

    public override ValueWrapper VisitAssignSlice(LanguageParser.AssignSliceContext context)
    {
        string sliceId = context.ID().GetText();
        ValueWrapper indice = Visit(context.expresion(0));
        ValueWrapper nuevoValor = Visit(context.expresion(1));

        var slice = entornoActual.GetVariable(sliceId, context.Start) as SliceValue;
        if (slice == null)
        {
            throw new SemanticError($"La variable {sliceId} no está definida o no es un slice.", context.Start);
        }

        if (indice is not IntValue intIndice)
        {
            throw new SemanticError("El índice de acceso a un slice debe ser un entero.", context.Start);
        }

        if (intIndice.Value < 0 || intIndice.Value >= slice.Values.Count)
        {
            throw new SemanticError($"Índice {intIndice.Value} fuera de rango para el slice {sliceId}.", context.Start);
        }

        if (!EsTipoValido(nuevoValor, slice.Tipo))
        {
            throw new SemanticError($"Tipo incompatible en slice {sliceId}: se esperaba {slice.Tipo}, pero se obtuvo uno distinto", context.Start);
        }

        slice.Values[intIndice.Value] = nuevoValor;
        entornoActual.AsgnVariable(sliceId, slice, context.Start);

        return slice;
    }

    // VisitIfStmt

    public override ValueWrapper VisitIfStmt(LanguageParser.IfStmtContext context)
    {
        ValueWrapper condicion = Visit(context.expresion());
        
        if (condicion is not BoolValue)
        {
            throw new SemanticError("La condición del if debe ser de tipo bool.", context.Start);
        }
        if (condicion is BoolValue boolCondicion && boolCondicion.Value)
        {
            Visit(context.sentencia(0));
        }
        else if (context.sentencia().Length > 1)
        {
            Visit(context.sentencia(1));
        }
        
        return defaultValue;
    }

    //VisitBreakStmt

    public override ValueWrapper VisitBreakStmt(LanguageParser.BreakStmtContext context)
    {
        throw new BreakException();
    }

    //VisitContinueStmt
    
    public override ValueWrapper VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
        throw new ContinueException();
    }

    // VisitReturnStmt

    public override ValueWrapper VisitReturnStmt(LanguageParser.ReturnStmtContext context)
    {
        ValueWrapper value = defaultValue;
        if (context.expresion() != null)
        {
            value = Visit(context.expresion());
        }

        throw new ReturnException(value);

    }

    // VisitSwitchStmt

    public override ValueWrapper VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
    {
        ValueWrapper switchValue = Visit(context.expresion());

        bool caseEjecutado = false;

        foreach (var StmtCaso in context.stmtCase())
        {
            ValueWrapper caseValue = Visit(StmtCaso.expresion());

            if (switchValue.Equals(caseValue))
            {
               caseEjecutado = true;
               try
                {
                     foreach (var dcl in StmtCaso.dcl())
                    {
                        Visit(dcl);
                    }

                }
                catch (BreakException)
                {
                    break;
                }
                
                break;  
            }
        }

      
        if (!caseEjecutado && context.stmtDefault() != null)
        {
            foreach (var dcl in context.stmtDefault().dcl())
            {
                Visit(dcl);
            }
        }

        return defaultValue;
    }

    // VisitForWhileStmt

    public override ValueWrapper VisitForWhileStmt([NotNull] LanguageParser.ForWhileStmtContext context)
    {
        ValueWrapper condicion = Visit(context.expresion());

        if (condicion is not BoolValue)
        {
            throw new SemanticError("La condición del for debe ser de tipo bool.", context.Start);
        }

        while (condicion is BoolValue boolCondicion && boolCondicion.Value)
        {
            try
            {
                Visit(context.sentencia());
            }
            catch (BreakException)
            {
                break;
            }
            catch (ContinueException)
            {
                condicion = Visit(context.expresion());
                continue;
            }

            condicion = Visit(context.expresion());
        }

        return defaultValue;
    }



    // VisitForStmt

    public override ValueWrapper VisitForStmt(LanguageParser.ForStmtContext context)
    {
        Environment entornoPrevio = entornoActual;
        entornoActual = new Environment(entornoPrevio);

        Visit(context.forInit());

        //Body 
        VisitBodyFor(context);
        entornoActual = entornoPrevio;
        return defaultValue;
    }

    public void VisitBodyFor(LanguageParser.ForStmtContext context)
    {
        ValueWrapper condicion = Visit(context.expresion(0));

        var entornoPrevio = entornoActual;

        if (condicion is not BoolValue)
        {
            throw new SemanticError("La condición del for debe ser de tipo bool.", context.Start);
        }

        while (condicion is BoolValue boolCondicion && boolCondicion.Value)
        {
            try
            {
                Visit(context.sentencia());
            }
            catch (BreakException)
            {
                entornoActual = entornoPrevio;
                break;
            }
            catch (ContinueException)
            {
                entornoActual = entornoPrevio;
                Visit(context.expresion(1));

                condicion = Visit(context.expresion(0));
                continue;
            }

            Visit(context.expresion(1)); 
            condicion = Visit(context.expresion(0)); 
        }
    }



    // VisitForRangeStmt
    public override ValueWrapper VisitForRangeStmt(LanguageParser.ForRangeStmtContext context)
    {
        var Indice = context.indice.Text;
        var Valor = context.valor.Text;
        var Slice = context.ident.Text;

        ValueWrapper Arreglo = entornoActual.GetVariable(Slice, context.Start);

        if (Arreglo is not ValueWrapper arr)
            throw new SemanticError($"Sentencia For Range: La variable '{Slice}' no es un arreglo", context.Start);


        var sliceValue = arr as SliceValue;
        if (sliceValue == null)
        {
            throw new SemanticError($"Sentencia For Range: La variable '{Slice}' no es un slice", context.Start);
        }

        Environment entornoPrevio = entornoActual;

        for (int i = 0; i < sliceValue.Values.Count; i++)
        {
           
            entornoActual = new Environment(entornoPrevio);

            entornoActual.DeclaracionVariable(Indice, new IntValue(i), "Variable", context.Start.Line, context.Start.Column, context.Start);
            entornoActual.DeclaracionVariable(Valor, sliceValue.Values[i], "Variable", context.Start.Line, context.Start.Column, context.Start);

            try
            {   
                Visit(context.sentencia());
            }
            catch (BreakException)
            {
                entornoActual = entornoPrevio;
                break;
            }
            catch (ContinueException)
            {
                entornoActual = entornoPrevio;
                continue;
            }

            entornoActual = entornoPrevio;
        }

        entornoActual = entornoPrevio;
        return defaultValue;
    }




  
    private string ObtenerTipo(ValueWrapper valor)
    {
        return valor switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            RunValue => "rune",
            NilValue => "nil",
            VoidValue => "void",
            SliceValue slice => $"slice<{slice.Tipo}>",
            StructValue structValue => structValue.StructName,
            _ => "desconocido"
        };
    }


    // VisitCallee
    public override ValueWrapper VisitCallee(LanguageParser.CalleeContext context)
    {
        ValueWrapper callee = Visit(context.expresion());

        foreach (var call in context.call())
        {
            if (callee is FunctionValue functionValue)
            {
                callee = VisitCall(functionValue.invocable, call.args());
            }
            else
            {
                throw new SemanticError("Llamada de función inválida", context.Start);
            }
        }

        return callee;
    }

    public ValueWrapper VisitCall(Invocable invocable, LanguageParser.ArgsContext context)
    {

        List<ValueWrapper> arguments = new List<ValueWrapper>();

        if (context != null)
        {
            foreach (var expr in context.expresion())
            {
                arguments.Add(Visit(expr));
            }
        }

        if (context != null && arguments.Count != invocable.Arity())
        {
            throw new SemanticError($"Número incorrecto de argumentos en la llamada a la función. Se esperaban {invocable.Arity()} argumentos, pero se recibieron {arguments.Count}", context.Start);
        }


        return invocable.Invoke(arguments, this);

    }

    // VisitdeclaracionFuncForanea

    public override ValueWrapper VisitDeclaracionFuncForanea(LanguageParser.DeclaracionFuncForaneaContext context)
    {   
        var foranea = new FuncForeign(entornoActual, context);
        entornoActual.DeclaracionVariable(context.ID().GetText(), new FunctionValue(foranea, context.ID().GetText()), "Función", context.Start.Line, context.Start.Column, context.Start);
        return defaultValue;
    }



}

