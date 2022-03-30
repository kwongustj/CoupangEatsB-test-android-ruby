package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PackingRestaurantService(val view: PackingFragmentView, val storenum: Int) {

    fun tryGetRestaurantInformation(){
        val InformationRestaurantRetrofitInterface = ApplicationClass.sRetrofit.create(InformationRestaurantRetrofitInterface::class.java)
        InformationRestaurantRetrofitInterface.getRestaurants(storenum,1).enqueue(object:
            Callback<InformationRestaurantResponse> {
            override fun onResponse(
                call: Call<InformationRestaurantResponse>,
                response: Response<InformationRestaurantResponse>
            ) {
                view.onPackinggetSuccess(response.body() as InformationRestaurantResponse)
            }

            override fun onFailure(call: Call<InformationRestaurantResponse>, t: Throwable) {
                view.onPackinggetFailure(t.message ?: "통신 오류")
            }
        })
    }



}