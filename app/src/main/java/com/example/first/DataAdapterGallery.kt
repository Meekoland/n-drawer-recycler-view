package com.example.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DataAdapterGallery(private val img: IntArray) : RecyclerView.Adapter<DataAdapterGallery.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val listID: Int = R.layout.recycler_image
        val itemView = LayoutInflater.from(parent.context).inflate(listID,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(img[position]).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return img.size
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView

        init
        {
            imageView = itemView.findViewById(R.id.img_rec)
        }
    }

}