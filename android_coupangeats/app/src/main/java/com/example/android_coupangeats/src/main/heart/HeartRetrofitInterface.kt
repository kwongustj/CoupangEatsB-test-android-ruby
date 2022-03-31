package com.example.android_coupangeats.src.main.heart

import com.example.android_coupangeats.config.BaseResponse
import com.example.android_coupangeats.src.main.heart.models.HeartResponse
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteRequest
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import com.example.android_coupangeats.src.main.signup.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface HeartRetrofitInterface {

    @GET("/app/stores/liked")
    fun getRestaurants(
        @Query("user-idx") params: Int,
        @Query("user-address-idx") param: Int

    ) : Call<HeartResponse>

}
