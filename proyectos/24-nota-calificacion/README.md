# Nota → Suspès / Aprovat / Notable / Excel·lent

**Enunciat:** EditText (nota 0-10) i botó. Toast: <5 Suspès, <7 Aprovat, <9 Notable, si no Excel·lent.

**Si te piden otra cosa:**

- Si solo piden aprobado/suspenso, deja solo `if (nota < 5) ... else ...`.
- Nota entera → `Int?` y `toIntOrNull()`.
