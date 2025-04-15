using System.Collections.Generic;

public class StandardLibrary
{
    private readonly HashSet<string> UsedFunctions = new HashSet<string>();

    public void Use(string function)
    {
        UsedFunctions.Add(function);
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


        return string.Join("\n\n", functions);
    }

    private readonly static Dictionary<string, string> FunctionDefinitions = new Dictionary<string, string>
    {
        { "print_integer", @"
//--------------------------------------------------------------
// print_integer - Prints a signed integer to stdout
//
// Input:
//   x0 - The integer value to pBooleanrint
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
    // Add newline
    //mov w24, #10               Newline character
    //strb w24, [x22, x23]       Add to end of buffer
    //add x23, x23, #1           Increment counter
    
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

minus_sign:
    .ascii ""-""               // Minus sign"
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
}



    };
}