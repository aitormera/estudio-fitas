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
