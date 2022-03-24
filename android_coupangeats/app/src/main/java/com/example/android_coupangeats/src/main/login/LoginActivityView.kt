package com.example.android_coupangeats.src.main.login

import com.example.android_coupangeats.src.main.login.models.LoginResponse

interface LoginActivityView {

    fun onGetUserSuccess(response: LoginResponse)

    fun onGetUserFailure(message: String)

    //fun onPostSignUpSuccess(response: SignUpResponse)

    //fun onPostSignUpFailure(message: String)
}