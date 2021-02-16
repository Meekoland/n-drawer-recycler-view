package com.example.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapterText(private val textvalue: List<String>) : RecyclerView.Adapter<DataAdapterText.ViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val Idlayout: Int = R.layout.recycler_item
        val view = LayoutInflater.from(parent.context).inflate(Idlayout, parent, false)
        return ViewHolder(view)
    }
        override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.rectext.text = textvalue[position]
    }

    override fun getItemCount(): Int
    {
        return textvalue.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        var rectext: TextView

        init
        {
            rectext = view.findViewById(R.id.text_name)
        }
    }
}