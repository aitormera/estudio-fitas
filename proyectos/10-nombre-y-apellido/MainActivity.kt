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

        val editNom: EditText = findViewById(R.id.editNom)
        val editCognom: EditText = findViewById(R.id.editCognom)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val nom: String = editNom.text.toString()
            val cognom: String = editCognom.text.toString()
            Toast.makeText(this, nom + " " + cognom, Toast.LENGTH_SHORT).show()
        }
    }
}
