# Day 4: Exceptions

## 1. The Hierarchy
Everything inherits from `Throwable`.
1. **Error:** Serious system crashes (Out of Memory). We can't fix these.
2. **Exception:** Things we can handle.

## 2. Checked vs Unchecked (Crucial Interview Question)
*   **Checked Exception (Compile Time):**
    *   Java forces you to handle it (`try-catch`) or the code won't compile.
    *   Example: `IOException`, `SQLException`.
    *   *Analogy:* The compiler says, "This file might not exist, tell me what to do if it's missing!"

*   **Unchecked Exception (Runtime Time):**
    *   Java doesn't force you. It usually happens due to bad logic.
    *   Example: `NullPointerException`, `IndexOutOfBoundsException`, `ArithmeticException`.
    *   *Analogy:* You tried to divide by zero. That's your fault.

## 3. Keywords
*   `try`: "Attempt this risky code."
*   `catch`: "If it fails, do this instead of crashing."
*   `finally`: "Do this no matter what (clean up)."
*   `throw`: "Manually trigger an error."
*   `throws`: "Warn the method caller that this might fail."