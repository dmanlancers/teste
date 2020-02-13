package pt.ren.mobile.investors.ui.activities.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.activity_main.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnBoardingCardTwo
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardOne
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardThree
import pt.ren.mobile.investors.utils.viewpager.DotIndicatorPager2Adapter


class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null
    val host = NavHostFragment.create(R.navigation.main_navigation)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager) as ViewPager2
        viewPager!!.adapter = MyAdapter(supportFragmentManager, lifecycle)
        viewPager!!.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        btn_skip.setOnClickListener {
            Log.d("btnSetup", "Selected")
            supportFragmentManager.beginTransaction().replace(R.id.my_nav_host_fragment, host).setPrimaryNavigationFragment(host).commit()
        }



    }
    override fun onSupportNavigateUp() =
        findNavController( R.id.my_nav_host_fragment).navigateUp()

    private inner class MyAdapter(fm: FragmentManager?, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm!!, lifecycle) {
        private val int_items = 3

        override fun createFragment(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment =
                    OnboardingCardOne()
                1 -> fragment =
                    OnBoardingCardTwo()
                2 -> fragment =
                    OnboardingCardThree()
                /*   3 -> fragment =
                    ViewPagerFragment()
             4 -> fragment =
                    ViewPagerFragment()*/
            }
            return fragment!!
        }

        override fun getItemCount(): Int {
            return int_items
        }

    }
}


