package com.example.android_coupangeats.src.main.map

import android.annotation.SuppressLint
import android.graphics.Camera
import android.os.Bundle
import android.util.Log
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMyLocationBinding
import com.google.android.gms.location.*
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource

class MyLocationActivity : BaseActivity<ActivityMyLocationBinding>(ActivityMyLocationBinding::inflate)
    , OnMapReadyCallback {
    private lateinit var MylocationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    private lateinit var mapView: MapView
    //내 위치를 가져오는 코드
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient //자동으로 gps값을 받아온다.
    lateinit var locationCallback: LocationCallback //gps응답 값을 가져온다.
    //lateinit: 나중에 초기화 해주겠다는 의미

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)


        Log.e("LOCATION_PERMISSION_REQUEST_CODE",LOCATION_PERMISSION_REQUEST_CODE.toString())
        MylocationSource =
            FusedLocationSource(this@MyLocationActivity, LOCATION_PERMISSION_REQUEST_CODE)

        binding.btnMyLocation.setOnClickListener {
            MylocationSource =
                FusedLocationSource(this@MyLocationActivity, LOCATION_PERMISSION_REQUEST_CODE)

        }

    }


    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap

        naverMap.locationTrackingMode = LocationTrackingMode.Follow
        //val cameraupdate = CameraUpdate.scrollTo(LatLng(37.497885,127.027512))
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(this) //gps 자동으로 받아오기
        setUpdateLocationListner() //내위치를 가져오는 코드

        val uiSettings = naverMap.uiSettings
        uiSettings.isLocationButtonEnabled = true
        naverMap.locationSource = MylocationSource
    }

    @SuppressLint("MissingPermission")
    fun setUpdateLocationListner() {
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY //높은 정확도
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for ((i, location) in locationResult.locations.withIndex()) {
                    Log.d("location: ", "${location.latitude}, ${location.longitude}")
                    val  cameraupdate = CameraUpdate.scrollTo(LatLng(location.latitude,location.longitude))
                    naverMap.moveCamera(cameraupdate)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            Log.e("requestCode != LOCATION_PERMISSION_REQUEST_CODE","requestCode != LOCATION_PERMISSION_REQUEST_CODE")
            return
        }
        if (MylocationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!MylocationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
                Log.e("권한 거부","권한 거부")
            }else {
                naverMap.locationTrackingMode = LocationTrackingMode.Follow
            }
            return
        }

    }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

}