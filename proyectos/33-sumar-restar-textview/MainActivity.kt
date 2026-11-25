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

        val textView: TextView = findViewById(R.id.textView)
        val buttonMas: Button = findViewById(R.id.buttonMas)
        val buttonMenos: Button = findViewById(R.id.buttonMenos)
        var contador: Int = 0

        buttonMas.setOnClickListener {
            contador++
            textView.text = contador.toString()
        }

        buttonMenos.setOnClickListener {
            contador--
            textView.text = contador.toString()
        }
    }
}
