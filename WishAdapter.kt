package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishes: List<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>(){
    class ViewHolder(wishView: View) : RecyclerView.ViewHolder(wishView){

        val nameTv: TextView = wishView.findViewById<TextView>(R.id.name)
        val priceTv: TextView = wishView.findViewById<TextView>(R.id.price)
        val urlTv: TextView = wishView.findViewById<TextView>(R.id.url)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishView = inflater.inflate(R.layout.wishlist_item, parent, false)

        return ViewHolder(wishView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes[position]

        holder.nameTv.text = wish.name
        holder.priceTv.text = wish.price.toString()
        holder.urlTv.text = wish.url
    }

    override fun getItemCount(): Int {
        return wishes.size
    }
}