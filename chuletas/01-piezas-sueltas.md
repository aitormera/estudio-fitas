# 01 · Piezas sueltas (para montar cualquier ejercicio)

## Plantilla base de MainActivity.kt

Pega esto y rellena el hueco. Los imports que no uses solo salen en gris, no pasa nada.

```kotlin
package com.ieti.fitatest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) findViewById de cada elemento
        // 2) setOnClickListener de cada botón
    }

    // funciones auxiliares aquí (opcional)
}
```

## Plantilla base de activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- pega aquí los elementos, se ponen uno debajo de otro -->

</LinearLayout>
```

Uno al lado del otro → `android:orientation="horizontal"`.

---

## Elementos del XML

```xml
    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="text" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Toast" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:text="" />
```

- `android:textAllCaps="false"` → el botón muestra "Toast" y no "TOAST". Déjalo siempre.
- `android:hint="Escriu aquí"` → texto gris de ayuda. **No lo pongas si no lo piden** (el tester podría leerlo como texto).

### inputType (tipo de teclado del EditText)

| Quieres | inputType |
|---|---|
| Texto normal | `text` |
| Nombre | `textPersonName` |
| Contraseña (puntitos) | `textPassword` |
| Email | `textEmailAddress` |
| Entero positivo | `number` |
| Entero con negativos | `numberSigned` |
| Decimal | `numberDecimal` |
| Decimal con negativos | `numberDecimal\|numberSigned` (en el XML sin la `\`) |

---

## Kotlin: lo que vas a usar siempre

```kotlin
// Conectar con el XML (el id tiene que coincidir con @+id/...)
val editText: EditText = findViewById(R.id.editText)
val button: Button = findViewById(R.id.button)
val textView: TextView = findViewById(R.id.textView)

// Al pulsar el botón
button.setOnClickListener {
    // código
}

// Leer el EditText
val texto: String = editText.text.toString()

// Toast
Toast.makeText(this, "Mensaje", Toast.LENGTH_SHORT).show()
Toast.makeText(this, "Has escrit " + texto, Toast.LENGTH_LONG).show()

// Escribir en un TextView / EditText / Button
textView.text = "Hola"
editText.setText("")           // vaciar
button.text = "Nuevo texto"

// Número desde el EditText
val numero: Int? = editText.text.toString().toIntOrNull()       // null si no es número
val decimal: Double? = editText.text.toString().toDoubleOrNull()
val numeroO0: Int = editText.text.toString().toIntOrNull() ?: 0  // 0 si no es número

// Número → texto
textView.text = numero.toString()
```

## Concatenar (lo que más falla)

```kotlin
"Tienes " + edad + " años"        // ✅ empieza por String
edad.toString() + " años"         // ✅
edad + " años"                    // ❌ NO compila (empieza por Int)
"Total: " + (a + b)               // ✅ suma y luego concatena
"Total: " + a + b                 // ❌ da "Total: 23"
"Tienes $edad años"               // ✅ plantilla Kotlin, lo mismo
"Total: ${a + b}"                 // ✅
```

## Condiciones

```kotlin
if (x > 0) { ... } else if (x < 0) { ... } else { ... }

==  !=  >  <  >=  <=        &&  (y)    ||  (o)    !  (no)

numero in 1..10             // entre 1 y 10 (incluidos)
texto == "hola"             // comparar Strings
texto.isBlank()             // vacío o solo espacios
```

`when` (como un switch):

```kotlin
val mensaje: String = when (numero) {
    1 -> "Un"
    2 -> "Dos"
    in 3..9 -> "Entre 3 i 9"
    else -> "Un altre"
}
```

## Bucles

```kotlin
for (i in 1..10) { }            // 1 a 10
for (i in 1 until 10) { }       // 1 a 9
for (i in 10 downTo 1) { }      // cuenta atrás
for (i in 0..20 step 2) { }     // de 2 en 2
for (c in texto) { }            // cada letra (Char)
```

## Funciones de String útiles

| Quiero | Código |
|---|---|
| Mayúsculas / minúsculas | `texto.uppercase()` / `texto.lowercase()` |
| Longitud | `texto.length` |
| Al revés | `texto.reversed()` |
| Quitar espacios extremos | `texto.trim()` |
| Contiene | `texto.contains("x")` |
| Empieza / acaba | `texto.startsWith("x")` / `texto.endsWith("x")` |
| Reemplazar | `texto.replace("a", "b")` |
| Primera letra | `texto[0]` (peta si está vacío) |
| Repetir | `texto.repeat(3)` |
| Igual sin mirar mayúsculas | `texto.equals("Hola", ignoreCase = true)` |

## Números útiles

```kotlin
a % b               // resto (par: numero % 2 == 0)
maxOf(a, b)  minOf(a, b)
Math.abs(x)         // valor absoluto
Math.sqrt(x)        // raíz (Double)
Math.pow(x, 2.0)    // potencia (Double)
Random.nextInt(1, 101)          // 1..100
String.format("%.2f", x)        // 2 decimales
```

## Variable que se mantiene entre clics

Declárala con `var` **fuera** del `setOnClickListener`:

```kotlin
var contador: Int = 0
button.setOnClickListener {
    contador++
}
```

---

## Tabla rápida: "si piden X → cambia Y"

| Piden | Cambia |
|---|---|
| Otro ID de app | Package name al crear el proyecto + 1ª línea `package` del .kt |
| Otro texto en el botón | `android:text` del `<Button>` |
| Otro mensaje del Toast | El String dentro de `Toast.makeText(this, AQUÍ, ...)` |
| Resultado en pantalla y no en Toast | Añade `<TextView>` y `textView.text = ...` |
| Que el Toast dure más | `Toast.LENGTH_LONG` |
| Solo números en el campo | `android:inputType="number"` |
| Vaciar el campo después | `editText.setText("")` al final del listener |
| Otro botón | `<Button>` con otro id + `findViewById` + `setOnClickListener` |
| Validar vacío | `if (texto.isBlank()) { Toast error } else { ... }` |
| Validar número | `toIntOrNull()` y `if (numero == null)` |
