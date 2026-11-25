# Dos EditText: nombre y apellido

**Enunciat:** Dos EditText (nom i cognom) i botó "Unir". Toast: "<nom> <cognom>".

**Si te piden otra cosa:**

- Si alguno vacío → `if (nom.isBlank() || cognom.isBlank()) { Toast "Omple tots els camps" }`.
- Comparar si son iguales → `if (nom == cognom)` (en Kotlin `==` compara el contenido de Strings).
