package com.example.android_coupangeats.src.main.restaurant

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentDeliveryBinding
import com.example.android_coupangeats.src.main.home.Restaurant
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import java.text.DecimalFormat

class DeliveryFragment() : BaseFragment<FragmentDeliveryBinding>(FragmentDeliveryBinding::bind, R.layout.fragment_delivery),

    DeliveryFragmentView {

    val idxNum = ApplicationClass.sSharedPreferences.getString("store_num"," ")!!.toInt()

    var ReviewList = arrayListOf<Review>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //식당 정보 가져오기
        DeliveryRestaurantService(this,idxNum).tryGetRestaurantInformation()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onDeliverygetSuccess(response: InformationRestaurantResponse) {

        val decimal = DecimalFormat("#,###")

        binding.txtTime.setText("배달까지 ${response.result.storeMinDeliveryTime}-${response.result.storeMaxDeliveryTime}분")
        // 가격이 0 이면 무료배달 표시, 0아니면 가격 표시
        if (response.result.storeDeliveryFee == 0) {
            binding.txtDeliveryPrice.setText("무료배달")
        } else {
            binding.txtDeliveryPrice.setText("${decimal.format(response.result.storeDeliveryFee)}원")
        }
        binding.txtMoneyPrice.setText("${decimal.format(response.result.storeMinOrder)}원")
    }
        override fun onDeliverygetFailure(message: String) {
            TODO("Not yet implemented")
        }

    }
