package com.example.android_coupangeats.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class PostFavoriteRequest(
        @SerializedName("user_idx") val user_idx: String,
        @SerializedName("store_idx") val store_idx: String
)