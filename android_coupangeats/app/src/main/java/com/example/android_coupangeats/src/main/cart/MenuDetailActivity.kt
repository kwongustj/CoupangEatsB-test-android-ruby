package com.example.android_coupangeats.src.main.cart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMenuDetailBinding
import com.example.android_coupangeats.src.main.cart.models.MenuDetailResponse
import com.example.android_coupangeats.src.main.mycart.MyCartActivity
import java.text.DecimalFormat

class MenuDetailActivity : BaseActivity<ActivityMenuDetailBinding>(ActivityMenuDetailBinding::inflate),
MenuDetailActivityView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idxNum = ApplicationClass.sSharedPreferences.getString("store_num"," ")!!.toInt()
        val foodNum = ApplicationClass.sSharedPreferences.getString("food_num"," ")!!.toInt()

        //음식점 가져오기
        MenuDetailService(this).tryGetMenuDetail(idxNum,foodNum)

        binding.btnCart.setOnClickListener {

            val intent = Intent(this,MyCartActivity::class.java)
            intent.putExtra("name","${binding.txtTitle.text}")
            intent.putExtra("price","${binding.txtPrice.text}")
            intent.putExtra("count","${binding.txtCount.text}")
            startActivity(intent)
        }

    }

    override fun onGetMenuDetailSuccess(response: MenuDetailResponse) {

        val decimal = DecimalFormat("#,###")

        if(response.result.menu.menuImgUrl != "") {
            Glide.with(binding.img)
                .load(response.result.menu.menuImgUrl) // 불러올 이미지 url
                .into(binding.img)
        }


        binding.txtDetail.setText("${response.result.menu.menuDetail}")
        binding.txtTitle.setText("${response.result.menu.menuName}")
        binding.txtPrice.setText("${decimal.format(response.result.menu.menuPrice)}원")
        binding.imgPlus.setOnClickListener {
            var Count = binding.txtCount.text.toString().toInt() + 1
            binding.txtCount.setText("${Count}")

            var price = Count * response.result.menu.menuPrice.toString().toInt()
            binding.txtPrice.setText("${decimal.format(price)}원")
        }
        binding.imgMinus.setOnClickListener {
            var Count = binding.txtCount.text.toString().toInt() - 1
            binding.txtCount.setText("${Count}")

            var price = Count * response.result.menu.menuPrice.toString().toInt()
            binding.txtPrice.setText("${decimal.format(price)}원")
        }
    }

    override fun onGetMenuDetailFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

}