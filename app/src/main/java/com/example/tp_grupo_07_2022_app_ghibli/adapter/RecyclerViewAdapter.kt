package com.example.tp_grupo_07_2022_app_ghibli.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_grupo_07_2022_app_ghibli.R
import com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.RecyclerData
import com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.RecyclerList
import com.squareup.picasso.Picasso

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<RecyclerData>()

    fun setUpdatedData(items : ArrayList<RecyclerData>){
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val imageElement = view.findViewById<ImageView>(R.id.iconImageItemA)
        val tvTitle = view.findViewById<TextView>(R.id.tvTituloPelicula)
        val tvDirector = view.findViewById<TextView>(R.id.tvDirector)
        val tvFechaLanzamiento = view.findViewById<TextView>(R.id.tvReleaseDate)

        fun bind(data: RecyclerData){
            tvTitle.text = data.title
            tvDirector.text = data.director
            tvFechaLanzamiento.text = data.release_date

            val url = data.image

            Picasso.get()
                    .load(url)
                    .into(imageElement)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_element_movie_people_location, parent, false)
        return MyViewHolder (view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}