using System.ComponentModel;
using analyzer;

public class FuncForeign : Invocable
{
   private Environment clousure;
   private LanguageParser.DeclaracionFuncForaneaContext context;

   private string TipoRetorno;
   private string NombreFuncion;

   private Antlr4.Runtime.IToken token;
   public FuncForeign(Environment clousure, LanguageParser.DeclaracionFuncForaneaContext context)
   {
      this.clousure = clousure;
      this.context = context;
      this.TipoRetorno = context.tipoDeclaracion()?.GetText() ?? "void";
      this.NombreFuncion = context.ID().GetText();
      this.token = context.Start;
   }

   public int Arity()
   {
      if (context.parametros() != null)
        {
            return context.parametros().ID().Length;
        }
        return 0;
   }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        var nuevoEntorno = new Environment(clousure);
        var EntornoAntesLlamada = visitor.entornoActual;
        visitor.entornoActual = nuevoEntorno;

        if (context.parametros() != null)
        {
            for (int i = 0; i < context.parametros().ID().Length; i++)
            {
                var parametroNombre = context.parametros().ID(i).GetText();
                var tipoEsperado = context.parametros().tipoFunc(i).GetText();

                for (int j = 0; j < i; j++)
                {
                    if (parametroNombre == context.parametros().ID(j).GetText())
                    {
                        throw new SemanticError($"El parámetro '{parametroNombre}' ya está declarado.", this.token);
                    }
                }

                if (!EsTipoCompatible(tipoEsperado, args[i]))
                {
                    throw new Exception($"Tipo incorrecto para el parámetro '{parametroNombre}'. Se esperaba '{tipoEsperado}' pero se recibió '{args[i].GetType().Name}'.");
                }

                nuevoEntorno.DeclaracionVariable(parametroNombre, args[i], "Parametro", context.parametros().ID(i).Symbol.Line, context.parametros().ID(i).Symbol.Column, this.token);
            }
        }

        try
        {
            foreach (var sentencia in context.dcl())
            {
                visitor.Visit(sentencia);
            }
        }
        catch (ReturnException e)
        {
            visitor.entornoActual = EntornoAntesLlamada;
            if (!EsTipoCompatible(TipoRetorno, e.Value))
            {
                throw new Exception($"Error de retorno: Se esperaba '{TipoRetorno}', pero se obtuvo un valor incompatible.");
            }
            return e.Value;
        }

        visitor.entornoActual = EntornoAntesLlamada;
        return visitor.defaultValue;
    }


    private bool EsTipoCompatible(string tipoEsperado, ValueWrapper argumento)
    {
        if (argumento is SliceValue slice)
        {
            Console.WriteLine($"Comparando slice: esperado = {tipoEsperado}, recibido = []{slice.Tipo}");

            // Permite que se pase un slice si el tipo esperado coincide con su contenido
            if (tipoEsperado == slice.Tipo) 
            {
                return true;
            }

            return tipoEsperado == $"[]{slice.Tipo}"; // Comparación normal
        }

        return tipoEsperado switch
        {
            "int" => argumento is IntValue,
            "float64" => argumento is FloatValue || argumento is IntValue,
            "string" => argumento is StringValue,
            "bool" => argumento is BoolValue,
            "rune" => argumento is RunValue,
            "void" => argumento is VoidValue,
            _ => false
        };
    }




}
