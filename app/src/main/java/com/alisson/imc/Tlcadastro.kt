package com.alisson.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class Tlcadastro : AppCompatActivity() {
    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tlcadastro)
        findViewById<Button>(R.id.cadastrar).setOnClickListener {
            val peso = findViewById<EditText>(R.id.pesocad).text.toString()
            val altura = findViewById<EditText>(R.id.alturacad).text.toString()

            val imc = Imc(peso = peso,altura = altura)

            salvar(imc)
        }
    }
    fun salvar(imc: Imc){
        val document = firestore.collection("imc").document()

        val handle = document.set(imc)
        handle.addOnSuccessListener {
            Toast.makeText(this,"Imc adicionado", Toast.LENGTH_SHORT).show()
        }

        handle.addOnFailureListener{
            Toast.makeText(this,"Imc não foi adicionado", Toast.LENGTH_SHORT).show()
        }
    }
}