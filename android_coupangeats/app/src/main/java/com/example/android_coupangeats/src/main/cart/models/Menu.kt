package com.example.android_coupangeats.src.main.cart.models


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("menu_detail")
    val menuDetail: String,
    @SerializedName("menu_idx")
    val menuIdx: Int,
    @SerializedName("menu_name")
    val menuName: String,
    @SerializedName("menu_price")
    val menuPrice: Int,
    @SerializedName("menu_img_url")
    val menuImgUrl: String
)