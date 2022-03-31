package com.example.android_coupangeats.src.main.heart.models


import com.google.gson.annotations.SerializedName

data class LikedStoreInfo(
    @SerializedName("category_list")
    val categoryList: List<String>,
    @SerializedName("menu_list_stored_by_category")
    val menuListStoredByCategory: List<MenuStoredByCategory>,
    @SerializedName("store_address")
    val storeAddress: String,
    @SerializedName("store_buisness_hour")
    val storeBuisnessHour: String,
    @SerializedName("store_cheetah_delivery")
    val storeCheetahDelivery: Int,
    @SerializedName("store_delivery_fee")
    val storeDeliveryFee: Int,
    @SerializedName("store_idx")
    val storeIdx: Int,
    @SerializedName("store_img_url")
    val storeImgUrl: List<String>,
    @SerializedName("store_info")
    val storeInfo: String,
    @SerializedName("store_join_date")
    val storeJoinDate: String,
    @SerializedName("store_lat")
    val storeLat: Double,
    @SerializedName("store_lng")
    val storeLng: Double,
    @SerializedName("store_max_delivery_time")
    val storeMaxDeliveryTime: Int,
    @SerializedName("store_max_prep_time")
    val storeMaxPrepTime: Int,
    @SerializedName("store_min_delivery_time")
    val storeMinDeliveryTime: Int,
    @SerializedName("store_min_order")
    val storeMinOrder: Int,
    @SerializedName("store_min_prep_time")
    val storeMinPrepTime: Int,
    @SerializedName("store_name")
    val storeName: String,
    @SerializedName("store_owner")
    val storeOwner: String,
    @SerializedName("store_owner_note")
    val storeOwnerNote: String,
    @SerializedName("store_phone")
    val storePhone: Int,
    @SerializedName("store_pickup_status")
    val storePickupStatus: Int,
    @SerializedName("store_rating_avg")
    val storeRatingAvg: Double,
    @SerializedName("store_reg_num")
    val storeRegNum: String,
    @SerializedName("store_review_num")
    val storeReviewNum: Int,
    @SerializedName("store_user_distance")
    val storeUserDistance: Double,
    @SerializedName("user_liked_status")
    val userLikedStatus: Int
)