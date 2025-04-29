using System.Collections.Generic;

public class StandardLibrary
{
    private readonly HashSet<string> UsedFunctions = new HashSet<string>();
    private readonly HashSet<string> UsedSymbols = new HashSet<string>();

    public void Use(string function)
    {
        UsedFunctions.Add(function);

        if (function == "print_integer")
        {
            UsedSymbols.Add("minus_sign");
        }
        else if (function == "print_double")
        {
            UsedSymbols.Add("dot_char");
            UsedSymbols.Add("zero_char");
        }
    }

    public string GetFunctionDefinitions()
    {
        var functions = new List<string>();

        foreach (var function in UsedFunctions)
        {
            if (FunctionDefinitions.TryGetValue(function, out var definition))
            {
                functions.Add(definition);
            }
        }

        var fnDefs = string.Join("\n", functions);

        var symbols = new List<string>();
        foreach (var symbol in UsedSymbols)
        {
            if (Symbols.TryGetValue(symbol, out var definition))
            {
                symbols.Add(definition);
            }
        }
        var symbolsDefs = string.Join("\n", symbols);

        return fnDefs + "\n" + symbolsDefs;
    }

    private readonly static Dictionary<string, string> FunctionDefinitions = new Dictionary<string, string>
    {
        { "print_integer", @"
//--------------------------------------------------------------
// print_integer - Prints a signed integer to stdout
//
// Input:
//   x0 - The integer value to print
//--------------------------------------------------------------
print_integer:
    // Save registers
    stp x29, x30, [sp, #-16]!  // Save frame pointer and link register
    stp x19, x20, [sp, #-16]!  // Save callee-saved registers
    stp x21, x22, [sp, #-16]!
    stp x23, x24, [sp, #-16]!
    stp x25, x26, [sp, #-16]!
    stp x27, x28, [sp, #-16]!
    
    // Check if number is negative
    mov x19, x0                // Save original number
    cmp x19, #0                // Compare with zero
    bge positive_number        // Branch if greater or equal to zero
    
    // Handle negative number
    mov x0, #1                 // fd = 1 (stdout)
    adr x1, minus_sign         // Address of minus sign
    mov x2, #1                 // Length = 1
    mov w8, #64                // Syscall write
    svc #0
    
    neg x19, x19               // Make number positive
    
positive_number:
    // Prepare buffer for converting result to ASCII
    sub sp, sp, #32            // Reserve space on stack
    mov x22, sp                // x22 points to buffer
    
    // Initialize digit counter
    mov x23, #0                // Digit counter
    
    // Handle special case for zero
    cmp x19, #0
    bne convert_loop
    
    // If number is zero, just write '0'
    mov w24, #48               // ASCII '0'
    strb w24, [x22, x23]       // Store in buffer
    add x23, x23, #1           // Increment counter
    b print_result             // Skip conversion loop
    
convert_loop:
    // Divide the number by 10
    mov x24, #10
    udiv x25, x19, x24         // x25 = x19 / 10 (quotient)
    msub x26, x25, x24, x19    // x26 = x19 - (x25 * 10) (remainder)
    
    // Convert remainder to ASCII and store in buffer
    add x26, x26, #48          // Convert to ASCII ('0' = 48)
    strb w26, [x22, x23]       // Store digit in buffer
    add x23, x23, #1           // Increment digit counter
    
    // Prepare for next iteration
    mov x19, x25               // Quotient becomes the new number
    cbnz x19, convert_loop     // If number is not zero, continue
    
    // Reverse the buffer since digits are in reverse order
    mov x27, #0                // Start index
reverse_loop:
    sub x28, x23, x27          // x28 = length - current index
    sub x28, x28, #1           // x28 = length - current index - 1
    
    cmp x27, x28               // Compare indices
    bge print_result           // If crossed, finish reversing
    
    // Swap characters
    ldrb w24, [x22, x27]       // Load character from start
    ldrb w25, [x22, x28]       // Load character from end
    strb w25, [x22, x27]       // Store end character at start
    strb w24, [x22, x28]       // Store start character at end
    
    add x27, x27, #1           // Increment start index
    b reverse_loop             // Continue reversing
    
print_result:
    // Print the result
    mov x0, #1                 // fd = 1 (stdout)
    mov x1, x22                // Buffer address
    mov x2, x23                // Buffer length
    mov w8, #64                // Syscall write
    svc #0
    
    // Clean up and restore registers
    add sp, sp, #32            // Free buffer space
    ldp x27, x28, [sp], #16    // Restore callee-saved registers
    ldp x25, x26, [sp], #16
    ldp x23, x24, [sp], #16
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16    // Restore frame pointer and link register
    ret                        // Return to caller
    "
    },

    { "print_string", @"
//--------------------------------------------------------------
// print_string - Prints a null-terminated string to stdout
//
// Input:
//   x0 - The address of the null-terminated string to print
//--------------------------------------------------------------
print_string:
    // Save link register and other registers we'll use
    stp     x29, x30, [sp, #-16]!
    stp     x19, x20, [sp, #-16]!
    
    // x19 will hold the string address
    mov     x19, x0
    
print_loop:
    // Load a byte from the string
    ldrb    w20, [x19]
    
    // Check if it's the null terminator (0)
    cbz     w20, print_done
    
    // Prepare for write syscall
    mov     x0, #1              // File descriptor: 1 for stdout
    mov     x1, x19             // Address of the character to print
    mov     x2, #1              // Length: 1 byte
    mov     x8, #64             // syscall: write (64 on ARM64)
    svc     #0                  // Make the syscall
    
    // Move to the next character
    add     x19, x19, #1
    
    // Continue the loop
    b       print_loop
    
print_done:
    // Restore saved registers
    ldp     x19, x20, [sp], #16
    ldp     x29, x30, [sp], #16
    ret
    " },

    {
        "print_double", @"
//--------------------------------------------------------------
// print_double - Prints a double precision float to stdout
//
// Input:
//   d0 - The double value to print
//--------------------------------------------------------------
print_double:
    // Save context
    stp x29, x30, [sp, #-16]!    
    stp x19, x20, [sp, #-16]!
    stp x21, x22, [sp, #-16]!
    stp x23, x24, [sp, #-16]!
    
    // Check if number is negative
    fmov x19, d0
    tst x19, #(1 << 63)       // Comprueba el bit de signo
    beq skip_minus

    // Print minus sign
    mov x0, #1
    adr x1, minus_sign
    mov x2, #1
    mov x8, #64
    svc #0

    // Make value positive
    fneg d0, d0

skip_minus:
    // Convert integer part
    fcvtzs x0, d0             // x0 = int(d0)
    bl print_integer

    // Print dot '.'
    mov x0, #1
    adr x1, dot_char
    mov x2, #1
    mov x8, #64
    svc #0

    // Get fractional part: frac = d0 - float(int(d0))
    frintm d4, d0             // d4 = floor(d0)
    fsub d2, d0, d4           // d2 = d0 - floor(d0) (exact fraction)

    // Para 2.5, d2 debe ser exactamente 0.5

    // Multiplicar por 1_000_000 (6 decimales)
    movz x1, #0x000F, lsl #16
    movk x1, #0x4240, lsl #0   // x1 = 1000000
    scvtf d3, x1              // d3 = 1000000.0
    fmul d2, d2, d3           // d2 = frac * 1_000_000
    
    // Redondear al entero más cercano para evitar errores de precisión
    frintn d2, d2             // d2 = round(d2)
    fcvtzs x0, d2             // x0 = int(d2)

    // Imprimir ceros a la izquierda si es necesario
    mov x20, x0               // x20 = fracción entera
    movz x21, #0x0001, lsl #16
    movk x21, #0x86A0, lsl #0  // x21 = 100000
    mov x22, #0               // inicializar contador de ceros
    mov x23, #10              // constante para división

leading_zero_loop:
    udiv x24, x20, x21        // x24 = x20 / x21
    cbnz x24, done_leading_zeros  // Si hay un dígito no cero, salir del bucle

    // Imprimir '0'
    mov x0, #1
    adr x1, zero_char
    mov x2, #1
    mov x8, #64
    svc #0

    udiv x21, x21, x23        // x21 /= 10
    add x22, x22, #1          // incrementar contador de ceros
    cmp x21, #0               // verificar si llegamos al final
    beq print_remaining       // si divisor es 0, saltar a imprimir el resto
    b leading_zero_loop

done_leading_zeros:
    // Print the remaining fractional part
    mov x0, x20
    bl print_integer
    b exit_function

print_remaining:
    // Caso especial cuando la parte fraccionaria es 0 después de imprimir ceros
    cmp x20, #0
    bne exit_function
    
    // Ya imprimimos todos los ceros necesarios
    // No hace falta imprimir nada más

exit_function:
    // Restore context
    ldp x23, x24, [sp], #16
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret
    "},

    { "print_rune", @"
    .balign 4
print_rune:
//--------------------------------------------------------------
// print_rune - Prints a rune (ASCII char) to stdout
//
// Input:
//   x0 - The rune value to print
//--------------------------------------------------------------
    stp x29, x30, [sp, #-16]!   // Save frame pointer and link register
    sub sp, sp, #16             // Reserve stack space
    mov x1, sp                  // x1 = address to store rune
    strb w0, [x1]               // Store rune byte
    mov x0, #1                  // fd = stdout
    mov x2, #1                  // length = 1
    mov w8, #64                 // syscall: write
    svc #0
    add sp, sp, #16             // Release stack space
    ldp x29, x30, [sp], #16     // Restore frame pointer and return
    ret
" },
{ "print_bool", @"
//--------------------------------------------------------------
// print_bool - Prints a boolean as 'true' or 'false'
//
// Input:
//   x0 - The boolean value to print (0 = false, != 0 = true)
//--------------------------------------------------------------
    .balign 4
print_bool:
    stp     x29, x30, [sp, #-16]!

    cmp     x0, #0
    beq     print_false

    // Print 'true'
    adr     x1, true_str
    mov     x2, #4        // length of 'true'
    b       print_bool_cont

    .balign 4
print_false:
    adr     x1, false_str
    mov     x2, #5        // length of 'false'

print_bool_cont:
    mov     x0, #1        // fd = stdout
    mov     w8, #64       // syscall write
    svc     #0

    ldp     x29, x30, [sp], #16
    ret

    .balign 4
true_str:
    .ascii  ""true""

    .balign 4
false_str:
    .ascii  ""false""
" },
{
    "string_equals", @"
    // ----------------------------------------------------------
    // string_equals - Compara dos strings null-terminated
    // Entrada: x0 y x1 apuntan a los strings
    // Salida: x0 = 1 si son iguales, x0 = 0 si no
    // ----------------------------------------------------------
    .balign 4
string_equals:
    mov x2, x0      // x2 = string1
    mov x3, x1      // x3 = string2
eq_loop:
    ldrb w4, [x2]   // w4 = *x2
    ldrb w5, [x3]   // w5 = *x3
    cmp w4, w5
    b.ne eq_false
    cmp w4, #0      // ¿fin de string?
    b.eq eq_true
    add x2, x2, #1
    add x3, x3, #1
    b eq_loop
eq_true:
    mov x0, #1
    ret
eq_false:
    mov x0, #0
    ret
"
},
    { "string_to_integer", @"
   //--------------------------------------------------------------
// string_to_integer - Convierte una cadena de dígitos en un entero
//
// Input:
//   x0 - dirección del string null-terminated
// Output:
//   x0 - valor entero convertido
//--------------------------------------------------------------
    .balign 4
string_to_integer:
    stp x29, x30, [sp, #-16]!  // Save frame pointer and link register
    mov x1, x0          // x1 = pointer al string
    mov x2, #0          // x2 = resultado
    mov x3, #10         // x3 = constante 10

atoi_loop:
    ldrb w4, [x1], #1   // cargar byte y avanzar puntero
    cmp w4, #0          // ¿es null terminator?
    beq atoi_done

    sub w4, w4, #'0'    // convertir ASCII a valor numérico
    mul x2, x2, x3      // resultado *= 10
    add x2, x2, w4, uxtw    // resultado += dígito (corrección aquí)

    b atoi_loop

atoi_done:
    mov x0, x2          // mover resultado final a x0
    ldp x29, x30, [sp], #16  // restore frame pointer and link register
    ret
" },
    { "string_to_float", @"
//--------------------------------------------------------------
// string_to_float - Convierte una cadena de caracteres a float64
// Entrada: x0 = dirección del string null-terminated
// Salida: d0 = número flotante convertido
//--------------------------------------------------------------
.balign 4
string_to_float:
    stp x29, x30, [sp, #-16]!  // Save frame pointer and link register
    mov x1, x0          // x1 = puntero al string
    mov x2, #0          // x2 = acumulador parte entera
    mov x4, #0          // x4 = flag de punto decimal (0 = no visto, 1 = visto)
    mov x5, #1          // x5 = divisor para parte fraccionaria
    mov x8, #10         // x8 = constante 10

atoi_loop_float:
    ldrb w6, [x1], #1   // cargar byte y avanzar puntero
    cmp w6, #0          // fin de string
    beq atoi_done_float

    cmp w6, #46         // '.' ?
    beq decimal_point_found

    sub w6, w6, #'0'    // convertir ASCII a número
    cmp x4, #0
    beq accumulate_integer_part

    // Parte decimal
    uxtw x7, w6         // extender w6 a x7
    mul x7, x5, x7      // multiplicar por el divisor actual
    add x2, x2, x7      // acumular en x2
    mul x5, x5, x8      // actualizar divisor *= 10
    b atoi_loop_float

accumulate_integer_part:
    uxtw x7, w6         // extender w6 a x7
    mul x2, x2, x8      // acumulador *= 10
    add x2, x2, x7      // suma el dígito
    b atoi_loop_float

decimal_point_found:
    mov x4, #1          // visto el punto decimal
    b atoi_loop_float

atoi_done_float:
    // convertir entero a double
    scvtf d0, x2         // d0 = float(x2)
    ldp x29, x30, [sp], #16  // restore frame pointer and link register
    ret

" }

    };
    private readonly static Dictionary<string, string> Symbols = new Dictionary<string, string>
    {
        { "minus_sign", @"minus_sign: .ascii ""-""" },
        { "dot_char", @"dot_char: .ascii "".""" },
        { "zero_char", @"zero_char: .ascii ""0""" }
    };
}