package com.example.android_coupangeats.src.main.cart

import com.example.android_coupangeats.src.main.cart.models.MenuDetailResponse
import retrofit2.Call
import retrofit2.http.*

interface MenuDetailRetrofitInterface {

    @GET("/app/stores/{storeNum}/menu/{menuNum}")
    fun getMenuDetails (
        @Path("storeNum") storeIdx: Int,
        @Path("menuNum") menuNum: Int
    ):Call<MenuDetailResponse>
}
