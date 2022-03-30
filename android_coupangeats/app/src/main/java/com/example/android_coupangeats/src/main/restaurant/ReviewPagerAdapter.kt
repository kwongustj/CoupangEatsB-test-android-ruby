package com.example.android_coupangeats.src.main.restaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_coupangeats.R
import java.lang.Math.floor


class ReviewPagerAdapter(val dataSet : ArrayList<Review>): RecyclerView.Adapter<ReviewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.review_item ,parent,false)
        return ViewHolder(v)



    }

    override fun onBindViewHolder(holder: ReviewPagerAdapter.ViewHolder, position: Int) {

        if(dataSet[position].img_big != "null") {
            Glide.with(holder.imgBig)
                .load(dataSet[position].img_big) // 불러올 이미지 url
                .into(holder.imgBig)
        }

        holder.review.setText(dataSet[position].review)

        if(dataSet[position].star == 4) {
            holder.star5.visibility = View.GONE
        } else if(dataSet[position].star == 3) {
            holder.star5.visibility = View.GONE
            holder.star4.visibility = View.GONE
        } else if(dataSet[position].star == 2) {
            holder.star5.visibility = View.GONE
            holder.star4.visibility = View.GONE
            holder.star3.visibility = View.GONE
        } else if(dataSet[position].star == 1) {
            holder.star5.visibility = View.GONE
            holder.star4.visibility = View.GONE
            holder.star3.visibility = View.GONE
            holder.star2.visibility = View.GONE
        }

        // 가격이 0 이면 무료배달 표시, 0아니면 가격 표시


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imgBig : AppCompatImageView = itemView.findViewById(R.id.img_1_big)
        var review : TextView = itemView.findViewById(R.id.txt_review)
        val star5: AppCompatImageView = itemView.findViewById(R.id.img_star5)
        val star4: AppCompatImageView = itemView.findViewById(R.id.img_star4)
        val star3: AppCompatImageView = itemView.findViewById(R.id.img_star3)
        val star2: AppCompatImageView = itemView.findViewById(R.id.img_star2)



    }

}

