package com.example.android_coupangeats.src.main.restaurant.models


import com.google.gson.annotations.SerializedName

data class MenuStoredByCategory(
    @SerializedName("menuCategoryName")
    val menuCategoryName: String,
    @SerializedName("menuList")
    val menuList: List<Menu>
)