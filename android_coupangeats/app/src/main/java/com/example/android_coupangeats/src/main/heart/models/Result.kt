package com.example.android_coupangeats.src.main.heart.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("liked_idx")
    val likedIdx: Int,
    @SerializedName("liked_store_info")
    val likedStoreInfo: LikedStoreInfo
)