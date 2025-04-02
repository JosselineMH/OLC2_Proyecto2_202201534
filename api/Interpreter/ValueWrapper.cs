public abstract record ValueWrapper;

public record IntValue (int Value): ValueWrapper;
public record FloatValue (float Value): ValueWrapper;
public record StringValue (string Value): ValueWrapper;
public record BoolValue (bool Value): ValueWrapper;
public record RunValue (char Value): ValueWrapper;
public record VoidValue : ValueWrapper;
public record NilValue : ValueWrapper;

public record SliceValue(List<ValueWrapper> Values, string Tipo) : ValueWrapper;
public record FunctionValue(Invocable invocable, string name) : ValueWrapper;


public record StructValue(Dictionary<string, ValueWrapper> Attributes, string StructName) : ValueWrapper
{
    public ValueWrapper GetAttribute(string attribute, Antlr4.Runtime.IToken token)
    {
        if (Attributes.TryGetValue(attribute, out var valor))
        {
            return valor;
        }
        throw new SemanticError($"El atributo '{attribute}' no existe en la estructura '{StructName}'.", token);
    }

    public void AssgnAttribute(string attribute, ValueWrapper valor, Antlr4.Runtime.IToken token)
    {
        if (!Attributes.ContainsKey(attribute))
        {
            throw new SemanticError($"El atributo '{attribute}' no existe en la estructura '{StructName}'.", token);
        }

        Attributes[attribute] = valor;
    }
}