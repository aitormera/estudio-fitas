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
