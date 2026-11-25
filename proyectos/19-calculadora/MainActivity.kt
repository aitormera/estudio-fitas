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
