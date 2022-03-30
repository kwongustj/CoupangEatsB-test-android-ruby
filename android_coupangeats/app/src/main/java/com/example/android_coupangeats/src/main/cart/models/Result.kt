package com.example.android_coupangeats.src.main.cart.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("menu")
    val menu: Menu,
    @SerializedName("optionList")
    val optionList: List<Option>
)