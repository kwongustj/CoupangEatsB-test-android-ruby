package com.example.android_coupangeats.src.main.order

import android.os.Bundle
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentOrderBinding
import com.example.android_coupangeats.src.main.restaurant.FragmentAdapterMyOrder
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment : BaseFragment<FragmentOrderBinding>(FragmentOrderBinding::bind, R.layout.fragment_order){

    var tabName = arrayListOf<String>("과거 주문 내역", "준비중")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //tablayout 연결
        val adapter = FragmentAdapterMyOrder(this)
        binding.orderPager.adapter = adapter


        // tab1 ( 과거 주문 내역 / 준비중 )
        //슬라이드로 이동했을 때, 탭이 같이 변경되도록
        TabLayoutMediator(binding.tabLayout, binding.orderPager)
        {
                tab, position -> tab.text = tabName[position].toString()
        }.attach()
        //탭이 선택되었을 때, 뷰페이저가 같이 변경되도록
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.orderPager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }

}