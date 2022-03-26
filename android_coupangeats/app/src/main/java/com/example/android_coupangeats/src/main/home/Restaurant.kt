package com.example.android_coupangeats.src.main.home

data class Restaurant(
    val img_big: Int, //Drawable Int
    val img_side_1: Int,
    val img_side_2: Int,
    val name : String,
    val min : String,
    val star: String,
    val review_num : String,
    val distance : String,
    val price : String,
    val chita: Boolean,
    val come : Boolean
)