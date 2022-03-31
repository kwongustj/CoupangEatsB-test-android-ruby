package com.example.android_coupangeats.src.main.heart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityHeartBinding
import com.example.android_coupangeats.src.main.heart.models.HeartResponse
import com.example.android_coupangeats.src.main.home.HomeService
import com.example.android_coupangeats.src.main.home.Restaurant
import com.example.android_coupangeats.src.main.home.RestaurantViewPagerAdapter

class HeartActivity :BaseActivity<ActivityHeartBinding>(ActivityHeartBinding::inflate),HeartActivityView {

    private var adapterType: RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>? = null
    private var adapterFavoriteRestaurant: RecyclerView.Adapter<FavoriteRestaurantAdapter.ViewHolder>? = null
    val userNum = ApplicationClass.sSharedPreferences.getString("user_idx"," ")!!.toInt()
    private val FavoriteRestaurantList = arrayListOf<FavoriteRestaurant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //음식점 가져오기
        HeartRestaurantService(this,userNum).tryGetRestaurantInformation()

        val count = FavoriteRestaurantAdapter(FavoriteRestaurantList).itemCount
        binding.txtCount.setText("총 ${count}개")

        binding.txtModify.setOnClickListener {
            val intent = Intent(this, NoHeartActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onHeartgetSuccess(response: HeartResponse) {
        Log.e("responseheart","{$response}")
        //RestaurantList에 데이터 추가하기

        for(i in response.result) {
                FavoriteRestaurantList.add(
                    FavoriteRestaurant("${i.likedStoreInfo.storeImgUrl[1]}","${i.likedStoreInfo.storeName}",
                        "${i.likedStoreInfo.storeMinDeliveryTime}","${i.likedStoreInfo.storeMaxDeliveryTime}","${i.likedStoreInfo.storeReviewNum}"
                    ,"${i.likedStoreInfo.storeUserDistance}","${i.likedStoreInfo.storeDeliveryFee}","${i.likedStoreInfo.storeCheetahDelivery}",
                    "${i.likedStoreInfo.storePickupStatus}")
                )


        }
        //데이터와 recyclerview연결하여 Favorite가게들 보여주기
        adapterType = FavoriteRestaurantAdapter(FavoriteRestaurantList)
        binding.recyclerviewFavoriteRestaurant.adapter = adapterType
    }

    override fun onHeartgetFailure(message: String) {
        TODO("Not yet implemented")
    }

}