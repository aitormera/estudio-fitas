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

        val editNota: EditText = findViewById(R.id.editNota)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val nota: Double? = editNota.text.toString().toDoubleOrNull()
            val mensaje: String
            if (nota == null || nota < 0 || nota > 10) {
                mensaje = "Nota no vàlida"
            } else if (nota < 5) {
                mensaje = "Suspès"
            } else if (nota < 7) {
                mensaje = "Aprovat"
            } else if (nota < 9) {
                mensaje = "Notable"
            } else {
                mensaje = "Excel·lent"
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }
}
