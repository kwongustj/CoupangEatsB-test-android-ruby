package com.example.android_coupangeats.src.main.cart

import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.cart.models.MenuDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuDetailService(val view: MenuDetailActivityView) {


    fun tryGetMenuDetail(store: Int, menuNum : Int){
        val CartRetrofitInterface = ApplicationClass.sRetrofit.create(MenuDetailRetrofitInterface::class.java)
        CartRetrofitInterface.getMenuDetails(store,menuNum).enqueue(object : Callback<MenuDetailResponse>{
            override fun onResponse(call: Call<MenuDetailResponse>, response: Response<MenuDetailResponse>) {
                view.onGetMenuDetailSuccess(response.body() as MenuDetailResponse)
            }

            override fun onFailure(call: Call<MenuDetailResponse>, t: Throwable) {
                view.onGetMenuDetailFailure(t.message ?: "통신 오류")
            }
        })
    }

}
