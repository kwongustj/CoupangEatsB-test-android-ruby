package com.example.android_coupangeats.src.main.restaurant.models


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("menu_name")
    val menuName: List<String>,
    @SerializedName("order_idx")
    val orderIdx: Int,
    @SerializedName("ratings")
    val ratings: Int,
    @SerializedName("review_comment")
    val reviewComment: String,
    @SerializedName("review_idx")
    val reviewIdx: Int,
    @SerializedName("reviewImgExists")
    val reviewImgExists: Int,
    @SerializedName("review_img_list")
    val reviewImgList: List<String>,
    @SerializedName("store_idx")
    val storeIdx: Int,
    @SerializedName("store_name")
    val storeName: String,
    @SerializedName("user_idx")
    val userIdx: Int,
    @SerializedName("user_name")
    val userName: String
)