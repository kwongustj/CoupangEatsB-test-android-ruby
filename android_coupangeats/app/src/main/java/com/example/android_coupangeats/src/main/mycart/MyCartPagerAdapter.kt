package com.example.android_coupangeats.src.main.mycart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_coupangeats.R


class MyCartPagerAdapter(val dataSet : ArrayList<MyCart>): RecyclerView.Adapter<MyCartPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCartPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_cart_item ,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: MyCartPagerAdapter.ViewHolder, position: Int) {

        holder.name.setText(dataSet[position].name)
        holder.price.setText(dataSet[position].price)
        holder.count.setText(dataSet[position].count)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var name : TextView = itemView.findViewById(R.id.menu_name)
        var price : TextView = itemView.findViewById(R.id.txt_cart_price)
        var count : TextView = itemView.findViewById(R.id.count)

    }

}

