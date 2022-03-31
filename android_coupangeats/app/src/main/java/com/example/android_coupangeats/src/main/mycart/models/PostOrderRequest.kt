package com.example.android_coupangeats.src.main.mycart.models


import com.google.gson.annotations.SerializedName

data class PostOrderRequest(
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("order_detail_list")
    val orderDetailList: List<OrderDetail>,
    @SerializedName("order_request_delivery")
    val orderRequestDelivery: String,
    @SerializedName("order_request_store")
    val orderRequestStore: String,
    @SerializedName("payment_idx")
    val paymentIdx: Int,
    @SerializedName("store_idx")
    val storeIdx: Int,
    @SerializedName("user_address_idx")
    val userAddressIdx: Int,
    @SerializedName("user_idx")
    val userIdx: Int
)