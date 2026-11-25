# Contador de clics

**Enunciat:** Un botó "Clica". Cada clic mostra Toast "Has clicat N vegades".

**Si te piden otra cosa:**

- La variable `contador` va FUERA del `setOnClickListener` (si no, vuelve a 0 en cada clic).
- Mostrarlo en el propio botón → `button.text = "Clics: " + contador`.
- Cada 5 clics algo especial → `if (contador % 5 == 0)`.
