package com.example.android_coupangeats.src.main.home

data class Restaurant(
    val store_num: Int,
    val img_big: String, //Drawable Int
    val img_side_1: String,
    val img_side_2: String,
    val name: String,
    val min: String,
    val star: String,
    val review_num: String,
    val distance: String,
    val price: String,
    val chita: Boolean,
    val come: Boolean
)