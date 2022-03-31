package com.example.android_coupangeats.src.main.mycart.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("order_idx")
    val orderIdx: Int
)