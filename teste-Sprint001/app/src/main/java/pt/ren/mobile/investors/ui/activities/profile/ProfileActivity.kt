package pt.ren.mobile.investors.ui.activities.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_profile.*

import pt.ren.mobile.investors.R

class ProfileActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profile_fab.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_right_arow
            )
        )

    }
}