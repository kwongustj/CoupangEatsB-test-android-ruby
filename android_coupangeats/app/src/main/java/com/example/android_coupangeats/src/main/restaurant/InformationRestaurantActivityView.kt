package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.config.BaseResponse
import com.example.android_coupangeats.src.main.mycart.models.OrderResponse
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse

interface InformationRestaurantActivityView {

    fun onGetRestaurantSuccess(response: InformationRestaurantResponse)

    fun onGetRestaurantFailure(message: String)

    fun onReviewgetSuccess(response: ReviewResponse)

    fun onReviewgetFailure(message: String)

    fun onPostFavoriteRestaurantSuccess(response: PostFavoriteResponse)

    fun onPostFavoriteRestaurantFailure(response: String)

    fun onPatchFavoriteRestaurantSuccess(response: PostFavoriteResponse)

    fun onPatchFavoriteRestaurantFailure(response: String)

    fun onPostOrderSuccess(response: OrderResponse)

    fun onPostOrderFailure(message: String)


}