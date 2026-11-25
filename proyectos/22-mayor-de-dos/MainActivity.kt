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
