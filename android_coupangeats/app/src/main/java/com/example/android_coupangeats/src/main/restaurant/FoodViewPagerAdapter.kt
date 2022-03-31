package com.example.android_coupangeats.src.main.restaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.cart.MenuDetailActivity
import com.example.android_coupangeats.src.main.cart.models.MenuDetailResponse
import java.lang.Math.floor
import java.text.DecimalFormat


class FoodViewPagerAdapter(val dataSet : ArrayList<Food>): RecyclerView.Adapter<FoodViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewPagerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.menu_item ,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: FoodViewPagerAdapter.ViewHolder, position: Int) {

        holder.view.setOnClickListener {
            val intent = Intent(holder.view.context, MenuDetailActivity::class.java)
            ApplicationClass.sSharedPreferences.edit().putString("food_num", dataSet[position].food_num.toString()).apply()
            holder.view.context.startActivity(intent)
        }

        val decimal = DecimalFormat("#,###")
        Glide.with(holder.imgSide1)
            .load(dataSet[position].img_side_1) // 불러올 이미지 url
            .into(holder.imgSide1)

        holder.name.setText(dataSet[position].name)
        holder.detail.setText(dataSet[position].detail)


        // 가격이 0 이면 무료배달 표시, 0아니면 가격 표시
        if(dataSet[position].price == "0") {
            holder.price.setText("무료배달")
        } else{
            holder.price.setText("${decimal.format(dataSet[position].price.toInt())}원")
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var view = itemView
        var imgSide1 : ImageView = itemView.findViewById(R.id.img_plate)
        var name : TextView = itemView.findViewById(R.id.txt_menu_name)
        var detail : TextView = itemView.findViewById(R.id.txt_menu_detail)
        var price : TextView = itemView.findViewById(R.id.txt_menu_price)



    }

}

