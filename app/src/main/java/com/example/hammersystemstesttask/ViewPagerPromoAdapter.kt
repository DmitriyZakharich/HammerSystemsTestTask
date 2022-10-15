package com.example.hammersystemstesttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class ViewPagerPromoAdapter(private val promos: List<Int>) :
    RecyclerView.Adapter<ViewPagerPromoAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ShapeableImageView = itemView.findViewById(R.id.image_banner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.viewpager_promo_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setBackgroundResource(promos[position])
    }

    override fun getItemCount() = promos.size
}