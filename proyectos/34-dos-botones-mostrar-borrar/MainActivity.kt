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
