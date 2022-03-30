package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuService(val view: MenuFragmentView, val storenum: Int) {

    fun tryGetMenu(){
        val MenuRetrofitInterface = ApplicationClass.sRetrofit.create(MenuRetrofitInterface::class.java)
        MenuRetrofitInterface.getRestaurants(storenum,1).enqueue(object: Callback<InformationRestaurantResponse> {
            override fun onResponse(
                call: Call<InformationRestaurantResponse>,
                response: Response<InformationRestaurantResponse>
            ) {
                view.onGetRestaurantSuccess(response.body() as InformationRestaurantResponse)
            }

            override fun onFailure(call: Call<InformationRestaurantResponse>, t: Throwable) {
                view.onGetRestaurantFailure(t.message ?: "통신 오류")
            }
        })
    }




}