package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse


interface PackingFragmentView {

    fun onPackinggetSuccess(response: InformationRestaurantResponse)

    fun onPackinggetFailure(message: String)
}