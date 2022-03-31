package com.example.android_coupangeats.src.main.mycart.models


import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("result")
    val result: Result
)