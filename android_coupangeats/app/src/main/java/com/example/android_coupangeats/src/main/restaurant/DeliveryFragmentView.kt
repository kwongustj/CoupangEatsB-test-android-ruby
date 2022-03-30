package com.example.android_coupangeats.src.main.restaurant
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse

interface DeliveryFragmentView {

    fun onDeliverygetSuccess(response: InformationRestaurantResponse)

    fun onDeliverygetFailure(message: String)

}