package com.example.android_coupangeats.src.main.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Camera
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.app.ActivityCompat
import com.example.android_coupangeats.config.BaseActivity
import com.example.android_coupangeats.databinding.ActivityMyLocationBinding
import com.google.android.gms.location.*
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource
import kotlin.properties.Delegates

class MyLocationActivity : BaseActivity<ActivityMyLocationBinding>(ActivityMyLocationBinding::inflate)
    , OnMapReadyCallback {
    private lateinit var MylocationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap
    private lateinit var mapView: MapView
    //내 위치를 가져오는 코드
    var cameraupdate = CameraUpdate.scrollTo(LatLng(37.497885,127.027512))
    private lateinit var fusedLocationClient: FusedLocationProviderClient//자동으로 gps값을 받아온다.
    lateinit var locationCallback: LocationCallback //gps응답 값을 가져온다.
    //위도 경도 -> 내 위치로
    var geocoder = Geocoder(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        Log.e("LOCATION_PERMISSION_REQUEST_CODE",LOCATION_PERMISSION_REQUEST_CODE.toString())
        MylocationSource =
            FusedLocationSource(this@MyLocationActivity, LOCATION_PERMISSION_REQUEST_CODE)

    }


    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap

        naverMap.locationTrackingMode = LocationTrackingMode.Follow
    //    fusedLocationProviderClient =
          //  LocationServices.getFusedLocationProviderClient(this) //gps 자동으로 받아오기
           // setUpdateLocationListner() //내위치를 가져오는 코드

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                 val address = geocoder.getFromLocation(location!!.latitude, location.longitude,1)
                Log.e("address","$address")
            //    binding.txtLocationContent.setText(address[0].adminArea)
            }

        val uiSettings = naverMap.uiSettings
        uiSettings.isLocationButtonEnabled = true
       uiSettings.isZoomControlEnabled = false
        naverMap.locationSource = MylocationSource
    }




//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        if(requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
//            Log.e("requestCode != LOCATION_PERMISSION_REQUEST_CODE","requestCode != LOCATION_PERMISSION_REQUEST_CODE")
//            return
//        }
//        if (MylocationSource.onRequestPermissionsResult(requestCode, permissions,
//                grantResults)) {
//            if (!MylocationSource.isActivated) { // 권한 거부됨
//                naverMap.locationTrackingMode = LocationTrackingMode.None
//                Log.e("권한 거부","권한 거부")
//            }else {
//                naverMap.locationTrackingMode = LocationTrackingMode.Follow
//            }
//            return
//        }
//
//    }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

}