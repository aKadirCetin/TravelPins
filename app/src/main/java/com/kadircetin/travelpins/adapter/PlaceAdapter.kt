package com.kadircetin.travelpins.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kadircetin.travelpins.databinding.RecyclerRowBinding
import com.kadircetin.travelpins.model.Place
import com.kadircetin.travelpins.view.MainActivity
import com.kadircetin.travelpins.view.MapsActivity

class PlaceAdapter(var placeList: List<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recyclerRowBinding: RecyclerRowBinding =
            RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recyclerRowBinding.recyclerViewTextView.setText(placeList[position].name)

        holder.itemView.setOnClickListener {
            val intentToMapsActivity = Intent(holder.itemView.context, MapsActivity::class.java)
            intentToMapsActivity.putExtra("selectedPlace",placeList.get(position))
            intentToMapsActivity.putExtra("info","old")
            holder.itemView.context.startActivity(intentToMapsActivity)
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }


    class PlaceHolder(val recyclerRowBinding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(recyclerRowBinding.root)
}