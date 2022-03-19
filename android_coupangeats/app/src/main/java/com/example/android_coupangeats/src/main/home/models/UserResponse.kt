package com.example.android_coupangeats.src.main.home.models

import com.example.android_coupangeats.src.main.home.models.ResultUser
import com.google.gson.annotations.SerializedName

data class UserResponse(
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String,
        @SerializedName("result") val result: ArrayList<ResultUser>
)
