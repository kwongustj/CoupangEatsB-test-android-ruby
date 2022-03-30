package com.example.android_coupangeats.src.main.cart

import com.example.android_coupangeats.src.main.cart.models.MenuDetailResponse
import com.example.android_coupangeats.src.main.signup.models.SignUpResponse

interface MenuDetailActivityView {

    fun onGetMenuDetailSuccess(response: MenuDetailResponse)

    fun onGetMenuDetailFailure(message: String)
}