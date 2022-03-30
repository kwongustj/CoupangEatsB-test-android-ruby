package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse

interface MenuFragmentView {

    fun onGetRestaurantSuccess(response: InformationRestaurantResponse)

    fun onGetRestaurantFailure(message: String)

}