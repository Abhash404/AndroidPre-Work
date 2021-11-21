package com.example.simpletodo

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.R
import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Button

class TaskItemAdapter(private val listOfItems:List<String>, val longClickListener:OnLongClickListener) : RecyclerView.Adapter<TaskItemAdapter.ViewHolder>(){

    interface OnLongClickListener{
        fun onItemLongClicked(position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)

        init {
            itemView.setOnLongClickListener{
                longClickListener.onItemLongClicked(adapterPosition)
                true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView: View = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item= listOfItems[position]
        holder.textView.text=item
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

}