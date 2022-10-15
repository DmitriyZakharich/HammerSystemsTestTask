package com.example.hammersystemstesttask.domain

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemstesttask.R
import com.example.hammersystemstesttask.viewmodel.TAG
import com.squareup.picasso.Picasso

class RecyclerMenuAdapter(private val meals: List<MealDomain>) :
    RecyclerView.Adapter<RecyclerMenuAdapter.MyViewHolder>() {

    private val picasso = Picasso.get()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val composition: TextView = itemView.findViewById(R.id.composition)
        val price: Button = itemView.findViewById(R.id.price)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_menu_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = meals[position].strMeal
        Log.d(TAG, "RecyclerMenuAdapter: onBindViewHolder")

        //        holder.composition.text = meals[position].composition
//        holder.price.text = meals[position].price

        picasso.load(meals[position].strMealThumb).into(holder.imageView)
    }

    override fun getItemCount() = meals.size
}