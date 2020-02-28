package pt.ren.mobile.investors.ui.activities.splash_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.ctb_block01.*
import pt.ren.mobile.investors.ui.activities.main.MainActivity
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.repository.AppDatabase
import pt.ren.mobile.investors.utils.shared_preferences.SharedPreference


class SplashScreenActivity : AppCompatActivity(){
    private val splashDisplayLength =1000  //splash screen will be shown for 3 seconds
    var rooted: Boolean  = RootUtil.CheckRootedDevice.isDeviceRooted()


    /** Called when the activity is first created.  */
    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_splash)
        val sharedPreference = SharedPreference(this)
        val name = sharedPreference.getValueString("name")
        val txtWelcomeLogin = resources.getString(R.string.welcome_back, name.toString().toUpperCase())
        val txtWelcomeRegister = resources.getString(R.string.welcome)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Investors"
        ).build()
       //db.userDao().getAll()

        /*val investorName = SpannableString(name.toString().toUpperCase() )
        investorName.setSpan(UnderlineSpan(), 0, investorName.length, 0)
*/


        /*val presentation = TextUtils.concat(txtGreetingsStart, investorName, txtGreetingsEnd)*/


      /*  if(name != null){

        txt_welcome.text = txtWelcomeLogin

        }else{

            txt_welcome.text = txtWelcomeRegister
        }*/

        if (!rooted) {

            val builder = AlertDialog.Builder(this@SplashScreenActivity)

            // Set the alert dialog title
            builder.setTitle("Security Issue!!")

            // Display a message on alert dialog
            builder.setMessage("Your device is rooted...\n Please contact us...")

            // Set a positive button and its click listener on alert dialog
            builder.setPositiveButton("OK") { _, _ ->
                // Do something when user press the positive button
                finish()


            }


            /*  // Display a negative button on alert dialog
            builder.setNegativeButton("No"){dialog,which ->
                Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
            }


            // Display a neutral button on alert dialog
            builder.setNeutralButton("Cancel"){_,_ ->
                Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
            }
*/
            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        } else {

            Handler().postDelayed({
                val mainIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }, splashDisplayLength.toLong())

        }


    }


}