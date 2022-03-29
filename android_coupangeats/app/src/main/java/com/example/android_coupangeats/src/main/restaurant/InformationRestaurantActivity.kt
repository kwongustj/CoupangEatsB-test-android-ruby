package com.example.android_coupangeats.src.main.restaurant

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityInformationRestaurantBinding
import com.example.android_coupangeats.src.main.home.Banner
import com.example.android_coupangeats.src.main.home.BannerViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class InformationRestaurantActivity : BaseActivity<ActivityInformationRestaurantBinding>(ActivityInformationRestaurantBinding::inflate){

    private var bannerViewPagerAdapter: RecyclerView.Adapter<BannerViewPagerAdapter.ViewHolder>? = null
    var currentPage : Int = 1

    val handler = RestaurantBannerHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val BannerList = arrayListOf<Banner>(
            Banner(R.drawable.big_img_1),
            Banner(R.drawable.big_img_2),
            Banner(R.drawable.big_img_3)
        )


        val adapter = FragmentAdapter(this)
        binding.pager.adapter = adapter

        val tabName = arrayOf<String>("배달 19-29분", "포장 10-20분")
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

        //메뉴 tab
        val foodAdapter = MenuFragmentAdapter(this)
        binding.pagerFood.adapter = foodAdapter

        val tabMenuName = arrayOf<String>("추천메뉴", "메뉴소개","볼고기","사이드메뉴","묵사발")
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


}