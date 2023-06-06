package com.alisson.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListaImc : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var imcRecyclerview : RecyclerView
    private lateinit var imcArrayList : ArrayList<Imc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_imc)

        imcRecyclerview = findViewById(R.id.recyclerView)
        imcRecyclerview.layoutManager = LinearLayoutManager(this)
        imcRecyclerview.setHasFixedSize(true)

        imcArrayList = arrayListOf<Imc>()

        getImcData()
    }

    private fun getImcData() {

        dbref = FirebaseDatabase.getInstance().getReference("imc")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (imcSnapshot in snapshot.children){
                        val imc = imcSnapshot.getValue(Imc::class.java)
                        imcArrayList.add(imc!!)
                    }
                    imcRecyclerview.adapter = Imc_Adapter(imcArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}