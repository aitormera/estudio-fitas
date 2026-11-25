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

        val editEdat: EditText = findViewById(R.id.editEdat)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val edat: Int? = editEdat.text.toString().toIntOrNull()
            if (edat == null) {
                Toast.makeText(this, "Introdueix l'edat", Toast.LENGTH_SHORT).show()
            } else if (edat >= 18) {
                Toast.makeText(this, "Ets major d'edat", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ets menor d'edat", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
