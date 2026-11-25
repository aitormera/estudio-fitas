# Conversor (ºC → ºF, € → $...)

**Enunciat:** EditText (graus Celsius) i botó "Convertir". Toast: "X ºC són Y ºF".

**Si te piden otra cosa:**

- ºF → ºC: `(f - 32) * 5 / 9`.
- € → $: `euros * 1.08` (o el valor que den). Km → millas: `km * 0.621371`.
- `String.format("%.2f", x)` = 2 decimales. Ojo: en el emulador en catalán/español puede salir con coma.
