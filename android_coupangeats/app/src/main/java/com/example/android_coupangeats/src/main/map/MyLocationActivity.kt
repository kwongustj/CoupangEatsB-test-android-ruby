package com.example.android_coupangeats.src.main.map

import android.os.Bundle
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMyLocationBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource

class MyLocationActivity : BaseActivity<ActivityMyLocationBinding>(ActivityMyLocationBinding::inflate)
    , OnMapReadyCallback {
    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource

        val cameraupdate = CameraUpdate.scrollTo(LatLng(37.497885,127.027512))
        naverMap.moveCamera(cameraupdate)

        val uiSettings = naverMap.uiSettings
        uiSettings.isLocationButtonEnabled = true



    }

}