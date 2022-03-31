package com.example.android_coupangeats.src.main.restaurant

import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseResponse
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteRequest
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import com.example.android_coupangeats.src.main.signup.SignUpRetrofitInterface
import com.example.android_coupangeats.src.main.signup.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InformationRestaurantService(val view: InformationRestaurantActivityView, val storeNum: Int, val userNum : Int) {

    fun tryGetRestaurantInformation(){
        val InformationRestaurantRetrofitInterface = ApplicationClass.sRetrofit.create(InformationRestaurantRetrofitInterface::class.java)
        InformationRestaurantRetrofitInterface.getRestaurants(storeNum,1).enqueue(object: Callback<InformationRestaurantResponse> {
            override fun onResponse(
                call: Call<InformationRestaurantResponse>,
                response: Response<InformationRestaurantResponse>
            ) {
                view.onGetRestaurantSuccess(response.body() as InformationRestaurantResponse)
            }

            override fun onFailure(call: Call<InformationRestaurantResponse>, t: Throwable) {
                view.onGetRestaurantFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetReview(){
        val ReviewInterface = ApplicationClass.sRetrofit.create(InformationRestaurantRetrofitInterface::class.java)
        ReviewInterface.getReviews(storeNum,1).enqueue(object:
            Callback<ReviewResponse> {
            override fun onResponse(
                call: Call<ReviewResponse>,
                response: Response<ReviewResponse>
            ) {
                view.onReviewgetSuccess(response.body() as ReviewResponse)
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                view.onReviewgetFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostFavorite(PostFavoriteRequest: PostFavoriteRequest){
        val InformationRestaurantRetrofitInterface = ApplicationClass.sRetrofit.create(InformationRestaurantRetrofitInterface::class.java)
        InformationRestaurantRetrofitInterface.postFavorite( PostFavoriteRequest,userNum.toString()).enqueue(object : Callback<PostFavoriteResponse>{
            override fun onResponse(call: Call<PostFavoriteResponse>, response: Response<PostFavoriteResponse>) {
                view.onPostFavoriteRestaurantSuccess(response.body() as PostFavoriteResponse)
            }

            override fun onFailure(call: Call<PostFavoriteResponse>, t: Throwable) {
                view.onPostFavoriteRestaurantFailure(t.message ?: "통신 오류")
            }
        })
    }

}