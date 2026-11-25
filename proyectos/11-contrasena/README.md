# Comprobar contraseña

**Enunciat:** EditText (contrasenya) i botó "Entrar". Si és "1234" → Toast "Correcte", si no → "Incorrecte".

**Si te piden otra cosa:**

- `inputType="textPassword"` hace que salgan puntitos. Si no lo piden, usa `text`.
- Ignorando mayúsculas → `texto.equals("admin", ignoreCase = true)`.
- Usuario + contraseña → dos EditText y `if (usuari == "admin" && pass == "1234")`.
