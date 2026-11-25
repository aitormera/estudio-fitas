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

