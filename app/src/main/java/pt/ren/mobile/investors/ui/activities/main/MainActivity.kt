package pt.ren.mobile.investors.ui.activities.main

import ViewPagerAdapter
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.chatbot.ChatBotActivity
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnBoardingCardTwo
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardOne
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardThree


class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager)
        viewPager!!.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager!!.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        btn_skip.setOnClickListener {

                val mainIntent = Intent(this@MainActivity, ChatBotActivity::class.java)
                startActivity(mainIntent)
        }

    }

    override fun onSupportNavigateUp() =
        findNavController( R.id.my_nav_host_fragment).navigateUp()


}


