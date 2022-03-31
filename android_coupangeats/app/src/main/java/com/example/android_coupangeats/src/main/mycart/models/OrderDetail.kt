package com.example.android_coupangeats.src.main.mycart.models


import com.google.gson.annotations.SerializedName

data class OrderDetail(
    @SerializedName("menu_amount")
    val menuAmount: Int,
    @SerializedName("menu_idx")
    val menuIdx: Int,
    @SerializedName("option_list")
    val optionList: List<Int>
)