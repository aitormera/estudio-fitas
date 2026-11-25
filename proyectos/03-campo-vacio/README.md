# Avisar si el EditText está vacío

**Enunciat:** Botó "Enviar" i un EditText. Si el camp és buit, Toast "El camp està buit". Si no, Toast "Has escrit <text>".

**Si te piden otra cosa:**

- `isBlank()` = vacío o solo espacios. `isEmpty()` = vacío de verdad ("   " NO cuenta como vacío).
- Para marcar error en el propio campo en vez de Toast: `editText.error = "Camp obligatori"`.
