package com.example.hammersystemstesttask.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemstesttask.MyApp.Companion.applicationContext
import com.example.hammersystemstesttask.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.recyclerview_categories_item.view.*

class RecyclerCategoriesAdapter(private val categories: List<CategoryDomain>,
        private val onItemClick: (categoryRequest: String) -> Unit) :
    RecyclerView.Adapter<RecyclerCategoriesAdapter.MyViewHolder>() {

    private var singleItemSelectionPosition = -1

    inner class MyViewHolder(itemView: View, onItemClick: (categoryRequest: String) -> Unit) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.category_button.setOnClickListener {
                onItemClick(itemView.category_button.text.toString())
                setSingleSelectionPosition(bindingAdapterPosition)
            }
        }

        val button: MaterialButton = itemView.findViewById(R.id.category_button)
    }

    private fun setSingleSelectionPosition(bindingAdapterPosition: Int) {
        if (bindingAdapterPosition == RecyclerView.NO_POSITION) return

        notifyItemChanged(singleItemSelectionPosition)
        singleItemSelectionPosition = bindingAdapterPosition
        notifyItemChanged(singleItemSelectionPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_categories_item, parent, false)
        return MyViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.button.text = categories[position].strCategory


        if (singleItemSelectionPosition == position) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(applicationContext(), R.color.category_button_background))
            (holder.itemView as MaterialButton).setTextColor(
                ContextCompat.getColor(applicationContext(), R.color.button_active))
        } else {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(applicationContext(), R.color.white))
            (holder.itemView as MaterialButton).setTextColor(
                ContextCompat.getColor(applicationContext(), R.color.category_button_text_passive))
        }

    }

    override fun getItemCount() = categories.size
}