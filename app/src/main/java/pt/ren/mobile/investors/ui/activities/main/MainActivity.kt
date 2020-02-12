package pt.ren.mobile.investors.ui.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnBoardingCardTwo
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardOne
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardThree


class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_onboarding)
        viewPager = findViewById(R.id.viewpager) as ViewPager2
        viewPager!!.adapter = MyAdapter(supportFragmentManager, lifecycle)
        viewPager!!.orientation = ViewPager2.ORIENTATION_HORIZONTAL



        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(viewPager)

      /*  val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
      *//*  val springDotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)*//*

        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager)
        val adapter = DotIndicatorPager2Adapter()
        viewPager2.adapter = adapter*/

       /* val zoomOutPageTransformer = ZoomOutPageTransformer()
        viewPager2.setPageTransformer { page, position ->
            zoomOutPageTransformer.transformPage(page, position)
        }*/

        //dotsIndicator.setViewPager2(viewPager2)
       /* springDotsIndicator.setViewPager2(viewPager2)
        wormDotsIndicator.setViewPager2(viewPager2)*/



    }

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