package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.config.BaseResponse
import com.example.android_coupangeats.src.main.mycart.models.OrderResponse
import com.example.android_coupangeats.src.main.mycart.models.PostOrderRequest
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteRequest
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import com.example.android_coupangeats.src.main.signup.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.signup.models.SignUpResponse
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

    @POST("/app/stores/liked")
    fun postFavorite(
        @Body params: PostFavoriteRequest,
        @Query("user-idx") param : String
    ): Call<PostFavoriteResponse>

    @PATCH("/app/stores/liked")
    fun  patchFavorite(
        @Body params: PostFavoriteRequest,
        @Query("user-idx") param : String
    ): Call<PostFavoriteResponse>

    @POST("/app/order")
    fun postOrder(@Body params: PostOrderRequest): Call<OrderResponse>

}
