package com.example.android_coupangeats.src.main.restaurant

import android.os.Bundle
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentPackingBinding
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse

class PackingFragment : BaseFragment<FragmentPackingBinding>(FragmentPackingBinding::bind, R.layout.fragment_packing),

    PackingFragmentView {

    val ReviewList = arrayListOf<Review>(
        Review("https://ifh.cc/g/3kwRPG.png","정말 맛있어요!!!!!!!!!!!다음에 또 오겠습니다..\n 서비스 많이 주세용",3),
        Review("https://ifh.cc/g/3kwRPG.png","정말 맛있어요!!!!!!!!!!!다음에 또 오겠습니다..\n 서비스 많이 주세용",3)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val idxNum = ApplicationClass.sSharedPreferences.getString("store_num"," ")!!.toInt()

        //식당 정보 가져오기
        PackingRestaurantService(this,idxNum).tryGetRestaurantInformation()
    }

    override fun onPackinggetSuccess(response: InformationRestaurantResponse) {
        binding.txtTime.setText("포장까지 ${response.result.storeMinPrepTime}-${response.result.storeMaxPrepTime}분")
        binding.txtPackingAddress.setText("${response.result.storeAddress}")

    }

    override fun onPackinggetFailure(message: String) {
        TODO("Not yet implemented")
    }

}