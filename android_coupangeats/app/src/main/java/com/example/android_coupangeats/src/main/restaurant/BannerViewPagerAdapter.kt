package com.example.android_coupangeats.src.main.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_coupangeats.R


class BannerViewPagerAdapter(val dataSet : ArrayList<Banner>): RecyclerView.Adapter<BannerViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerViewPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_banner,parent,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imgBanner)
            .load(dataSet[position % dataSet.size].img) // 불러올 이미지 url
            .into(holder.imgBanner)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgBanner : ImageView = itemView.findViewById(R.id.banner_image)

    }

}

