package com.example.android_coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_coupangeats.R


class TypeRecyclerViewAdapter(val dataSet : ArrayList<Type>): RecyclerView.Adapter<TypeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TypeRecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.type_item,parent,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: TypeRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.img_type.setImageResource(dataSet[position].img)
        holder.txt_type.text = dataSet[position].content
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txt_type : TextView
        var img_type : AppCompatImageView

        init {
            txt_type = itemView.findViewById(R.id.txt_type)
            img_type = itemView.findViewById(R.id.img_type)

        }

    }
}