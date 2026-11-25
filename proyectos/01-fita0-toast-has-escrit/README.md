# Fita 0: Toast "Has escrit ..." (EL EXAMEN REAL)

**Enunciat:** Crea un botó amb text "Toast" i un EditText. Quan cliquem el botó apareixerà un Toast amb el text "Has escrit <contingut del EditText>".

**Si te piden otra cosa:**

- Otro texto del botón → cambia `android:text="Toast"` en el XML.
- Otro mensaje → cambia `"Has escrit " + texto`. Respeta EXACTAMENTE espacios, mayúsculas y signos del enunciado (el test compara el texto).
- Toast más largo en pantalla → `Toast.LENGTH_LONG`.
- Si el orden en el enunciado es primero EditText y luego botón, cambia el orden en el XML (normalmente da igual para el test, pero mejor igual que el enunciado).
