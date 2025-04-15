.data
heap: .space 4096
.text
.global _start
_start:
    adr x10, heap
// Variable explícita: a
// Boolean constant: False
MOV x0, #0
STR x0, [SP, #-8]!
LDR x0, [SP], #8
STR x0, [SP, #-8]!
// Variable explícita: b
// Boolean constant: False
MOV x0, #0
STR x0, [SP, #-8]!
LDR x0, [SP], #8
STR x0, [SP, #-8]!
// Print statement
// Lado izquierdo del AND
// Identifier: a
MOV x0, #8
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #0
B.EQ and_false_0
// Lado derecho del AND
// Identifier: b
MOV x0, #0
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #0
B.EQ and_false_0
MOV x0, #1
B and_end_1
and_false_0:
MOV x0, #0
and_end_1:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_bool
MOV w0, #10
STRB w0, [x10]
MOV x0, #1
MOV x1, x10
MOV x2, #1
MOV w8, #64
SVC #0
// Print statement
// Lado izquierdo del OR
// Identifier: a
MOV x0, #8
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #1
B.EQ or_true_2
// Lado derecho del OR
// Identifier: b
MOV x0, #0
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #1
B.EQ or_true_2
MOV x0, #0
B or_end_3
or_true_2:
MOV x0, #1
or_end_3:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_bool
MOV w0, #10
STRB w0, [x10]
MOV x0, #1
MOV x1, x10
MOV x2, #1
MOV w8, #64
SVC #0
// Print statement
// Operador lógico NOT
// Identifier: a
MOV x0, #8
ADD x0, sp, x0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #0
B.EQ not_true_4
MOV x0, #0
B not_end_5
not_true_4:
MOV x0, #1
not_end_5:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_bool
MOV w0, #10
STRB w0, [x10]
MOV x0, #1
MOV x1, x10
MOV x2, #1
MOV w8, #64
SVC #0
MOV x0, #0
MOV x8, #93
SVC #0



// Standard Library Functions

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
    .ascii  "true"

    .balign 4
false_str:
    .ascii  "false"

