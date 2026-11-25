# Saludo con el nombre

**Enunciat:** EditText per al nom i botó "Saludar". Toast: "Hola, <nom>!".

**Si te piden otra cosa:**

- Si cambias el id en el XML (`@+id/editNom`) cambia también `R.id.editNom` en el Kotlin. Tienen que coincidir.
- Equivalente con plantilla: `"Hola, $nom!"` (hace lo mismo que con +).
