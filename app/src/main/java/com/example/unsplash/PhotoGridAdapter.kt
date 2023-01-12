package com.example.unsplash


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PhotoGridAdapter(
    val onImageClick: (String) -> Unit

) : RecyclerView.Adapter<PhotoGridAdapter.ItemViewHolder>() {

    val data: MutableList<Photo> = mutableListOf()
    val list = mutableListOf<Photo>()

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val textView: TextView = view.findViewById(R.id.image_description)
        // val likes: TextView = view.findViewById(R.id.likes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_view_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // val descriptor = if(photo.description.isNullOrBlank() photo.altDescription else photo.description)
        holder.textView.text = data.get(position).description

        val photo = data[position]
        Glide.with(holder.itemView.context)
            .load(data.get(position).urls.regular)
            .into(holder.imageView)
        // holder.likes.text = photo.likes.toString()

        holder.itemView.setOnClickListener {
            onImageClick(data[position].urls.regular)
        }
    }

    override fun getItemCount(): Int = data.size

    /* class ViewHolder*/


}
