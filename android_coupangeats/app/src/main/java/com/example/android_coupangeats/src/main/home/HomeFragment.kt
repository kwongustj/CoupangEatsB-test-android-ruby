package com.example.android_coupangeats.src.main.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentHomeBinding
import com.example.android_coupangeats.src.main.home.models.RestaurantResponse
import com.example.android_coupangeats.src.main.home.models.SignInResponse
import com.example.android_coupangeats.src.main.home.models.UserResponse
import com.example.android_coupangeats.src.main.login.BottomActivity
import com.example.android_coupangeats.src.main.map.LocationActivity
import com.example.android_coupangeats.src.main.restaurant.InformationRestaurantActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),

    HomeFragmentView {

    private var adapterType: RecyclerView.Adapter<TypeRecyclerViewAdapter.ViewHolder>? = null
    private var adapterRestaurant: RecyclerView.Adapter<RestaurantViewPagerAdapter.ViewHolder>? = null
    private var bannerViewPagerAdapter: RecyclerView.Adapter<BannerViewPagerAdapter.ViewHolder>? = null
    var currentPage : Int = 1

    val RestaurantList = arrayListOf<Restaurant>(
        Restaurant("https://ifh.cc/g/xS6qMn.jpg","https://ifh.cc/g/k3FHpB.png","https://ifh.cc/g/S4AObs.png",
            "자담돈","17-20 분","4.4","(400)","0.6666","무료배달",true,true),
        Restaurant("https://ifh.cc/g/xS6qMn.jpg","https://ifh.cc/g/k3FHpB.png","https://ifh.cc/g/S4AObs.png",
            "자연을 담은 돈가스 본점","17-20 분","4.4","(400)","0.6666","무료배달",false,true),
        Restaurant("https://ifh.cc/g/xS6qMn.jpg","https://ifh.cc/g/k3FHpB.png","https://ifh.cc/g/S4AObs.png",
            "자담돈","17-20 분","4.4","(400)","1.22222","무료배달",true,false)
    )

    val TypeList = arrayListOf<Type>(
        Type(R.drawable.out,"포장"), Type(R.drawable.korea,"한식"),
        Type(R.drawable.chicken,"치킨"), Type(R.drawable.boon,"분식"),
        Type(R.drawable.dong,"돈까스"), Type(R.drawable.foot,"족발/보쌈"),
        Type(R.drawable.tang,"찜/탕"), Type(R.drawable.gogi,"구이"),
        Type(R.drawable.pizza,"피자"), Type(R.drawable.china,"중식"),
        Type(R.drawable.japan,"일식"), Type(R.drawable.fish,"회/해물"),
        Type(R.drawable.pasta,"양식"), Type(R.drawable.coffee,"커피/차"),
        Type(R.drawable.dessert,"디저트"), Type(R.drawable.snack,"간식"),
        Type(R.drawable.asian,"아시안"), Type(R.drawable.sandwitch,"샌드위치"),
        Type(R.drawable.salad,"샐러드"), Type(R.drawable.burger,"버거"),
        Type(R.drawable.mexican,"멕시칸"), Type(R.drawable.dosirak,"도시락"),
        Type(R.drawable.soup,"죽"), Type(R.drawable.franchise,"프랜차이즈"),
        Type(R.drawable.new_restaurant,"신규 맛집"), Type(R.drawable.person_1,"1인분")
    )

    val BannerList = arrayListOf<Banner>(
        Banner(R.drawable.banner1),
        Banner(R.drawable.banner2),
        Banner(R.drawable.banner3)
    )

    val handler = HomeBannerHandler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            //음식점 가져오기
         //  HomeService(this).tryGetRestaurant()

        adapterRestaurant = RestaurantViewPagerAdapter(RestaurantList)
        binding.recyclerviewRestaurant.adapter = adapterRestaurant


            //HomeFragment 주소 설정하기
            binding.layoutLocation.setOnClickListener {

                if (ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN", " ") == " ") {
                    val intent = Intent(activity, LocationActivity::class.java)
                    startActivity(intent)
                    Log.e("logined", " false ")
                }
            }


            // HomeFragment 음식 type 고르기_ RecyclerView
            adapterType = TypeRecyclerViewAdapter(TypeList)
            binding.recyclerviewType.adapter = adapterType

            // HomeFragment Banner _ viewPager
            binding.bannerAd.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            bannerViewPagerAdapter = BannerViewPagerAdapter(BannerList)
            binding.txtPageNow.setText("1")
            binding.bannerAd.adapter = bannerViewPagerAdapter
            binding.txtPageAll.text = (" / ${BannerList.size}")

            binding.bannerAd.apply {
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                    override fun onPageScrollStateChanged(state: Int) {
                        super.onPageScrollStateChanged(state)
                        when (state) {
                            // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                            ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart()
                            // 뷰페이저 움직이는 중
                            ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                        }
                    }

                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        binding.txtPageNow.text = "${(position % BannerList.size) + 1}"
                        currentPage = position
                        autoScrollStart()
                    }
                })
            }
        }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacksAndMessages(null)
    }



    //BannerAd Handler
    inner class HomeBannerHandler: Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.what == 0){
                currentPage += 1
                binding.bannerAd.setCurrentItem(currentPage, true)
                autoScrollStart()
            }
        }
    }

    private fun autoScrollStart() {
        handler.removeMessages(0)
        handler.sendEmptyMessageDelayed(0, 3000)
    }

    private fun autoScrollStop(){
        handler.removeMessages(0)
    }

    override fun onGetUserSuccess(response: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetUserFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostSignUpSuccess(response: SignInResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostSignUpFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetRestaurantSuccess(response: RestaurantResponse) {
        Log.e("onGetRestaurantSuccess", "$response")


        // RestaurantList에 데이터 추가하
//        for(i in response.result) {
//            Log.e("size",i.storeImgUrl.size.toString())
//            if (i.storeImgUrl.size == 3) {
//                RestaurantList.add(
//                    Restaurant(
//                        i.storeImgUrl[0], i.storeImgUrl[1], i.storeImgUrl[2],
//                        i.storeName, "${i.storeMinDeliveryTime}-${i.storeMaxDeliveryTime}분", "4.5",
//                        "(619)", i.storeUserDistance.toString(), "${i.storeDeliveryFee.toString()}원",
//                        true, true)
//                    )
//
//            }
//        }
//
        // HomeFragment 가게들 보여주기 _ RecyclerView
//        adapterRestaurant = RestaurantViewPagerAdapter(RestaurantList)
//        binding.recyclerviewRestaurant.adapter = adapterRestaurant

    }

    override fun onGetRestaurantFailure(message: String) {
        Log.e("onGetRestaurantFailure", "onGetRestaurantFailure")
    }


}