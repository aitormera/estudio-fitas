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
