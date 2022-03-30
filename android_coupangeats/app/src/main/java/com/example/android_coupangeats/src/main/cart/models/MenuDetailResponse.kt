package com.example.android_coupangeats.src.main.cart.models


import com.google.gson.annotations.SerializedName

data class MenuDetailResponse(
    @SerializedName("result")
    val result: Result
)