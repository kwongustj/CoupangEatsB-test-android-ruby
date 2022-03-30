package com.example.android_coupangeats.src.main.home

import android.util.Log
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.src.main.home.models.RestaurantResponse
import com.example.android_coupangeats.src.main.home.models.SignInResponse
import com.example.android_coupangeats.src.main.home.models.UserResponse
import com.example.android_coupangeats.src.main.login.models.LoginResponse
import com.example.android_coupangeats.src.main.signup.models.PostSignUpRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

    fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onGetUserSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostSignUpSuccess(response.body() as SignInResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetRestaurant(){
        val restaurantRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        restaurantRetrofitInterface.getRestaurants(1).enqueue(object : Callback<RestaurantResponse>{

            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                Log.e("body",response.body().toString())
                view.onGetRestaurantSuccess(response.body() as RestaurantResponse)
            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                view.onGetRestaurantFailure(t.message ?: "통신 오류")
            }
        })
    }
}
