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
