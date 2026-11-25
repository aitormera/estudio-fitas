# TODO EN UNO (usa Ctrl+F)

# 00 · Setup del examen (hazlo en este orden)

## 1. Antes del examen (en casa): bajar el repo a la VM

En la terminal de la VM de IsardVDI:

```bash
cd ~
git clone https://github.com/aitormera/estudio-fitas
```

Si no hay git: Firefox dentro de la VM → github.com/aitormera/estudio-fitas → **Code → Download ZIP** → descomprimir en `~`.

Para actualizar después: `cd ~/estudio-fitas && git pull`

Abre los `.md` con el editor de texto (o arrastra los `.kt`/`.xml` a Android Studio).

---

## 2. Arrancar Appium (lo pide el enunciado)

Abre una terminal y deja Appium corriendo en segundo plano:

```bash
appium &
```

No cierres esa terminal.

---

## 3. Crear el proyecto

1. Android Studio → **New Project** → **Empty Views Activity** (la de Views, NO "Empty Activity", que es Compose).
2. Rellena:
   - **Name:** lo que quieras (p. ej. `FitaTest`)
   - **Package name:** el ID del enunciado, p. ej. `com.ieti.fitatest` ⚠️ (bórralo y escríbelo entero; Android Studio lo autogenera a partir del Name)
   - **Language:** Kotlin
   - **Minimum SDK:** el que venga por defecto
3. **Finish** y espera a que acabe el Gradle Sync (barra de abajo).

### Comprobar el ID

Abre `app/build.gradle.kts` (o `build.gradle`) y mira que ponga:

```kotlin
namespace = "com.ieti.fitatest"
...
applicationId = "com.ieti.fitatest"
```

Si te equivocaste en el Package name, cambia **las dos** líneas aquí y la primera línea (`package ...`) de `MainActivity.kt`, y luego **File → Sync Project with Gradle Files**. Más fácil: borrar el proyecto y crearlo otra vez (1 min).

---

## 4. Pegar el código (2 archivos)

| Archivo | Dónde está |
|---|---|
| `activity_main.xml` | `app/res/layout/activity_main.xml` → pestaña **Code** (arriba a la derecha) |
| `MainActivity.kt` | `app/kotlin+java/com.ieti.fitatest/MainActivity.kt` |

- **XML:** selecciona todo (Ctrl+A) y pega el del ejercicio.
- **Kotlin:** selecciona todo y pega. La primera línea `package com.ieti.fitatest` tiene que ser el ID del enunciado. Si es otro ID, cambia solo esa línea.

---

## 5. Ejecutar y pasar el test

1. Elige el emulador arriba y pulsa ▶ **Run**.
2. Prueba a mano que hace lo que pide el enunciado.
3. Lanza el IOC Tester como os haya dicho el profe.

---

## 6. Checklist final (30 segundos)

- [ ] ID correcto (`applicationId` y `package`)
- [ ] Textos EXACTOS del enunciado (botón, Toast): mayúsculas, espacios, acentos, signos
- [ ] NADA que no pida el enunciado (ni botones, ni TextView, ni hints)
- [ ] Appium encendido
- [ ] La app compila y se abre


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


# Ejercicios con TEXTO (EditText + Toast)

Cada ejercicio: enunciado inventado, XML, Kotlin y qué cambiar si piden otra cosa.

---

## 01. Fita 0: Toast "Has escrit ..." (EL EXAMEN REAL)

**Enunciat:** Crea un botó amb text "Toast" i un EditText. Quan cliquem el botó apareixerà un Toast amb el text "Has escrit <contingut del EditText>".

Carpeta: `proyectos/01-fita0-toast-has-escrit/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Toast" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="text" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            Toast.makeText(this, "Has escrit " + texto, Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Otro texto del botón → cambia `android:text="Toast"` en el XML.
- Otro mensaje → cambia `"Has escrit " + texto`. Respeta EXACTAMENTE espacios, mayúsculas y signos del enunciado (el test compara el texto).
- Toast más largo en pantalla → `Toast.LENGTH_LONG`.
- Si el orden en el enunciado es primero EditText y luego botón, cambia el orden en el XML (normalmente da igual para el test, pero mejor igual que el enunciado).

---

## 02. Toast con texto fijo (sin EditText)

**Enunciat:** Crea un botó amb text "Saluda". Quan el cliquem ha de sortir un Toast amb el text "Hola món".

Carpeta: `proyectos/02-toast-texto-fijo/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Saluda" />

</LinearLayout>
```

**MainActivity.kt**

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

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this, "Hola món", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Si no hay EditText, NO lo pongas en el XML (el enunciado dice que no pongas nada más).
- Cambia `"Hola món"` por el texto que pidan.

---

## 03. Avisar si el EditText está vacío

**Enunciat:** Botó "Enviar" i un EditText. Si el camp és buit, Toast "El camp està buit". Si no, Toast "Has escrit <text>".

Carpeta: `proyectos/03-campo-vacio/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Enviar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            if (texto.isBlank()) {
                Toast.makeText(this, "El camp està buit", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Has escrit " + texto, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- `isBlank()` = vacío o solo espacios. `isEmpty()` = vacío de verdad ("   " NO cuenta como vacío).
- Para marcar error en el propio campo en vez de Toast: `editText.error = "Camp obligatori"`.

---

## 04. Toast en MAYÚSCULAS / minúsculas

**Enunciat:** EditText i botó "Majúscules". En clicar, Toast amb el text escrit en majúscules.

Carpeta: `proyectos/04-mayusculas-minusculas/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Majúscules" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            Toast.makeText(this, texto.uppercase(), Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Minúsculas → `texto.lowercase()`.
- Primera letra en mayúscula → `texto.replaceFirstChar { it.uppercase() }`.
- Con prefijo → `"Has escrit " + texto.uppercase()`.

---

## 05. Contar caracteres

**Enunciat:** EditText i botó "Comptar". Toast: "El text té N caràcters".

Carpeta: `proyectos/05-longitud-texto/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Comptar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            val longitud: Int = texto.length
            Toast.makeText(this, "El text té " + longitud + " caràcters", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Sin contar espacios → `texto.replace(" ", "").length`.
- Si piden "llarg"/"curt": `if (longitud > 10) "Text llarg" else "Text curt"`.
- OJO: `"texto " + numero` funciona; `numero + " texto"` NO compila. Empieza siempre por un String.

---

## 06. Texto al revés

**Enunciat:** EditText i botó "Invertir". Toast amb el text del revés (hola → aloh).

Carpeta: `proyectos/06-texto-al-reves/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Invertir" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            Toast.makeText(this, texto.reversed(), Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Al revés y en mayúsculas → `texto.reversed().uppercase()`.

---

## 07. Saludo con el nombre

**Enunciat:** EditText per al nom i botó "Saludar". Toast: "Hola, <nom>!".

Carpeta: `proyectos/07-saludo-nombre/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPersonName" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Saludar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNom: EditText = findViewById(R.id.editNom)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val nom: String = editNom.text.toString()
            Toast.makeText(this, "Hola, " + nom + "!", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Si cambias el id en el XML (`@+id/editNom`) cambia también `R.id.editNom` en el Kotlin. Tienen que coincidir.
- Equivalente con plantilla: `"Hola, $nom!"` (hace lo mismo que con +).

---

## 08. Toast y vaciar el EditText

**Enunciat:** EditText i botó "Enviar". Mostra Toast "Has escrit <text>" i després buida el camp.

Carpeta: `proyectos/08-borrar-tras-pulsar/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Enviar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            Toast.makeText(this, "Has escrit " + texto, Toast.LENGTH_SHORT).show()
            editText.setText("")
        }
    }
}
```

**Si te piden otra cosa:**

- Importante: lee el texto ANTES de borrarlo.
- Poner un texto por defecto → `editText.setText("Escriu aquí")`.

---

## 09. Mostrar en un TextView (en vez de Toast)

**Enunciat:** EditText, botó "Mostrar" i un TextView. En clicar, el TextView mostra "Has escrit <text>".

Carpeta: `proyectos/09-mostrar-en-textview/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Mostrar" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:text="" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            textView.text = "Has escrit " + texto
        }
    }
}
```

**Si te piden otra cosa:**

- Toast Y TextView a la vez → añade la línea del Toast debajo.
- Añadir en vez de sustituir (historial) → `textView.text = textView.text.toString() + texto + "\n"`.
- Texto inicial del TextView → `android:text="..."` en el XML.

---

## 10. Dos EditText: nombre y apellido

**Enunciat:** Dos EditText (nom i cognom) i botó "Unir". Toast: "<nom> <cognom>".

Carpeta: `proyectos/10-nombre-y-apellido/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/editCognom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPersonName" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Unir" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNom: EditText = findViewById(R.id.editNom)
        val editCognom: EditText = findViewById(R.id.editCognom)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val nom: String = editNom.text.toString()
            val cognom: String = editCognom.text.toString()
            Toast.makeText(this, nom + " " + cognom, Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Si alguno vacío → `if (nom.isBlank() || cognom.isBlank()) { Toast "Omple tots els camps" }`.
- Comparar si son iguales → `if (nom == cognom)` (en Kotlin `==` compara el contenido de Strings).

---

## 11. Comprobar contraseña

**Enunciat:** EditText (contrasenya) i botó "Entrar". Si és "1234" → Toast "Correcte", si no → "Incorrecte".

Carpeta: `proyectos/11-contrasena/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Entrar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            if (texto == "1234") {
                Toast.makeText(this, "Correcte", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrecte", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- `inputType="textPassword"` hace que salgan puntitos. Si no lo piden, usa `text`.
- Ignorando mayúsculas → `texto.equals("admin", ignoreCase = true)`.
- Usuario + contraseña → dos EditText y `if (usuari == "admin" && pass == "1234")`.

---

## 12. Contiene / empieza por / acaba en

**Enunciat:** EditText i botó "Comprovar". Si el text conté "hola" → Toast "Conté hola", si no → "No conté hola".

Carpeta: `proyectos/12-contiene-palabra/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString()
            if (texto.contains("hola", ignoreCase = true)) {
                Toast.makeText(this, "Conté hola", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No conté hola", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Empieza por → `texto.startsWith("A")`. Acaba en → `texto.endsWith(".")`.
- Email válido (básico) → `texto.contains("@") && texto.contains(".")`.
- Quita `ignoreCase = true` si debe distinguir mayúsculas.

---

## 13. Contar vocales

**Enunciat:** EditText i botó "Vocals". Toast: "Té N vocals".

Carpeta: `proyectos/13-contar-vocales/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Vocals" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString().lowercase()
            var vocales: Int = 0
            for (c in texto) {
                if ("aeiouàèéíòóúï".contains(c)) {
                    vocales++
                }
            }
            Toast.makeText(this, "Té " + vocales + " vocals", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Contar una letra concreta → `if (c == 'a')` (comillas simples = Char).
- Consonantes → `if (c.isLetter() && !"aeiou...".contains(c))`.
- Contar espacios → `if (c == ' ')`.

---

## 14. ¿Es palíndromo?

**Enunciat:** EditText i botó "Comprovar". Toast "És palíndrom" o "No és palíndrom".

Carpeta: `proyectos/14-palindromo/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString().lowercase().replace(" ", "")
            if (texto == texto.reversed()) {
                Toast.makeText(this, "És palíndrom", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No és palíndrom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- `replace(" ", "")` quita espacios para que "anul la luna" funcione.

---

## 15. Contar palabras

**Enunciat:** EditText i botó "Paraules". Toast: "Hi ha N paraules".

Carpeta: `proyectos/15-contar-palabras/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

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
        android:text="Paraules" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val texto: String = editText.text.toString().trim()
            var palabras: Int = 0
            if (texto.isNotEmpty()) {
                palabras = texto.split(Regex("\\s+")).size
            }
            Toast.makeText(this, "Hi ha " + palabras + " paraules", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Primera palabra → `texto.split(" ")[0]`.
- `trim()` quita espacios del principio y final.

---



# Ejercicios con NÚMEROS

Cada ejercicio: enunciado inventado, XML, Kotlin y qué cambiar si piden otra cosa.

---

## 16. Par o impar

**Enunciat:** EditText numèric i botó "Comprovar". Toast "<n> és parell" o "<n> és senar".

Carpeta: `proyectos/16-par-impar/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            if (numero == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else if (numero % 2 == 0) {
                Toast.makeText(this, "El " + numero + " és parell", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El " + numero + " és senar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Catalán: par = **parell**, impar = **senar**. Castellano: par / impar.
- Múltiplo de 3 → `numero % 3 == 0`. Múltiplo de 5 → `% 5`.
- `toIntOrNull()` devuelve null si no es número (no peta). `toInt()` peta si está vacío.
- Solo positivos → `inputType="number"`; con negativos → `numberSigned`.

---

## 17. Positivo, negativo o cero

**Enunciat:** EditText numèric i botó. Toast "Positiu", "Negatiu" o "Zero".

Carpeta: `proyectos/17-positivo-negativo-cero/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            val mensaje: String
            if (numero == null) {
                mensaje = "Introdueix un número"
            } else if (numero > 0) {
                mensaje = "Positiu"
            } else if (numero < 0) {
                mensaje = "Negatiu"
            } else {
                mensaje = "Zero"
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Truco: guardar el texto en `mensaje` y hacer un solo Toast al final. Sirve para cualquier ejercicio con varios casos.
- Hace falta `inputType="numberSigned"` para poder escribir el signo menos.

---

## 18. Sumar dos números

**Enunciat:** Dos EditText numèrics i botó "Sumar". Toast: "La suma és <resultat>".

Carpeta: `proyectos/18-suma-dos-numeros/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNum1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <EditText
        android:id="@+id/editNum2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Sumar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNum1: EditText = findViewById(R.id.editNum1)
        val editNum2: EditText = findViewById(R.id.editNum2)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val num1: Int? = editNum1.text.toString().toIntOrNull()
            val num2: Int? = editNum2.text.toString().toIntOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Introdueix dos números", Toast.LENGTH_SHORT).show()
            } else {
                val suma: Int = num1 + num2
                Toast.makeText(this, "La suma és " + suma, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Resta `num1 - num2`, multiplicación `num1 * num2`, resto `num1 % num2`.
- Decimales → cambia `Int?` por `Double?`, `toIntOrNull()` por `toDoubleOrNull()` y `inputType="numberDecimal|numberSigned"`.
- OJO: si no conviertes a número, `"2" + "3"` da "23" (concatena).

---

## 19. Calculadora con 4 botones

**Enunciat:** Dos EditText, botons "+", "-", "*", "/" i un TextView amb el resultat. Si es divideix per 0, Toast "No es pot dividir per 0".

Carpeta: `proyectos/19-calculadora/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNum1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal|numberSigned" />

    <EditText
        android:id="@+id/editNum2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal|numberSigned" />

    <Button
        android:id="@+id/buttonSumar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="+" />

    <Button
        android:id="@+id/buttonRestar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="-" />

    <Button
        android:id="@+id/buttonMultiplicar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="*" />

    <Button
        android:id="@+id/buttonDividir"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="/" />

    <TextView
        android:id="@+id/textResultat"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:text="" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNum1: EditText = findViewById(R.id.editNum1)
        val editNum2: EditText = findViewById(R.id.editNum2)
        val buttonSumar: Button = findViewById(R.id.buttonSumar)
        val buttonRestar: Button = findViewById(R.id.buttonRestar)
        val buttonMultiplicar: Button = findViewById(R.id.buttonMultiplicar)
        val buttonDividir: Button = findViewById(R.id.buttonDividir)
        val textResultat: TextView = findViewById(R.id.textResultat)

        buttonSumar.setOnClickListener {
            val num1: Double = editNum1.text.toString().toDoubleOrNull() ?: 0.0
            val num2: Double = editNum2.text.toString().toDoubleOrNull() ?: 0.0
            textResultat.text = "Resultat: " + (num1 + num2)
        }

        buttonRestar.setOnClickListener {
            val num1: Double = editNum1.text.toString().toDoubleOrNull() ?: 0.0
            val num2: Double = editNum2.text.toString().toDoubleOrNull() ?: 0.0
            textResultat.text = "Resultat: " + (num1 - num2)
        }

        buttonMultiplicar.setOnClickListener {
            val num1: Double = editNum1.text.toString().toDoubleOrNull() ?: 0.0
            val num2: Double = editNum2.text.toString().toDoubleOrNull() ?: 0.0
            textResultat.text = "Resultat: " + (num1 * num2)
        }

        buttonDividir.setOnClickListener {
            val num1: Double = editNum1.text.toString().toDoubleOrNull() ?: 0.0
            val num2: Double = editNum2.text.toString().toDoubleOrNull() ?: 0.0
            if (num2 == 0.0) {
                Toast.makeText(this, "No es pot dividir per 0", Toast.LENGTH_SHORT).show()
            } else {
                textResultat.text = "Resultat: " + (num1 / num2)
            }
        }
    }
}
```

**Si te piden otra cosa:**

- `?: 0.0` = si no es número, usa 0.
- Con enteros → `Int`, `toIntOrNull() ?: 0` y `if (num2 == 0)`. OJO: `7 / 2` con Int da 3.
- Resultado con 2 decimales → `String.format("%.2f", num1 / num2)`.
- Resultado en Toast → cambia `textResultat.text = ...` por el Toast (y borra el TextView del XML).
- Pon el resultado entre paréntesis: `"Resultat: " + (num1 + num2)`. Sin paréntesis concatena: "Resultat: 23".

---

## 20. Doble / cuadrado de un número

**Enunciat:** EditText numèric i botó "Calcular". Toast: "El doble és X i el quadrat és Y".

Carpeta: `proyectos/20-doble-y-cuadrado/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Calcular" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            if (numero == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else {
                val doble: Int = numero * 2
                val cuadrado: Int = numero * numero
                Toast.makeText(this, "El doble és " + doble + " i el quadrat és " + cuadrado, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Triple → `numero * 3`. Mitad → `numero / 2.0` (con .0 para que dé decimales).
- Cubo → `numero * numero * numero`.

---

## 21. Mayor de edad

**Enunciat:** EditText (edat) i botó "Comprovar". Si ≥ 18 → "Ets major d'edat", si no → "Ets menor d'edat".

Carpeta: `proyectos/21-mayor-de-edad/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editEdat"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editEdat: EditText = findViewById(R.id.editEdat)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val edat: Int? = editEdat.text.toString().toIntOrNull()
            if (edat == null) {
                Toast.makeText(this, "Introdueix l'edat", Toast.LENGTH_SHORT).show()
            } else if (edat >= 18) {
                Toast.makeText(this, "Ets major d'edat", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ets menor d'edat", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- El apóstrofo dentro de comillas dobles va tal cual: `"major d'edat"`.
- Jubilado → añade `else if (edat >= 65)` ANTES del `>= 18`.

---

## 22. El mayor de dos números

**Enunciat:** Dos EditText i botó "Comparar". Toast: "El més gran és X" o "Són iguals".

Carpeta: `proyectos/22-mayor-de-dos/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNum1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <EditText
        android:id="@+id/editNum2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comparar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNum1: EditText = findViewById(R.id.editNum1)
        val editNum2: EditText = findViewById(R.id.editNum2)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val num1: Int? = editNum1.text.toString().toIntOrNull()
            val num2: Int? = editNum2.text.toString().toIntOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Introdueix dos números", Toast.LENGTH_SHORT).show()
            } else if (num1 > num2) {
                Toast.makeText(this, "El més gran és " + num1, Toast.LENGTH_SHORT).show()
            } else if (num2 > num1) {
                Toast.makeText(this, "El més gran és " + num2, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Són iguals", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- El menor → cambia `>` por `<` y "més gran" por "més petit".
- Atajo: `maxOf(num1, num2)` / `minOf(num1, num2)`.

---

## 23. Número dentro de un rango

**Enunciat:** EditText i botó. Si el número és entre 1 i 10 → "Dins del rang", si no → "Fora del rang".

Carpeta: `proyectos/23-rango-1-10/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            if (numero == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else if (numero >= 1 && numero <= 10) {
                Toast.makeText(this, "Dins del rang", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Fora del rang", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Equivalente Kotlin: `numero in 1..10`.
- Cambia 1 y 10 por los límites que pidan.

---

## 24. Nota → Suspès / Aprovat / Notable / Excel·lent

**Enunciat:** EditText (nota 0-10) i botó. Toast: <5 Suspès, <7 Aprovat, <9 Notable, si no Excel·lent.

Carpeta: `proyectos/24-nota-calificacion/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNota"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Avaluar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNota: EditText = findViewById(R.id.editNota)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val nota: Double? = editNota.text.toString().toDoubleOrNull()
            val mensaje: String
            if (nota == null || nota < 0 || nota > 10) {
                mensaje = "Nota no vàlida"
            } else if (nota < 5) {
                mensaje = "Suspès"
            } else if (nota < 7) {
                mensaje = "Aprovat"
            } else if (nota < 9) {
                mensaje = "Notable"
            } else {
                mensaje = "Excel·lent"
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Si solo piden aprobado/suspenso, deja solo `if (nota < 5) ... else ...`.
- Nota entera → `Int?` y `toIntOrNull()`.

---

## 25. ¿Es múltiplo?

**Enunciat:** Dos EditText (A i B) i botó. Toast "A és múltiple de B" o "A no és múltiple de B".

Carpeta: `proyectos/25-multiplo/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editNum1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <EditText
        android:id="@+id/editNum2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editNum1: EditText = findViewById(R.id.editNum1)
        val editNum2: EditText = findViewById(R.id.editNum2)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val num1: Int? = editNum1.text.toString().toIntOrNull()
            val num2: Int? = editNum2.text.toString().toIntOrNull()
            if (num1 == null || num2 == null || num2 == 0) {
                Toast.makeText(this, "Números no vàlids", Toast.LENGTH_SHORT).show()
            } else if (num1 % num2 == 0) {
                Toast.makeText(this, num1.toString() + " és múltiple de " + num2, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, num1.toString() + " no és múltiple de " + num2, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Si el mensaje EMPIEZA por un número, pon `.toString()`: `num1.toString() + " és..."`.
- Divisible = múltiplo, misma condición.

---

## 26. Tabla de multiplicar en un TextView

**Enunciat:** EditText numèric, botó "Taula" i TextView. Mostra la taula del número (1 a 10).

Carpeta: `proyectos/26-tabla-multiplicar/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Taula" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:text="" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)

        button.setOnClickListener {
            val numero: Int = editText.text.toString().toIntOrNull() ?: 0
            var resultado: String = ""
            for (i in 1..10) {
                resultado = resultado + numero + " x " + i + " = " + (numero * i) + "\n"
            }
            textView.text = resultado
        }
    }
}
```

**Si te piden otra cosa:**

- `1..10` incluye el 10. `1 until 10` NO incluye el 10.
- Contar del 1 al N → `for (i in 1..numero) { resultado = resultado + i + "\n" }`.
- Cuenta atrás → `for (i in numero downTo 1)`. De 2 en 2 → `for (i in 0..20 step 2)`.
- `\n` = salto de línea.

---

## 27. Adivina el número (aleatorio)

**Enunciat:** EditText i botó "Provar". L'app genera un número de 1 a 100. Toast "És més gran", "És més petit" o "Has encertat!".

Carpeta: `proyectos/27-endevina-numero/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Provar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        var numeroSecreto: Int = Random.nextInt(1, 101)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            if (numero == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else if (numero < numeroSecreto) {
                Toast.makeText(this, "És més gran", Toast.LENGTH_SHORT).show()
            } else if (numero > numeroSecreto) {
                Toast.makeText(this, "És més petit", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Has encertat!", Toast.LENGTH_SHORT).show()
                numeroSecreto = Random.nextInt(1, 101)
            }
        }
    }
}
```

**Si te piden otra cosa:**

- `Random.nextInt(1, 101)` = de 1 a 100 (el segundo número NO entra).
- Contar intentos → `var intentos: Int = 0` fuera del listener, `intentos++` dentro y `"Has encertat en " + intentos + " intents"`.

---

## 28. Conversor (ºC → ºF, € → $...)

**Enunciat:** EditText (graus Celsius) i botó "Convertir". Toast: "X ºC són Y ºF".

Carpeta: `proyectos/28-celsius-fahrenheit/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="numberDecimal|numberSigned" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Convertir" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val celsius: Double? = editText.text.toString().toDoubleOrNull()
            if (celsius == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else {
                val fahrenheit: Double = celsius * 9 / 5 + 32
                Toast.makeText(this, celsius.toString() + " ºC són " + String.format("%.2f", fahrenheit) + " ºF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- ºF → ºC: `(f - 32) * 5 / 9`.
- € → $: `euros * 1.08` (o el valor que den). Km → millas: `km * 0.621371`.
- `String.format("%.2f", x)` = 2 decimales. Ojo: en el emulador en catalán/español puede salir con coma.

---

## 29. ¿Es primo?

**Enunciat:** EditText numèric i botó. Toast "És primer" o "No és primer".

Carpeta: `proyectos/29-numero-primo/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            if (numero == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else if (esPrimo(numero)) {
                Toast.makeText(this, "És primer", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No és primer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun esPrimo(n: Int): Boolean {
        if (n < 2) {
            return false
        }
        for (i in 2 until n) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}
```

**Si te piden otra cosa:**

- La función `esPrimo` va FUERA de `onCreate` pero DENTRO de la clase (antes de la última `}`).
- Así puedes crear cualquier función auxiliar: `private fun nombre(param: Tipo): TipoRetorno { ... }`.

---

## 30. Factorial

**Enunciat:** EditText numèric i botó. Toast: "El factorial de N és X".

Carpeta: `proyectos/30-factorial/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Calcular" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val numero: Int? = editText.text.toString().toIntOrNull()
            if (numero == null || numero < 0) {
                Toast.makeText(this, "Número no vàlid", Toast.LENGTH_SHORT).show()
            } else {
                var factorial: Long = 1
                for (i in 1..numero) {
                    factorial = factorial * i
                }
                Toast.makeText(this, "El factorial de " + numero + " és " + factorial, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- Suma del 1 a N → `var suma: Int = 0` y `suma = suma + i`.
- `Long` aguanta números más grandes que `Int` (hasta 20!).

---

## 31. Año bisiesto

**Enunciat:** EditText (any) i botó. Toast "És de traspàs" o "No és de traspàs".

Carpeta: `proyectos/31-any-traspas/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="number" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Comprovar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val any: Int? = editText.text.toString().toIntOrNull()
            if (any == null) {
                Toast.makeText(this, "Introdueix un any", Toast.LENGTH_SHORT).show()
            } else if ((any % 4 == 0 && any % 100 != 0) || any % 400 == 0) {
                Toast.makeText(this, "És de traspàs", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No és de traspàs", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```

**Si te piden otra cosa:**

- `&&` = y, `||` = o, `!=` = distinto.

---



# Ejercicios con BOTONES / contadores

Cada ejercicio: enunciado inventado, XML, Kotlin y qué cambiar si piden otra cosa.

---

## 32. Contador de clics

**Enunciat:** Un botó "Clica". Cada clic mostra Toast "Has clicat N vegades".

Carpeta: `proyectos/32-contador-clics/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Clica" />

</LinearLayout>
```

**MainActivity.kt**

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

        val button: Button = findViewById(R.id.button)
        var contador: Int = 0

        button.setOnClickListener {
            contador++
            Toast.makeText(this, "Has clicat " + contador + " vegades", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- La variable `contador` va FUERA del `setOnClickListener` (si no, vuelve a 0 en cada clic).
- Mostrarlo en el propio botón → `button.text = "Clics: " + contador`.
- Cada 5 clics algo especial → `if (contador % 5 == 0)`.

---

## 33. Botones + y − con un TextView

**Enunciat:** TextView amb "0", botó "+" i botó "-". Cada botó suma o resta 1 al número del TextView.

Carpeta: `proyectos/33-sumar-restar-textview/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:text="0" />

    <Button
        android:id="@+id/buttonMas"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="+" />

    <Button
        android:id="@+id/buttonMenos"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="-" />

</LinearLayout>
```

**MainActivity.kt**

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

        val textView: TextView = findViewById(R.id.textView)
        val buttonMas: Button = findViewById(R.id.buttonMas)
        val buttonMenos: Button = findViewById(R.id.buttonMenos)
        var contador: Int = 0

        buttonMas.setOnClickListener {
            contador++
            textView.text = contador.toString()
        }

        buttonMenos.setOnClickListener {
            contador--
            textView.text = contador.toString()
        }
    }
}
```

**Si te piden otra cosa:**

- `textView.text = contador` NO compila: hay que poner `contador.toString()`.
- Que no baje de 0 → `if (contador > 0) { contador-- }`.
- Botón Reset → otro botón con `contador = 0` y `textView.text = "0"`.

---

## 34. Dos botones: Mostrar y Borrar

**Enunciat:** EditText, botó "Mostrar" (Toast amb el text) i botó "Esborrar" (buida el camp i mostra Toast "Esborrat").

Carpeta: `proyectos/34-dos-botones-mostrar-borrar/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="text" />

    <Button
        android:id="@+id/buttonMostrar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Mostrar" />

    <Button
        android:id="@+id/buttonEsborrar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="Esborrar" />

</LinearLayout>
```

**MainActivity.kt**

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

        val editText: EditText = findViewById(R.id.editText)
        val buttonMostrar: Button = findViewById(R.id.buttonMostrar)
        val buttonEsborrar: Button = findViewById(R.id.buttonEsborrar)

        buttonMostrar.setOnClickListener {
            val texto: String = editText.text.toString()
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        }

        buttonEsborrar.setOnClickListener {
            editText.setText("")
            Toast.makeText(this, "Esborrat", Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Cada botón: su `<Button>` en el XML con id distinto + su `findViewById` + su `setOnClickListener`.
- Desactivar un botón → `button.isEnabled = false`.

---

## 35. Cambiar el texto del botón / alternar

**Enunciat:** Botó "ON". Cada cop que el cliques canvia entre "ON" i "OFF" i mostra Toast amb l'estat.

Carpeta: `proyectos/35-cambiar-texto-boton/`

**activity_main.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAllCaps="false"
        android:text="ON" />

</LinearLayout>
```

**MainActivity.kt**

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

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            if (button.text.toString() == "ON") {
                button.text = "OFF"
            } else {
                button.text = "ON"
            }
            Toast.makeText(this, "Estat: " + button.text, Toast.LENGTH_SHORT).show()
        }
    }
}
```

**Si te piden otra cosa:**

- Poner en el botón lo que escribe el usuario → `button.text = editText.text.toString()`.

---



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
