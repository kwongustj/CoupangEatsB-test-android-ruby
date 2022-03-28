package com.example.android_coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_coupangeats.R
import java.lang.Math.floor
import java.lang.Math.round


class RestaurantViewPagerAdapter(val dataSet : ArrayList<Restaurant>): RecyclerView.Adapter<RestaurantViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantViewPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item ,parent,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: RestaurantViewPagerAdapter.ViewHolder, position: Int) {
        Glide.with(holder.imgBig)
            .load(dataSet[position].img_big) // 불러올 이미지 url
            .into(holder.imgBig)
        Glide.with(holder.imgSide1)
            .load(dataSet[position].img_side_1) // 불러올 이미지 url
            .into(holder.imgSide1)
        Glide.with(holder.imgSide2)
            .load(dataSet[position].img_side_2) // 불러올 이미지 url
            .into(holder.imgSide2)

        holder.name.setText(dataSet[position].name)
        holder.min.setText(dataSet[position].min)
        holder.star.setText(dataSet[position].star)
        holder.reviewNum.setText(dataSet[position].review_num)
        holder.distance.setText("${floor(dataSet[position].distance.toDouble()*10)/10}km")


        // 가격이 0 이면 무료배달 표시, 0아니면 가격 표시
        if(dataSet[position].price == "0") {
            holder.price.setText("무료배달")
        } else{
            holder.price.setText(dataSet[position].price)
        }

        if(dataSet[position].chita == true ) {
            holder.chita.visibility = View.VISIBLE
        } else{
            holder.chita.visibility = View.GONE
        }

        if(dataSet[position].come == true ) {
            holder.come.visibility = View.VISIBLE
        } else{
            holder.come.visibility = View.GONE
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
        var come : TextView = itemView.findViewById(R.id.txt_out)


    }

}

