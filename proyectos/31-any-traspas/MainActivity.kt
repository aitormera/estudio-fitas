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
            val any: Int? = editText.text.toString().toIntOrNull()
            if (any == null) {
                Toast.makeText(this, "Introdueix un any", Toast.LENGTH_SHORT).show()
            } else if ((any % 4 == 0 && any % 100 != 0) || any % 400 == 0) {
                Toast.makeText(this, "És de traspàs", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No és de traspàs", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
