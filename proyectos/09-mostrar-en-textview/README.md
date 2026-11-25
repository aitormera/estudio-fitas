# Mostrar en un TextView (en vez de Toast)

**Enunciat:** EditText, botó "Mostrar" i un TextView. En clicar, el TextView mostra "Has escrit <text>".

**Si te piden otra cosa:**

- Toast Y TextView a la vez → añade la línea del Toast debajo.
- Añadir en vez de sustituir (historial) → `textView.text = textView.text.toString() + texto + "\n"`.
- Texto inicial del TextView → `android:text="..."` en el XML.
