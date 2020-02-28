package pt.ren.mobile.investors.ui.activities.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.activity_profile.*

import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.splash_screen.SplashScreenActivity

class ProfileActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnFab()
        profile_fab.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_right_arrow
            )
        )

    }

    private fun btnFab() {

        profile_fab.setOnClickListener {
            val mainIntent = Intent(this@ProfileActivity, SplashScreenActivity::class.java)
            startActivity(mainIntent)

            /* Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                 .setAction("Action", null)
                 .show()*/
        }

    }
}