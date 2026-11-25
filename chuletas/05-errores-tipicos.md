# 05 · Errores típicos y cómo arreglarlos rápido

| Síntoma | Causa | Arreglo |
|---|---|---|
| `R` en rojo / `Unresolved reference: R` | La línea `package` no coincide con el namespace, o falta sincronizar | Revisa la 1ª línea del .kt = `namespace` del build.gradle. Luego **Build → Rebuild Project** |
| `Unresolved reference: editText` (en `R.id.editText`) | El id del XML es otro | Haz que `@+id/xxx` del XML y `R.id.xxx` del Kotlin sean iguales |
| Una clase en rojo (Toast, Button...) | Falta el import | Cursor encima → **Alt + Enter** → Import |
| `None of the following functions can be called...` en un `+` | Empiezas a concatenar por un número | `"texto " + numero` o `numero.toString() + "..."` |
| `Type mismatch: inferred type is Int but CharSequence` | `textView.text = numero` | `textView.text = numero.toString()` |
| La app se cierra al pulsar el botón | `toInt()` con el campo vacío o con letras | Usa `toIntOrNull()` y comprueba `null` |
| La app se cierra al abrirse | `findViewById` de un id que no existe en el XML | Revisa ids |
| `Val cannot be reassigned` | Has usado `val` y la cambias | Cámbiala a `var` |
| El botón sale en MAYÚSCULAS | Tema Material | `android:textAllCaps="false"` |
| `7 / 2` da 3 | División de enteros | Usa `Double` o `7 / 2.0` |
| El test falla pero la app funciona | Texto no idéntico o algo de más | Compara letra a letra con el enunciado (espacios, acentos, `:`) y quita lo que sobre |
| El test no conecta | Appium no está corriendo | Terminal: `appium &` |
| Gradle tarda/se queda colgado | Primer sync | Espera; si no, **File → Invalidate Caches / Restart** |
| He roto el archivo | — | Clic derecho → **Local History → Show History** → Revert. O Ctrl+Z |

## Atajos de Android Studio (Linux)

| Acción | Atajo |
|---|---|
| Importar / arreglo rápido | Alt + Enter |
| Formatear código | Ctrl + Alt + L |
| Buscar en el archivo | Ctrl + F |
| Ejecutar | Shift + F10 |
| Deshacer | Ctrl + Z |
