package com.alisson.imc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Imc_Adapter(private val imcList:ArrayList<Imc>): RecyclerView.Adapter<Imc_Adapter.Imc_AdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Imc_AdapterHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_imc,
            parent,false)

        return Imc_AdapterHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imcList.size
    }

    override fun onBindViewHolder(holder: Imc_AdapterHolder, position: Int) {
        val currentitem = imcList[position]

        holder.peso.text = currentitem.peso
        holder.altura.text = currentitem.altura
    }

    class Imc_AdapterHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val altura : TextView = itemView.findViewById(R.id.alturacard)
        val peso : TextView = itemView.findViewById(R.id.pesocard)
    }
}