# Contar caracteres

**Enunciat:** EditText i botó "Comptar". Toast: "El text té N caràcters".

**Si te piden otra cosa:**

- Sin contar espacios → `texto.replace(" ", "").length`.
- Si piden "llarg"/"curt": `if (longitud > 10) "Text llarg" else "Text curt"`.
- OJO: `"texto " + numero` funciona; `numero + " texto"` NO compila. Empieza siempre por un String.
