package com.example.android_coupangeats.src.main.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity.apply
import android.view.View
import androidx.core.view.GravityCompat.apply
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentHomeBinding
import com.example.android_coupangeats.src.main.home.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.home.models.SignUpResponse
import com.example.android_coupangeats.src.main.home.models.UserResponse
import java.util.logging.Handler as Handler1

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),

    HomeFragmentView {

    private var adapterType: RecyclerView.Adapter<TypeRecyclerViewAdapter.ViewHolder>? = null
    private var bannerViewPagerAdapter: RecyclerView.Adapter<BannerViewPagerAdapter.ViewHolder>? = null
    var currentPage : Int = 1

    val handler= Handler(Looper.getMainLooper()){
        setPage()
        true
    }

    val TypeList = arrayListOf<Type>(
        Type(R.drawable.new_restaurant,"신규 맛집"),
        Type(R.drawable.person_1,"1인분"),
        Type(R.drawable.new_restaurant,"신규 맛집"),
        Type(R.drawable.person_1,"1인분"),
        Type(R.drawable.new_restaurant,"신규 맛집"),
        Type(R.drawable.person_1,"1인분"),
        Type(R.drawable.new_restaurant,"신규 맛집"),
        Type(R.drawable.person_1,"1인분"),
        Type(R.drawable.new_restaurant,"신규 맛집"),
        Type(R.drawable.person_1,"1인분"),
        Type(R.drawable.new_restaurant,"신규 맛집"),
        Type(R.drawable.person_1,"1인분")

    )

    val BannerList = arrayListOf<Banner>(
        Banner(R.drawable.banner1),
        Banner(R.drawable.banner2),
        Banner(R.drawable.banner1),
        Banner(R.drawable.banner2),
        Banner(R.drawable.banner1),
        Banner(R.drawable.banner2))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // HomeFragment 음식 type 고르기
        adapterType = TypeRecyclerViewAdapter(TypeList)
        binding.recyclerviewType.adapter = adapterType

        // HomeFragment Banner
        binding.bannerAd.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        bannerViewPagerAdapter = BannerViewPagerAdapter(BannerList)
        binding.txtPageNow.setText("1")
        binding.bannerAd.adapter = bannerViewPagerAdapter
        binding.txtPageAll.text = (" / ${BannerList.size}")

        val thread = Thread(PagerRunnable())
        thread.start()
    }

    private fun autoScrollStop(){
        handler.removeMessages(0) // 핸들러를 중지시킴
    }

    override fun onGetUserSuccess(response: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetUserFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostSignUpFailure(message: String) {
        TODO("Not yet implemented")
    }

    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){
                try {
                    Thread.sleep(2000)
                    handler.sendEmptyMessage(0)
                } catch (e : InterruptedException){
                    Log.d("interupt", "interupt발생")
                }
            }
        }
    }

    fun setPage() {
        binding.txtPageNow.setText("${(currentPage % BannerList.size) + 1}")
        binding.bannerAd.setCurrentItem(currentPage, true)
        currentPage += 1
    }
}