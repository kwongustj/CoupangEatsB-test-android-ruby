import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.android_coupangeats.R
import com.example.android_coupangeats.config.BaseFragment
import com.example.android_coupangeats.databinding.FragmentMenuBinding
import com.example.android_coupangeats.src.main.restaurant.Food
import com.example.android_coupangeats.src.main.restaurant.FoodViewPagerAdapter
import com.example.android_coupangeats.src.main.restaurant.MenuFragmentView
import com.example.android_coupangeats.src.main.restaurant.ReviewPagerAdapter

class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::bind, R.layout.fragment_menu),

    MenuFragmentView {

    val FoodList = arrayListOf<Food>(
        Food("https://ifh.cc/g/3kwRPG.png","김치볶음밥","18,000","아주 맛있습니다.",true,false),
        Food("https://ifh.cc/g/3kwRPG.png","계란후라이","8,000","아주 맛있습니다. 아주 고소하고 맛있어요",false,true),
        Food("https://ifh.cc/g/3kwRPG.png","김치볶음밥","18,000","아주 맛있습니다.",true,false),
        Food("https://ifh.cc/g/3kwRPG.png","계란후라이","8,000","아주 맛있습니다. 아주 고소하고 맛있어요",false,true),
        Food("https://ifh.cc/g/3kwRPG.png","김치볶음밥","18,000","아주 맛있습니다.",true,false),
        Food("https://ifh.cc/g/3kwRPG.png","계란후라이","8,000","아주 맛있습니다. 아주 고소하고 맛있어요",false,true)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterFood = FoodViewPagerAdapter(FoodList)
        binding.recycelerviewMenu.adapter = adapterFood
    }

}