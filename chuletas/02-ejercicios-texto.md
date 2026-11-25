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

