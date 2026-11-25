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
            val celsius: Double? = editText.text.toString().toDoubleOrNull()
            if (celsius == null) {
                Toast.makeText(this, "Introdueix un número", Toast.LENGTH_SHORT).show()
            } else {
                val fahrenheit: Double = celsius * 9 / 5 + 32
                Toast.makeText(this, celsius.toString() + " ºC són " + String.format("%.2f", fahrenheit) + " ºF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
