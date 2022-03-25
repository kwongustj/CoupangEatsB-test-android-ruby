package com.example.android_coupangeats.src.main.signup.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
        @SerializedName("userIdx") val userIdx: Int,
        @SerializedName("user_name") val name: String
)