using System.Collections.Specialized;
using System.ComponentModel;
using System.Text;

public class StackObject  
{
    public enum StackObjectType{Int, Float, String, Rune}
    public StackObjectType Type { get; set; }
    public int Lenght { get; set; }
    public int Depth { get; set; }
    public string? Id { get; set; }
    
}

public class ArmGenerator 
{
    public readonly List<string> Instructions = new List<string>();
    private readonly StandardLibrary stdLib = new StandardLibrary();

    private int depth = 0;
    private readonly List<StackObject> stack = new List<StackObject>();

    //---- stack operations
    public void PushObject(StackObject obj)
    {
        stack.Add(obj);
    }

    public void PushConstant(StackObject obj, object value)
    {
        switch(obj.Type) 
        {
            case StackObject.StackObjectType.Int:
                Mov(Register.X0, (int)value);
                Push(Register.X0);
                break;
            case StackObject.StackObjectType.Float:
               // codigo
                break;
            case StackObject.StackObjectType.String:
                List<byte> stringArray = Utils.StringToByteArray((string)value);
                Push(Register.HP);
                for (int i = 0; i < stringArray.Count; i++)
                {
                     var charCode = stringArray[i];
                     Comment($"Pushing char {charCode} to heap - ({(char) charCode})");

                     Mov("w0", charCode);
                     Strb("w0", Register.HP);
                     Mov(Register.X0, 1);
                     Add(Register.HP, Register.HP, Register.X0);
                }
                break;
        }

        PushObject(obj);
    }

    public StackObject PopObject(string rd)
    {
        var obj = stack.Last();
        stack.RemoveAt(stack.Count - 1);

        Pop(rd);
        return obj;
    }

    public StackObject IntObject()
    {
      return new StackObject
      {
          Type = StackObject.StackObjectType.Int,
          Lenght = 8,
          Depth = depth,
          Id = null
      };
    }

    public StackObject FloatObject()
    {
      return new StackObject
      {
            Type = StackObject.StackObjectType.Float,
            Lenght = 8,
            Depth = depth,
            Id = null
      };
   }

   public StackObject StringObject() 
   {
      return new StackObject
      {
            Type = StackObject.StackObjectType.String,
            Lenght = 8,
            Depth = depth,
            Id = null
      };
   }


   public StackObject CloneObject(StackObject obj)
   {
      return new StackObject
      {
         Type = obj.Type,
         Lenght = obj.Lenght,
         Depth = obj.Depth,
         Id = obj.Id
      };
   }

    //-----

    //---- Enviroment operations

    public void NewScope()
    {
        depth++;
    }

    public int endScope()
    {
         int byteOffset = 0;
         for (int i = stack.Count - 1; i >= 0; i--)
         {
            if (stack[i].Depth == depth)
            {
                byteOffset += stack[i].Lenght;
                stack.RemoveAt(i);
            }
            else 
            {
                break;
            }
         }

         depth--;
         return byteOffset;
    }


    public void TagObject(string id)
    {
         stack.Last().Id = id;
    }

   public (int, StackObject) GetObject(string id)
   {
      int byteOffset = 0;
      for (int i = stack.Count - 1; i >= 0; i--)
      {
         if (stack[i].Id == id)
         {
            return (byteOffset, stack[i]);
         }

         byteOffset += stack[i].Lenght;
      }

        throw new Exception($"Object {id} not found");
    }
    //-----


    public void Add(string rd, string rs1, string rs2)
    {
       Instructions.Add($"ADD {rd}, {rs1}, {rs2}");
    }

    public void Sub(string rd, string rs1, string rs2)
    {
       Instructions.Add($"SUB {rd}, {rs1}, {rs2}");
    }

    public void Mul(string rd, string rs1, string rs2)
    {
       Instructions.Add($"MUL {rd}, {rs1}, {rs2}");
    }

    public void Div(string rd, string rs1, string rs2)
    {
       Instructions.Add($"SDIV {rd}, {rs1}, {rs2}");
    }

    public void Addi(string rd, string rs1, int imm)
    {
       Instructions.Add($"ADDI {rd}, {rs1}, #{imm}");
    }

    public void Mod(string rd, string rs1, string rs2)
    {
        Instructions.Add($"UDIV {Register.X9}, {rs1}, {rs2}");     // temp = rs1 / rs2
        Instructions.Add($"MSUB {rd}, {Register.X9}, {rs2}, {rs1}"); // rd = rs1 - (temp * rs2)
    }

    // Memory operations
    public void Str(string rs1, string rs2, int offset = 0)
    {
       Instructions.Add($"STR {rs1}, [{rs2}, #{offset}]");
    }

    public void Strb(string rs1, string rs2)
    {
       Instructions.Add($"STRB {rs1}, [{rs2}]");
    }

    public void Ldr(string rd, string rs1, int offset = 0)
    {
       Instructions.Add($"LDR {rd}, [{rs1}, #{offset}]");
    }

    public void Mov(string rd, int imm)
    {
       Instructions.Add($"MOV {rd}, #{imm}");
    }


    public void Push(string rs)
    {
       Instructions.Add($"STR {rs}, [SP, #-8]!");
    }

    public void Pop(string rd)
    {
       Instructions.Add($"LDR {rd}, [SP], #8");
    }

    public void Svc()
    {
       Instructions.Add($"SVC #0");
    }

    public void EndProgram()
    {
       Mov(Register.X0, 0);
       Mov(Register.X8, 93); //syscall number for exit
       Svc();
    }

    public void PrintInt(string rs)
    {
       stdLib.Use("print_integer");
       Instructions.Add($"MOV X0, {rs}");
       Instructions.Add($"BL print_integer");
    }

    public void PrintString(string rs)
    {
       stdLib.Use("print_string");
       Instructions.Add($"MOV X0, {rs}");
       Instructions.Add($"BL print_string");
    }

    public void Comment(string comment)
    {
       Instructions.Add($"// {comment}");
    }

    public override string ToString()
    {
       var sb = new StringBuilder();
       sb.AppendLine(".data");
       sb.AppendLine("heap: .space 4096");
       sb.AppendLine(".text");
       sb.AppendLine(".global _start");
       sb.AppendLine("_start:");
       sb.AppendLine("    adr x10, heap");

       EndProgram();
       foreach (var instruction in Instructions)
       {
          sb.AppendLine(instruction);
       }


        sb.AppendLine("\n\n\n// Standard Library Functions");
        sb.AppendLine(stdLib.GetFunctionDefinitions());

       return sb.ToString();
    }
}