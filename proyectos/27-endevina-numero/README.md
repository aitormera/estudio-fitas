# Adivina el número (aleatorio)

**Enunciat:** EditText i botó "Provar". L'app genera un número de 1 a 100. Toast "És més gran", "És més petit" o "Has encertat!".

**Si te piden otra cosa:**

- `Random.nextInt(1, 101)` = de 1 a 100 (el segundo número NO entra).
- Contar intentos → `var intentos: Int = 0` fuera del listener, `intentos++` dentro y `"Has encertat en " + intentos + " intents"`.
