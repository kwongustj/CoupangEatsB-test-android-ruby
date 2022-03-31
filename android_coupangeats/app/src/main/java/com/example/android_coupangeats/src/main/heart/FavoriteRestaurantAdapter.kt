package com.example.android_coupangeats.src.main.heart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_coupangeats.R


class FavoriteRestaurantAdapter(val dataSet : ArrayList<FavoriteRestaurant>): RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteRestaurantAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.favorite_restaurant_item ,parent,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: FavoriteRestaurantAdapter.ViewHolder, position: Int) {
        Glide.with(holder.imgBig)
            .load(dataSet[position].img_big) // 불러올 이미지 url
            .into(holder.imgBig)

        holder.name.setText(dataSet[position].name)
        holder.min.setText(dataSet[position].min)
        holder.star.setText(dataSet[position].star)
        holder.reviewNum.setText(dataSet[position].review_num)
        holder.distance.setText(dataSet[position].distance)
        holder.price.setText(dataSet[position].price)

        if(dataSet[position].chita == "1" ) {
            holder.chita.visibility = View.VISIBLE
        } else{
            holder.chita.visibility = View.GONE
        }

        if(dataSet[position].come == "1" ) {
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

