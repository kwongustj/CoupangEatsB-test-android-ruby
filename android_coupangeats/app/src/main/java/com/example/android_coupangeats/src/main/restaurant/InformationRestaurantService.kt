package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.home.models.RestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InformationRestaurantService(val view: InformationRestaurantActivityView, val storenum: Int) {

    fun tryGetRestaurantInformation(){
        val InformationRestaurantRetrofitInterface = ApplicationClass.sRetrofit.create(InformationRestaurantRetrofitInterface::class.java)
        InformationRestaurantRetrofitInterface.getRestaurants(storenum,1).enqueue(object: Callback<InformationRestaurantResponse> {
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

    fun tryGetReview(){
        val ReviewInterface = ApplicationClass.sRetrofit.create(InformationRestaurantRetrofitInterface::class.java)
        ReviewInterface.getReviews(storenum,1).enqueue(object:
            Callback<ReviewResponse> {
            override fun onResponse(
                call: Call<ReviewResponse>,
                response: Response<ReviewResponse>
            ) {
                view.onReviewgetSuccess(response.body() as ReviewResponse)
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                view.onReviewgetFailure(t.message ?: "통신 오류")
            }
        })
    }



}