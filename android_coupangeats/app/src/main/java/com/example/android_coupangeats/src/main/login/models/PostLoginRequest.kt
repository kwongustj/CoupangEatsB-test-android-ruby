package com.example.android_coupangeats.src.main.login.models

import com.google.gson.annotations.SerializedName

data class PostLoginRequest (
        @SerializedName("user_id") val email: String,
        @SerializedName("user_pw") val password: String
        )
