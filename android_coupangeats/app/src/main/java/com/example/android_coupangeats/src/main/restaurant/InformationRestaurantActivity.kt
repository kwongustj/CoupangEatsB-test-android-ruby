package com.example.android_coupangeats.src.main.restaurant

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityInformationRestaurantBinding
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse
import com.example.android_coupangeats.src.main.restaurant.models.ReviewResponse
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class InformationRestaurantActivity : BaseActivity<ActivityInformationRestaurantBinding>(ActivityInformationRestaurantBinding::inflate),
InformationRestaurantActivityView{

    private var bannerViewPagerAdapter: RecyclerView.Adapter<BannerViewPagerAdapter.ViewHolder>? = null
    var currentPage : Int = 1

    val handler = RestaurantBannerHandler()
    var BannerList = arrayListOf<Banner>()
    var tabName = arrayListOf<String>()
    var ReviewList = arrayListOf<Review>()
    var tabMenuName = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idxNum = ApplicationClass.sSharedPreferences.getString("store_num"," ")!!.toInt()

        //식당 정보 가져오기
        InformationRestaurantService(this,idxNum).tryGetRestaurantInformation()

        //리뷰 정보 가져오기
        InformationRestaurantService(this, idxNum).tryGetReview()

        //tablayout 연결
        val adapter = FragmentAdapter(this)
        binding.pager.adapter = adapter


    }

    //BannerAd Handler
    inner class RestaurantBannerHandler: Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.what == 0){
                currentPage += 1
                binding.bannerImg.setCurrentItem(currentPage, true)
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


    override fun onGetRestaurantSuccess(response: InformationRestaurantResponse) {

        binding.restarantName.setText(response.result.storeName)
        binding.txtStar.setText(response.result.storeRatingAvg.toString())
        if(response.result.storeCheetahDelivery != 1) {
            binding.chita.visibility = View.INVISIBLE
        }
        binding.txtReviewNum.setText("(${response.result.storeReviewNum.toString()})")

        for( i in 0..2) {
            BannerList.add(Banner(response.result.storeImgUrl[i]))
        }

        // HomeFragment Banner _ viewPager
        binding.bannerImg.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        bannerViewPagerAdapter = BannerViewPagerAdapter(BannerList)
        binding.txtPageNow.setText("1")
        binding.bannerImg.adapter = bannerViewPagerAdapter
        binding.txtPageAll.text = (" / ${BannerList.size}")

        binding.bannerImg.apply {
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


        var count = 0
        //tab2 ( 메뉴 )
        for( i in response.result.menuListStoredByCategory) {
            tabMenuName.add(i.menuCategoryName)
            count = count + 1

        }

        //메뉴 tablayout 연결
        val foodAdapter = MenuFragmentAdapter(this,count)
        binding.pagerFood.adapter = foodAdapter

        //tabMenu 연결
        TabLayoutMediator(binding.foodTabLayout, binding.pagerFood)
        {
                tab, position -> tab.text = tabMenuName[position].toString()
        }.attach()

        //탭이 선택되었을 때, 뷰페이저가 같이 변경되도록
        binding.foodTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.pagerFood.setCurrentItem(tab!!.position, false)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

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

        // Animation 기능 없앰
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let{binding.pager.setCurrentItem(it, false)}
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
        //ReviewList에 데이터 추가하기
        for (i in response.result) {
            if (i.review.reviewImgExists == 1) {
                ReviewList.add(
                    Review(i.review.reviewImgList[0], i.review.reviewComment,i.review.ratings)
                )
            } else {
                if (i.review.reviewImgExists == 0) {
                    ReviewList.add(
                        Review("null", i.review.reviewComment, i.review.ratings)
                    )
                }
            }
        }

        if(ReviewList.size == 0) {
            binding.recycelerviewReview.visibility = View.INVISIBLE
        }

        val adapterReview = ReviewPagerAdapter(ReviewList)
        binding.recycelerviewReview.adapter = adapterReview
    }

    override fun onReviewgetFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        super.onStop()
        binding.scroll.fullScroll(ScrollView.FOCUS_UP)
    }

}