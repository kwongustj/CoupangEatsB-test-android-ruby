package com.example.android_coupangeats.src.main.heart

data class FavoriteRestaurant(
    val img_big: Int, //Drawable Int
    val name : String,
    val min : String,
    val star: String,
    val review_num : String,
    val distance : String,
    val price : String,
    val chita: Boolean,
    val come : Boolean
)