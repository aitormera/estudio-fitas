# Toast en MAYÚSCULAS / minúsculas

**Enunciat:** EditText i botó "Majúscules". En clicar, Toast amb el text escrit en majúscules.

**Si te piden otra cosa:**

- Minúsculas → `texto.lowercase()`.
- Primera letra en mayúscula → `texto.replaceFirstChar { it.uppercase() }`.
- Con prefijo → `"Has escrit " + texto.uppercase()`.
