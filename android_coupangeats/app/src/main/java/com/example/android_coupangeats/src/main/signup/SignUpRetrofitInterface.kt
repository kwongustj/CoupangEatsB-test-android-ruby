package com.example.android_coupangeats.src.main.signup

import com.example.android_coupangeats.src.main.signup.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {

    @POST("/app/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
