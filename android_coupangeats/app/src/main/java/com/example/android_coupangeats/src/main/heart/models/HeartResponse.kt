package com.example.android_coupangeats.src.main.heart.models


import com.google.gson.annotations.SerializedName

data class HeartResponse(
    @SerializedName("result")
    val result: List<Result>
)