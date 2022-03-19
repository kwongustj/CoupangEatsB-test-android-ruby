package com.example.android_coupangeats.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentHomeBinding
import com.example.android_coupangeats.src.main.home.models.PostSignUpRequest
import com.example.android_coupangeats.src.main.home.models.SignUpResponse
import com.example.android_coupangeats.src.main.home.models.UserResponse

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}