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
