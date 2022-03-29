package com.example.android_coupangeats.src.main.heart

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityHeartBinding

class HeartActivity :BaseActivity<ActivityHeartBinding>(ActivityHeartBinding::inflate){

    private var adapterType: RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>? = null
    private var adapterFavoriteRestaurant: RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>? = null

    private val FavoriteRestaurantList = arrayListOf<FavoriteRestaurant>(
        FavoriteRestaurant(
            R.drawable.img_2_side1,
            "자담돈","17-20 분","4.4","(400)","1.2km","무료배달",true,true),
        FavoriteRestaurant(
            R.drawable.img_2_side1,
            "자연을 담은 돈가스 본점","17-20 분","4.4","(400)","1.2km","무료배달",false,true),
        FavoriteRestaurant(
            R.drawable.img_2_side2,
            "자담돈","17-20 분","4.4","(400)","1.2km","무료배달",true,false),
        FavoriteRestaurant(
             R.drawable.img_2_side2,
            "자담돈","17-20 분","4.4","(400)","1.2km","무료배달",false,true),
        FavoriteRestaurant(
            R.drawable.img_2_side1,
            "마담순살떡볶이 가경복대점","17-20 분","4.4","(400)","1.2km","무료배달",true,true),
        FavoriteRestaurant(
            R.drawable.img_2_side2,
            "자연을 담은 돈가스 본점","17~20분","4.4","(400)","1.2km","무료배달",false,true),
        FavoriteRestaurant(
           R.drawable.img_2_side2,
            "자담돈","17-20 분","4.4","(400)","1.2km","무료배달",false,true),
        FavoriteRestaurant(
            R.drawable.img_2_side2,
            "자담돈","17-20 분","4.4","(400)","1.2km","무료배달",true,true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapterType = FavoriteRestaurantAdapter(FavoriteRestaurantList)
        binding.recyclerviewFavoriteRestaurant.adapter = adapterType
        val count = FavoriteRestaurantAdapter(FavoriteRestaurantList).itemCount
        binding.txtCount.setText("총 ${count}개")

        binding.txtModify.setOnClickListener {
            val intent = Intent(this, NoHeartActivity::class.java)
            startActivity(intent)
        }
    }

}