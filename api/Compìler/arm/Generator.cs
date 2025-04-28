   using System.Collections.Specialized;
   using System.ComponentModel;
   using System.Text;


   public class StackObject
   {
      public enum StackObjectType { Int, Float, String, Rune, Bool, Array}
      public StackObjectType Type { get; set; }
      public int Lenght { get; set; }
      public int Depth { get; set; }
      public string? Id { get; set; }
      public StackObjectType? ElementType { get; set; }
   }

   public class ArmGenerator 
   {
      public readonly List<string> Instructions = new List<string>();
      private readonly StandardLibrary stdLib = new StandardLibrary();

      private int depth = 0;
      private readonly List<StackObject> stack = new List<StackObject>();
      private int labelCounter = 0;

      //---- stack operations

      public StackObject TopObject()
      {
         return stack.Last();
      }
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
                  double floatValue = (double)value;

                  long floatBits = BitConverter.DoubleToInt64Bits(floatValue);

                  ushort[] floatParts = new ushort[4];
                  for (int i = 0; i < 4; i++)
                  {
                     floatParts[i] = (ushort)((floatBits >> (i * 16)) & 0xFFFF);
                  }

                  Instructions.Add($"MOVZ X0, #{floatParts[0]}, LSL #0");
                  for (int i = 1; i < 4; i++)
                  {
                     Instructions.Add($"MOVK X0, #{floatParts[i]}, LSL #{i * 16}");
                  }

                  
                  Push(Register.X0);
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
               case StackObject.StackObjectType.Rune:
                  Mov(Register.X0, (int)value); 
                  Push(Register.X0);
                  break;

               case StackObject.StackObjectType.Bool:
                  Mov(Register.X0, ((bool)value) ? 1 : 0);
                  Push(Register.X0);
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

      public StackObject RuneObject()
      {
         return new StackObject
         {
            Type = StackObject.StackObjectType.Rune,
            Lenght = 8,
            Depth = depth,
            Id = null
         };
      }

      public StackObject BoolObject()
      {
         return new StackObject
         {
            Type = StackObject.StackObjectType.Bool,
            Lenght = 8,
            Depth = depth,
            Id = null
         };
      }

      public StackObject ArrayObject(StackObject.StackObjectType elementType)
      {
         return new StackObject
         {
            Type = StackObject.StackObjectType.Array,
            Lenght = 16,
            Depth = depth,
            Id = null,
            ElementType = elementType
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
      
      public void Mov(string rd, string rs)
      {
         Instructions.Add($"MOV {rd}, {rs}");
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

      // estos ya los empece a agregar 
   
      public void Ldrb(string rd, string rs)
      {
         Instructions.Add($"LDRB {rd}, [{rs}]");
      }

      //negacion unaria 
      public void Neg(string rd, string rs)
      {
         Instructions.Add($"NEG {rd}, {rs}");
      }

      //para las relacionales
      public void Cmp(string rs1, string rs2)
      {
         Instructions.Add($"CMP {rs1}, {rs2}");
      }

      public void Cbz(string rs, string label)
      {
         Instructions.Add($"CBZ {rs}, {label}");
      }

      public void Bgt(string label)
      {
         Instructions.Add($"B.GT {label}");
      }

      public void Bge(string label)
      {
         Instructions.Add($"B.GE {label}");
      }

      public void Blt(string label)
      {
         Instructions.Add($"B.LT {label}");
      }

      public void Ble(string label)
      {
         Instructions.Add($"B.LE {label}");
      }
      

      public void B(string label)
      {
         Instructions.Add($"B {label}");
      }

      public void Label(string label)
      {
         Instructions.Add($"{label}:");
      }


      // Comparación de igualdad
      public void Beq(string label)
      {
         Instructions.Add($"B.EQ {label}");
      }

      public void Bne(string label)
      {
         Instructions.Add($"B.NE {label}");
      }

      public void UseStdLib(string functionName)
      {
         stdLib.Use(functionName);
      }

      public void Bl(string label)
      {
         Instructions.Add($"BL {label}");
      }


      // Operaciones con flotantes

      public void Scvtf(string rd, string rs)
      {
         Instructions.Add($"SCVTF {rd}, {rs}");
      }

      public void Fmov(string rd, string rs)
      {
         Instructions.Add($"FMOV {rd}, {rs}");
      }

      public void Fadd(string rd, string rs1, string rs2)
      {
         Instructions.Add($"FADD {rd}, {rs1}, {rs2}");
      }

      public void Fsub(string rd, string rs1, string rs2)
      {
         Instructions.Add($"FSUB {rd}, {rs1}, {rs2}");
      }

      public void Fmul(string rd, string rs1, string rs2)
      {
         Instructions.Add($"FMUL {rd}, {rs1}, {rs2}");
      }
      public void Fdiv(string rd, string rs1, string rs2)
      {
         Instructions.Add($"FDIV {rd}, {rs1}, {rs2}");
      }

      public void Fcmp(string rd, string rs)
      {
         Instructions.Add($"FCMP {rd}, {rs}");
      }

      //-----

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

      public void PrintRune(string rs)
      {
         stdLib.Use("print_rune");
         Instructions.Add($"MOV X0, {rs}");
         Instructions.Add($"BL print_rune");
      }

      public void PrintBool(string rs)
      {
         stdLib.Use("print_bool");
         Instructions.Add($"MOV X0, {rs}");
         Instructions.Add($"BL print_bool");
      }

      public void PrintFloat()
      {
         stdLib.Use("print_integer");
         stdLib.Use("print_double");
         Instructions.Add($"BL print_double");
      }

      public void PrintArray(string baseAddressRegister, string elementType)
   {
      Comment("Imprimiendo arreglo");
      
      Ldr(Register.X1, baseAddressRegister, -8); 

      Mov(Register.X0, '[');
      PrintRune(Register.X0);
      
      string loopLabel = NewLabel("print_array_loop");
      string endLabel = NewLabel("print_array_end");
      string separatorLabel = NewLabel("print_separator");
      

      Cmp(Register.X1, "0");
      Beq(endLabel);
      
      Mov(Register.X2, 0); 

      Label(loopLabel);
      
      Mov(Register.X3, 8);
      Mul(Register.X4, Register.X2, Register.X3);
      Add(Register.X4, baseAddressRegister, Register.X4);

      Ldr(Register.X0, Register.X4);
      
      switch (elementType)
      {
         case "Int":
               PrintInt(Register.X0);
               break;
         case "Float":
               // PrintFloat(Register.X0);
               break;
         case "String":
               PrintString(Register.X0);
               break;
         case "Rune":
               PrintRune(Register.X0);
               break;
         case "Bool":
               PrintBool(Register.X0);
               break;
      }

      Add(Register.X2, Register.X2, "1");
      
      Cmp(Register.X2, Register.X1);
      Beq(endLabel);
      
      Mov(Register.X0, ',');
      PrintRune(Register.X0);
      Mov(Register.X0, ' ');
      PrintRune(Register.X0);
      
      B(loopLabel);

      Label(endLabel);
      
      Mov(Register.X0, ']');
      PrintRune(Register.X0);
   }

      

      public string NewLabel(string baseName)
      {
         return $"{baseName}_{labelCounter++}";
      }


      public void ConcatStrings(string left, string right)
      {
         Comment("Concatenación de strings");
         string loop1 = NewLabel("concat_loop1");
         string loop2 = NewLabel("concat_loop2");

         // Guarda dirección base del nuevo string
         Push(Register.HP);

         // Copia primer string
         Instructions.Add($"MOV x2, {left}");
         Instructions.Add($"// Copiar primer string");
         Instructions.Add($"{loop1}:");
         Instructions.Add("LDRB w3, [x2]");
         Instructions.Add("STRB w3, [x10]");
         Instructions.Add("ADD x2, x2, #1");
         Instructions.Add("ADD x10, x10, #1");
         Instructions.Add("CMP w3, #0");
         Instructions.Add($"B.NE {loop1}");

         // Copia segundo string
         Instructions.Add($"MOV x2, {right}");
         Instructions.Add("// Copiar segundo string");
         Instructions.Add("SUB x10, x10, #1"); 
         Instructions.Add($"{loop2}:");
         Instructions.Add("LDRB w3, [x2]");
         Instructions.Add("STRB w3, [x10]");
         Instructions.Add("ADD x2, x2, #1");
         Instructions.Add("ADD x10, x10, #1");
         Instructions.Add("CMP w3, #0");
         Instructions.Add($"B.NE {loop2}");

         // Recupera dirección base del resultado
         Pop(Register.X0);
      }



      public void Comment(string comment)
      {
         Instructions.Add($"// {comment}");
      }


      public void PrintNewLine()
      {
         Instructions.Add("MOV w0, #10");
         Instructions.Add("STRB w0, [x10]");
         Instructions.Add("MOV x0, #1");
         Instructions.Add("MOV x1, x10");
         Instructions.Add("MOV x2, #1");
         Instructions.Add("MOV w8, #64");
         Instructions.Add("SVC #0");
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