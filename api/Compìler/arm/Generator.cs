using System.Collections.Specialized;
using System.ComponentModel;
using System.Text;

public class ArmGenerator 
{
    public readonly List<string> Instructions = new List<string>();
    private readonly StandarLibrary stdLib = new StandarLibrary();

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

    public void Comment(string comment)
    {
       Instructions.Add($"// {comment}");
    }

    public override string ToString()
    {
       var sb = new StringBuilder();
       sb.AppendLine(".text");
       sb.AppendLine(".global _start");
       sb.AppendLine("_start:");

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