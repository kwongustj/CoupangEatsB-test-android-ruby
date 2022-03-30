package com.example.android_coupangeats.src.main.restaurant
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.ApplicationClass
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentMenuBinding
import com.example.android_coupangeats.src.main.restaurant.models.InformationRestaurantResponse

class MenuFragment(pageNum: Int) : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::bind, R.layout.fragment_menu),

    MenuFragmentView {

    var pageNum = pageNum

    val FoodList = arrayListOf<Food>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idxNum = ApplicationClass.sSharedPreferences.getString("store_num", " ")!!.toInt()

        //메뉴 가져오기
        MenuService(this, idxNum).tryGetMenu()
    }

    override fun onGetRestaurantSuccess(response: InformationRestaurantResponse) {


        //Log.e("${response.result.menuListStoredByCategory[pageNum].menuCategoryName}", response.result.menuListStoredByCategory[pageNum].menuCategoryName)

        binding.txtTitle.setText("${response.result.menuListStoredByCategory[pageNum].menuCategoryName}")

        for (j in response.result.menuListStoredByCategory[pageNum].menuList) {

            if(j.menuImgUrl == null){
                FoodList.add(
                    Food(
                        j.menuIdx,
                        "",
                        j.menuName,
                        j.menuPrice.toString(),
                        j.menuDetail
                    )
                )
            } else{
                FoodList.add(
                    Food(
                        j.menuIdx,
                        "https://ifh.cc/g/rBrQ4y.png",
                        j.menuName,
                        j.menuPrice.toString(),
                        j.menuDetail
                    )
                )
            }
            Log.e("왜 url가 안나오는 지 실험 중_FoodList","${FoodList}")

        }
//        //MenuFragment Menu 보여주기 _ RecyclerView
        val adapterFood = FoodViewPagerAdapter(FoodList)
        binding.recycelerviewMenu.adapter = adapterFood
    }

    override fun onGetRestaurantFailure(message: String) {
        TODO("Not yet implemented")


    }
}