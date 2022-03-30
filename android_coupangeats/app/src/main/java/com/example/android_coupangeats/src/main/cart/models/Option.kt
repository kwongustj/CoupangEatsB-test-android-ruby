package com.example.android_coupangeats.src.main.cart.models


import com.google.gson.annotations.SerializedName

data class Option(
    @SerializedName("option_additional_price")
    val optionAdditionalPrice: Int,
    @SerializedName("option_idx")
    val optionIdx: Int,
    @SerializedName("option_name")
    val optionName: String
)