package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse

interface InformationRestaurantActivityView {

    fun onGetRestaurantSuccess(response: InformationRestaurantResponse)

    fun onGetRestaurantFailure(message: String)

    fun onReviewgetSuccess(response: ReviewResponse)

    fun onReviewgetFailure(message: String)

}