package com.example.android_coupangeats.src.main.restaurant

import MenuFragment
import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragment: InformationRestaurantActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeliveryFragment()
            1 -> PackingFragment()
            else -> DeliveryFragment() }
    }
}

class MenuFragmentAdapter(fragment: InformationRestaurantActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {

        return MenuFragment()
    }
}