package com.example.btt2screen.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btt2screen.R
import com.example.btt2screen.home.Property
import org.w3c.dom.Text

class MyAdapter(private val data: List<Property>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(property: Property){
            val title = view.findViewById<TextView>(R.id.description)
            val imageView = view.findViewById<ImageView>(R.id.avatar)
            val description = view.findViewById<TextView>(R.id.status)

            title.text = property.name
//            description.text = property.name

            Glide.with(view.context).load(property.img).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view_image, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}