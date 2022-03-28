package com.example.android_coupangeats.src.main.home

import com.example.android_coupangeats.src.main.home.models.RestaurantResponse
import com.example.android_coupangeats.src.main.home.models.SignInResponse
import com.example.android_coupangeats.src.main.home.models.UserResponse

interface HomeFragmentView {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignInResponse)

    fun onPostSignUpFailure(message: String)

    fun onGetRestaurantSuccess(response: RestaurantResponse)

    fun onGetRestaurantFailure(message: String)


}