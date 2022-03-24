package com.example.android_coupangeats.src.main.login

import android.util.Log
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.login.models.LoginResponse
import com.example.android_coupangeats.src.main.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {

//    fun tryGetUsers(){
//        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
//        loginRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse>{
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                view.onGetUserSuccess(response.body() as UserResponse)
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                view.onGetUserFailure(t.message ?: "통신 오류")
//            }
//        })
//    }

    fun tryLogin(postLoginRequest: PostLoginRequest) {
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postLogin(postLoginRequest).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onGetUserSuccess(response.body() as LoginResponse)
                Log.e("성공","성공")
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
                Log.e("실패","실패")
            }
        })
    }

//    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
//        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
//        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
//            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
//                view.onPostSignUpSuccess(response.body() as SignUpResponse)
//            }
//
//            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
//                view.onPostSignUpFailure(t.message ?: "통신 오류")
//            }
//        })
//    }

}
