package com.example.android_coupangeats.src.main.restaurant.models


import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("result")
    val result: List<ResultX>
)