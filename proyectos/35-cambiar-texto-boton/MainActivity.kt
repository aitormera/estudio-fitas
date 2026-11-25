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

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            if (button.text.toString() == "ON") {
                button.text = "OFF"
            } else {
                button.text = "ON"
            }
            Toast.makeText(this, "Estat: " + button.text, Toast.LENGTH_SHORT).show()
        }
    }
}
