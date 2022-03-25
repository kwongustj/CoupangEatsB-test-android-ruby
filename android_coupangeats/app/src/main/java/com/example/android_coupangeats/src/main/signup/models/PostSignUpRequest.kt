package com.example.android_coupangeats.src.main.signup.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
        @SerializedName("user_id") val email: String,
        @SerializedName("user_pw") val password: String,
        @SerializedName("user_name") val name: String,
        @SerializedName("user_phone") val phoneNumber: String
)