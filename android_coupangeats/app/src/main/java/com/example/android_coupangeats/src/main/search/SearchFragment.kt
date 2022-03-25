package com.example.android_coupangeats.src.main.search

import android.os.Bundle
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentSearchBinding

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search){
    private var mCount = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}