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

