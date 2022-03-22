package com.example.android_coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.android_coupangeats.R


class RestaurantViewPagerAdapter(val dataSet : ArrayList<Restaurant>): RecyclerView.Adapter<RestaurantViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantViewPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item ,parent,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: RestaurantViewPagerAdapter.ViewHolder, position: Int) {
        holder.imgBig.setImageResource(dataSet[position].img_big)
        holder.imgSide1.setImageResource(dataSet[position].img_side_1)
        holder.imgSide2.setImageResource(dataSet[position].img_side_2)
        holder.name.setText(dataSet[position].name)
        holder.min.setText(dataSet[position].min)
        holder.star.setText(dataSet[position].star)
        holder.reviewNum.setText(dataSet[position].review_num)
        holder.distance.setText(dataSet[position].distance)
        holder.price.setText(dataSet[position].price)

        if(dataSet[position].chita == true ) {
            holder.chita.isVisible = true
        } else{
            holder.chita.isVisible = false
        }


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgBig : AppCompatImageView = itemView.findViewById(R.id.img_1_big)
        var imgSide1 : AppCompatImageView = itemView.findViewById(R.id.img_2_side_1)
        var imgSide2 : AppCompatImageView = itemView.findViewById(R.id.img_2_side_2)
        var name : TextView = itemView.findViewById(R.id.txt_name_restaurant)
        var min : TextView = itemView.findViewById(R.id.txt_min)
        var star : TextView = itemView.findViewById(R.id.txt_star)
        var reviewNum : TextView = itemView.findViewById(R.id.txt_review_num)
        var distance : TextView = itemView.findViewById(R.id.txt_distance)
        var price : TextView = itemView.findViewById(R.id.txt_deliverty_price)
        var chita : AppCompatImageView = itemView.findViewById(R.id.chita)
        //var come : AppCompatImageView = itemView.findViewById(R.id.)


    }

}

