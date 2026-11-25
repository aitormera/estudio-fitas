# Sumar dos números

**Enunciat:** Dos EditText numèrics i botó "Sumar". Toast: "La suma és <resultat>".

**Si te piden otra cosa:**

- Resta `num1 - num2`, multiplicación `num1 * num2`, resto `num1 % num2`.
- Decimales → cambia `Int?` por `Double?`, `toIntOrNull()` por `toDoubleOrNull()` y `inputType="numberDecimal|numberSigned"`.
- OJO: si no conviertes a número, `"2" + "3"` da "23" (concatena).
