package com.example.android_coupangeats.src.main.mycart

import android.os.Bundle
import android.util.Log
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMyCartBinding
import com.example.android_coupangeats.src.main.mycart.models.OrderDetail
import com.example.android_coupangeats.src.main.mycart.models.OrderResponse
import com.example.android_coupangeats.src.main.mycart.models.PostOrderRequest
import com.example.android_coupangeats.src.main.restaurant.FragmentAdapterMyCart
import com.example.android_coupangeats.src.main.restaurant.InformationRestaurantActivityView
import com.example.android_coupangeats.src.main.restaurant.InformationRestaurantService
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.PostFavoriteResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyCartActivity : BaseActivity<ActivityMyCartBinding>(
    ActivityMyCartBinding::inflate),
    InformationRestaurantActivityView {

    var tabName = arrayListOf<String>()

    val CartList = arrayListOf<MyCart>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //장바구니에 추가한 내용들 변수에 저장
        val secondIntent = intent
        secondIntent.getStringExtra("name")

        val name = secondIntent.getStringExtra("name")
        val price = secondIntent.getStringExtra("price")
        val count = secondIntent.getStringExtra("count")
        val menuIdx = secondIntent.getStringExtra("count")

        val idxNum = ApplicationClass.sSharedPreferences.getString("store_num"," ")!!.toInt()
        val userNum = ApplicationClass.sSharedPreferences.getString("user_idx"," ")!!.toInt()
        val foodNum = ApplicationClass.sSharedPreferences.getString("food_num"," ")!!.toInt()

        binding.btnCart.setOnClickListener {
            finish()
            val postRequest = PostOrderRequest(
                userIdx= userNum, userAddressIdx= 1, storeIdx = idxNum, paymentIdx = 1, orderRequestStore= "맛있게해주세요",
                orderRequestDelivery = "조심히 와주세요", discount = 0,
                orderDetailList = listOf(OrderDetail(1,foodNum,listOf(1,1)))
            )
            InformationRestaurantService(this,idxNum,userNum).tryPostOrder(postRequest)

        }

        binding.btnX.setOnClickListener {
            onBackPressed()
        }


        CartList.add(MyCart("${name}","${price}","${count}"))

        //식당 정보 가져오기
        InformationRestaurantService(this,idxNum,userNum).tryGetRestaurantInformation()

        //tablayout 연결
        val adapter = FragmentAdapterMyCart(this)
        binding.pager.adapter = adapter

        //장바구니 담겨있는거 가져오기

        val adapterCart = MyCartPagerAdapter(CartList)
        binding.cartRecyclerview.adapter = adapterCart

        binding.btnCart.setText("배달주문 ${secondIntent.getStringExtra("price")} 결제하기")

    }

    override fun onGetRestaurantSuccess(response: InformationRestaurantResponse) {
        // tab1 ( 배달 / 포장 )
        tabName.add("배달 ${response.result.storeMinDeliveryTime}-${response.result.storeMaxDeliveryTime}분")
        tabName.add("포장 ${response.result.storeMinPrepTime}-${response.result.storeMaxPrepTime}분")
        //슬라이드로 이동했을 때, 탭이 같이 변경되도록
        TabLayoutMediator(binding.tabLayout, binding.pager)
        {
                tab, position -> tab.text = tabName[position].toString()
        }.attach()
        //탭이 선택되었을 때, 뷰페이저가 같이 변경되도록
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.pager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    override fun onGetRestaurantFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onReviewgetSuccess(response: ReviewResponse) {
        TODO("Not yet implemented")
    }

    override fun onReviewgetFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostFavoriteRestaurantSuccess(response: PostFavoriteResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostFavoriteRestaurantFailure(response: String) {
        TODO("Not yet implemented")
    }

    override fun onPatchFavoriteRestaurantSuccess(response: PostFavoriteResponse) {
        TODO("Not yet implemented")
    }

    override fun onPatchFavoriteRestaurantFailure(response: String) {
        TODO("Not yet implemented")
    }

    override fun onPostOrderSuccess(response: OrderResponse) {
        Log.e("주문 성공!!!!!!!!","주문 성공 !!!!!!!!!!!!!!")
    }

    override fun onPostOrderFailure(message: String) {
        TODO("Not yet implemented")
    }

}