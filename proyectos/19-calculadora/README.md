# Calculadora con 4 botones

**Enunciat:** Dos EditText, botons "+", "-", "*", "/" i un TextView amb el resultat. Si es divideix per 0, Toast "No es pot dividir per 0".

**Si te piden otra cosa:**

- `?: 0.0` = si no es número, usa 0.
- Con enteros → `Int`, `toIntOrNull() ?: 0` y `if (num2 == 0)`. OJO: `7 / 2` con Int da 3.
- Resultado con 2 decimales → `String.format("%.2f", num1 / num2)`.
- Resultado en Toast → cambia `textResultat.text = ...` por el Toast (y borra el TextView del XML).
- Pon el resultado entre paréntesis: `"Resultat: " + (num1 + num2)`. Sin paréntesis concatena: "Resultat: 23".
