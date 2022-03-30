package com.example.android_coupangeats.src.main.cart

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMenuDetailBinding
import com.example.android_coupangeats.src.main.cart.models.MenuDetailResponse
import com.example.android_coupangeats.src.main.mycart.MyCartActivity

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
            startActivity(intent)
        }

    }

    override fun onGetMenuDetailSuccess(response: MenuDetailResponse) {

        if(response.result.menu.menuImgUrl != "") {
            Glide.with(binding.img)
                .load(response.result.menu.menuImgUrl) // 불러올 이미지 url
                .into(binding.img)
        }


        binding.txtDetail.setText("${response.result.menu.menuDetail}")
        binding.txtTitle.setText("${response.result.menu.menuName}")
        binding.txtPrice.setText("${response.result.menu.menuPrice}")
        binding.imgPlus.setOnClickListener {
            var Count = binding.txtCount.text.toString().toInt() + 1
            binding.txtCount.setText("${Count}")

            var price = binding.txtPrice.text.toString().toInt()
            price = Count * response.result.menu.menuPrice.toString().toInt()
            binding.txtPrice.setText("${price}")
        }
        binding.imgMinus.setOnClickListener {
            var Count = binding.txtCount.text.toString().toInt() - 1
            binding.txtCount.setText("${Count}")

            var price = binding.txtPrice.text.toString().toInt()
            price = Count * response.result.menu.menuPrice.toString().toInt()
            binding.txtPrice.setText("${price}")
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