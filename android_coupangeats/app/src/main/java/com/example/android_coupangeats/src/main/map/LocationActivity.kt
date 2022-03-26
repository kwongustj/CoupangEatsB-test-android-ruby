package com.example.android_coupangeats.src.main.map

import android.os.Bundle
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityLocationBinding

class LocationActivity : BaseActivity<ActivityLocationBinding>(ActivityLocationBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnX.setOnClickListener {
            onBackPressed()
        }
    }

}