package com.example.android_coupangeats.src.main.login.models

import com.google.gson.annotations.SerializedName

data class ResultLogin(
        @SerializedName("userId") val userId: Int,
        @SerializedName("jwt") val jwt: String
)