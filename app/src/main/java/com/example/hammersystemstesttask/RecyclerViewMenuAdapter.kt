package com.example.hammersystemstesttask

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewMenuAdapter(private val menu: List<MenuItem>) :
    RecyclerView.Adapter<RecyclerViewMenuAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val composition: TextView = itemView.findViewById(R.id.composition)
        val price: Button = itemView.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("dedededede", "onCreateViewHolder: ")
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_menu, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = menu[position].title
        holder.composition.text = menu[position].composition
        holder.price.text = menu[position].price
    }

    override fun getItemCount() = menu.size
}