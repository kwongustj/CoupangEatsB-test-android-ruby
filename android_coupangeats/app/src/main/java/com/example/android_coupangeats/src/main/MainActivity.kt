package com.example.android_coupangeats.src.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMainBinding
import com.example.android_coupangeats.src.main.login.BottomActivity
import com.example.android_coupangeats.src.main.heart.HeartFragment
import com.example.android_coupangeats.src.main.home.HomeFragment
import com.example.android_coupangeats.src.main.myPage.MyPageFragment
import com.example.android_coupangeats.src.main.order.OrderFragment
import com.example.android_coupangeats.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreference = getSharedPreferences("COUPANGEATS APP", MODE_PRIVATE)
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_heart -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HeartFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_order -> {
                        if(sharedPreference.getString("COUPANG"," ") == " " ) {
                            val intent = Intent(this, BottomActivity::class.java)
                            startActivity(intent)

                        }else {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, OrderFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    R.id.menu_main_btm_nav_my_page -> {
                        if(sharedPreference.getString("COUPANG"," ") == " " ) {
                            val intent = Intent(this, BottomActivity::class.java)
                            startActivity(intent)

                        }else {
                            val t = sharedPreference.getString("COUPANG","데이터 없음 ")
                            Log.e("값",t.toString())
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                        }
                    }
                }
                false
            })
    }
}