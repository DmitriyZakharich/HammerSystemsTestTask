package com.example.hammersystemstesttask.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemstesttask.R
import com.google.android.material.imageview.ShapeableImageView


class ViewPagerPromoAdapter(private val banners: List<Int>) :
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
        holder.image.setBackgroundResource(banners[position])
    }

    override fun getItemCount() = banners.size
}