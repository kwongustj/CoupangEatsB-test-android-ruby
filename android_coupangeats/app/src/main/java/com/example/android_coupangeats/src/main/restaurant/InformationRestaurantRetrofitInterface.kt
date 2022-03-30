package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import retrofit2.Call
import retrofit2.http.*

interface InformationRestaurantRetrofitInterface {

    @GET("/app/stores/{storeNum}")
    fun getRestaurants(
        @Path("storeNum") storeNum: Int,
        @Query("user-address-idx") params: Int
    ) : Call<InformationRestaurantResponse>

    @GET("/app/stores/{storeNum}/reviews")
    fun getReviews (
        @Path("storeNum") storeIdx: Int,
        @Query("user-address-idx") params: Int
    ):Call<ReviewResponse>
}
