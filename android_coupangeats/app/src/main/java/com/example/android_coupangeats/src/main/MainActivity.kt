package com.example.android_coupangeats.src.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMainBinding
import com.example.android_coupangeats.src.main.login.BottomActivity
import com.example.android_coupangeats.src.main.heart.HeartActivity
import com.example.android_coupangeats.src.main.heart.NoHeartActivity
import com.example.android_coupangeats.src.main.home.HomeFragment
import com.example.android_coupangeats.src.main.myPage.MyPageFragment
import com.example.android_coupangeats.src.main.order.OrderFragment
import com.example.android_coupangeats.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isEmpty = false
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
                        if(ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN"," ") == " " ) {
                            val intent = Intent(this, NoHeartActivity::class.java)
                            startActivity(intent)

                        }else {
                            if(isEmpty == true){
                                val intent = Intent(this, NoHeartActivity::class.java)
                                startActivity(intent)
                            }else{
                                val intent = Intent(this, HeartActivity::class.java)
                                startActivity(intent)
                            }
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    R.id.menu_main_btm_nav_order -> {
                        if(ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN"," ") == " " ) {
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
                        if(ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN"," ") == " " ) {
                            val intent = Intent(this, BottomActivity::class.java)
                            startActivity(intent)

                        }else {
                            val t = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","데이터 없음 ")
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