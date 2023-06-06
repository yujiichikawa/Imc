package com.alisson.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.cadastrarbtn).setOnClickListener {
            val intent = Intent(this,Tlcadastro::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.listabtn).setOnClickListener {
            val intent = Intent(this,ListaImc::class.java)
            startActivity(intent)
        }
    }
}