package com.example.android_coupangeats.src.main.restaurant
import android.util.Log
import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_coupangeats.config.BaseFragment

class FragmentAdapter(fragment: InformationRestaurantActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeliveryFragment()
            1 -> PackingFragment()
            else -> DeliveryFragment() }
    }
}

class MenuFragmentAdapter(fragment: InformationRestaurantActivity,count: Int) : FragmentStateAdapter(fragment) {
    var count = count

    override fun getItemCount(): Int {
        Log.e("count",count.toString())
        return count
    }

    override fun createFragment(position: Int): Fragment {

        Log.e("position","$position")
        return MenuFragment(position)
    }
}