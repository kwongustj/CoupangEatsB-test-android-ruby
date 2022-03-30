package com.example.android_coupangeats.src.main.home.models


import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("result")
    val result: List<Result>
)