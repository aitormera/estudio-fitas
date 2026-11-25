# Contiene / empieza por / acaba en

**Enunciat:** EditText i botó "Comprovar". Si el text conté "hola" → Toast "Conté hola", si no → "No conté hola".

**Si te piden otra cosa:**

- Empieza por → `texto.startsWith("A")`. Acaba en → `texto.endsWith(".")`.
- Email válido (básico) → `texto.contains("@") && texto.contains(".")`.
- Quita `ignoreCase = true` si debe distinguir mayúsculas.
