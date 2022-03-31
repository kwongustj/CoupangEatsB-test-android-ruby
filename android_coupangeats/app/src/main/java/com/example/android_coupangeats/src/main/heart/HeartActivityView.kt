package com.example.android_coupangeats.src.main.heart

import com.example.android_coupangeats.src.main.heart.models.HeartResponse
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse

interface HeartActivityView {

    fun onHeartgetSuccess(response: HeartResponse)

    fun onHeartgetFailure(message: String)

}