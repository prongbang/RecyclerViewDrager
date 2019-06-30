package com.prongbang.recyclerviewdrager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_card.view.*
import java.util.*

class CardAdapter : RecyclerView.Adapter<CardAdapter.ViewHolder>(), CardItemTouchHelperListener {

    private var list = listOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    private fun getItem(position: Int): Card? = list[position]

    override fun getItemCount(): Int = list.size

    fun submitList(list: List<Card>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(list, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(item: Card?) {
            view.apply {
                tvCard.text = item?.name
                tvPhone.text = item?.phone
            }
        }
    }

}