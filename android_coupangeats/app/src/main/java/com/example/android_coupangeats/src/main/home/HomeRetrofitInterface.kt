package com.example.android_coupangeats.src.main.home

import com.example.android_coupangeats.src.main.home.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.home.models.SignUpResponse
import com.example.android_coupangeats.src.main.home.models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>

    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
