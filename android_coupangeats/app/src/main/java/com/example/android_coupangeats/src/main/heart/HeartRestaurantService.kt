package com.example.android_coupangeats.src.main.heart

import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.heart.models.HeartResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeartRestaurantService(val view: HeartActivityView, val userIdx: Int) {

    fun tryGetRestaurantInformation(){
        val HeartRetrofitInterface = ApplicationClass.sRetrofit.create(HeartRetrofitInterface::class.java)
        HeartRetrofitInterface.getRestaurants(userIdx,1).enqueue(object:
            Callback<HeartResponse> {
            override fun onResponse(
                call: Call<HeartResponse>,
                response: Response<HeartResponse>
            ) {
                view.onHeartgetSuccess(response.body() as HeartResponse)
            }

            override fun onFailure(call: Call<HeartResponse>, t: Throwable) {
                view.onHeartgetFailure(t.message ?: "통신 오류")
            }
        })
    }





}