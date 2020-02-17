package pt.ren.mobile.investors.ui.activities.splash_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import pt.ren.mobile.investors.ui.activities.main.MainActivity
import pt.ren.mobile.investors.R


class SplashScreenActivity : AppCompatActivity(){
    private val SplashDisplayLenght =3000  //splash screen will be shown for 3 seconds

    /** Called when the activity is first created.  */
    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        },SplashDisplayLenght.toLong())
    }
}