package com.example.android_coupangeats.src.main.login

import com.example.android_coupangeats.src.main.login.models.PostLoginRequest
import com.example.android_coupangeats.src.main.login.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface LoginRetrofitInterface {
//    @GET("/users")
//    fun getUsers() : Call<UserResponse>

    @POST("/app/users/sign-in")
    fun postLogin(@Body params: PostLoginRequest): Call<LoginResponse>

    //  @POST("/users")
   // fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
