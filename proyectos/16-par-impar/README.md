# Par o impar

**Enunciat:** EditText numèric i botó "Comprovar". Toast "<n> és parell" o "<n> és senar".

**Si te piden otra cosa:**

- Catalán: par = **parell**, impar = **senar**. Castellano: par / impar.
- Múltiplo de 3 → `numero % 3 == 0`. Múltiplo de 5 → `% 5`.
- `toIntOrNull()` devuelve null si no es número (no peta). `toInt()` peta si está vacío.
- Solo positivos → `inputType="number"`; con negativos → `numberSigned`.
