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
