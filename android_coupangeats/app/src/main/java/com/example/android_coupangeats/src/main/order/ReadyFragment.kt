package com.example.android_coupangeats.src.main.order

import android.os.Bundle
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentOrderBinding
import com.example.android_coupangeats.databinding.FragmentReadyBinding
import com.example.android_coupangeats.src.main.restaurant.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ReadyFragment : BaseFragment<FragmentReadyBinding>(FragmentReadyBinding::bind, R.layout.fragment_ready){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}