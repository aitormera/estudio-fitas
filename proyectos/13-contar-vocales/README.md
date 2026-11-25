# Contar vocales

**Enunciat:** EditText i botó "Vocals". Toast: "Té N vocals".

**Si te piden otra cosa:**

- Contar una letra concreta → `if (c == 'a')` (comillas simples = Char).
- Consonantes → `if (c.isLetter() && !"aeiou...".contains(c))`.
- Contar espacios → `if (c == ' ')`.
