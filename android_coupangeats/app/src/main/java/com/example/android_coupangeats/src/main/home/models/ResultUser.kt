package com.example.android_coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultUser(
        @SerializedName("userId") val userId: Int,
        @SerializedName("email") val email: String
)
