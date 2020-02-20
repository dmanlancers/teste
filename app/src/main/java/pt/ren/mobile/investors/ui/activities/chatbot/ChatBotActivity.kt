package pt.ren.mobile.investors.ui.activities.chatbot

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.inputmethod.InputMethodManager
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.ctb_block01.*
import kotlinx.android.synthetic.main.ctb_block02.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.utils.shared_preferences.SharedPreference


class ChatBotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)
        val sharedPreference = SharedPreference(this)
      //  etxt_name.requestFocus()
       txt_name.visibility = View.INVISIBLE
        user_logo.visibility = View.INVISIBLE
        chatbot1_next_floating_button.visibility = View.INVISIBLE
       val marginBlock01 = block01_container?.layoutParams as MarginLayoutParams
        val marginBlock02 = block02_container?.layoutParams as MarginLayoutParams
         val SplashDisplayLenght =1000  //splash screen will be shown for 3 seconds
        chatbot1_next_floating_button.setImageResource(R.drawable.ic_right_arow)

     btn_submit_block01.setOnClickListener { view ->

            val name = etxt_block01.editableText.toString()
            sharedPreference.save("name", name)
            val imm: InputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

            etxt_block01.visibility = View.INVISIBLE
            user_logo.visibility = View.VISIBLE
            btn_submit_block01.visibility = View.INVISIBLE
            txt_name.visibility = View.VISIBLE
            if (sharedPreference.getValueString("name") != null) {
                txt_name.text = sharedPreference.getValueString("name")!!

            }

         Handler().postDelayed({
             marginBlock01.topMargin= 900
             chatbot_scrollview.post(Runnable { chatbot_scrollview.scrollTo(0, txt_name.top) })
             marginBlock02.topMargin = 800
         },SplashDisplayLenght.toLong())
        /* chatbot_scrollview.post(Runnable { chatbot_scrollview.fullScroll(ScrollView.FOCUS_DOWN) })
         chatbot_scrollview.post(Runnable { chatbot_scrollview.scrollTo(0, txt_block01.bottom) })*/
         //chatbot_scrollview.post(Runnable { chatbot_scrollview.scrollTo(0, txt_block01.bottom) })
         /*chatbot_scrollview.post(Runnable { chatbot_scrollview.fullScroll(ScrollView.FOCUS_UP) })*/
        /* marginBlock01.topMargin= 400

         marginBlock02.bottomMargin = 800*/


        }



        chatbot1_next_floating_button.setOnClickListener   { view ->


            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        fun setMarginBock01() {


       /*     val marginsTxtName = chatbot_fragment_01.layoutParams as MarginLayoutParams
            margins.topMargin= 820
*/
        }


    }
}


