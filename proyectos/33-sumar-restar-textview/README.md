# Botones + y − con un TextView

**Enunciat:** TextView amb "0", botó "+" i botó "-". Cada botó suma o resta 1 al número del TextView.

**Si te piden otra cosa:**

- `textView.text = contador` NO compila: hay que poner `contador.toString()`.
- Que no baje de 0 → `if (contador > 0) { contador-- }`.
- Botón Reset → otro botón con `contador = 0` y `textView.text = "0"`.
