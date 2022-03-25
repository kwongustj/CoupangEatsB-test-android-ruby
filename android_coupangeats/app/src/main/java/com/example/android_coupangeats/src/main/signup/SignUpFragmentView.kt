package com.example.android_coupangeats.src.main.signup

import com.example.android_coupangeats.src.main.signup.models.SignUpResponse

interface SignUpFragmentView {

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}