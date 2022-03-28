package com.example.android_coupangeats.src.main.map

import android.content.Intent
import android.os.Bundle
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityLocationBinding
import com.example.android_coupangeats.src.main.login.LoginActivity

class LocationActivity : BaseActivity<ActivityLocationBinding>(ActivityLocationBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnX.setOnClickListener {
            onBackPressed()
        }

        binding.btnFindMyLocation.setOnClickListener {
            val intent = Intent(this, MyLocationActivity::class.java)
            startActivity(intent)
        }
    }

}