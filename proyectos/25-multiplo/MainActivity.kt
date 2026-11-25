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
