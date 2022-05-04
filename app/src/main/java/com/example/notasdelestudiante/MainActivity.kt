package com.example.notasdelestudiante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInicio.setOnClickListener {

            val IrAlaActividad : Intent = Intent(this,notas::class.java)
            startActivity(IrAlaActividad)
        }


    }
}