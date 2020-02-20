package pt.ren.mobile.investors.ui.activities.main


import ViewPagerAdapter
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

import kotlinx.android.synthetic.main.activity_main.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.chatbot.ChatBotActivity


class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager2? = null
    private lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager)
        viewPager!!.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager!!.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        mainActivityViewModel = ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)

        mainActivityViewModel.title.observe(this, Observer {  title ->


        })

        mainActivityViewModel.detail.observe(this, Observer {  detail ->


        })
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager?.adapter = adapter
        dotsIndicator.setViewPager2(viewPager!!)


        btn_skip.setOnClickListener {

                val mainIntent = Intent(this@MainActivity, ChatBotActivity::class.java)
                startActivity(mainIntent)
        }

    }

    /*override fun onSupportNavigateUp() =
        findNavController( R.id.my_nav_host_fragment).navigateUp()*/


}


