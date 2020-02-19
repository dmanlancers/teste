package pt.ren.mobile.investors.ui.activities.chatbot

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.fragment_chatbot_block01.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.utils.shared_preferences.SharedPreference


class ChatBotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)
        val sharedPreference = SharedPreference(this)
        etxt_name.requestFocus()
        txt_name.visibility = View.INVISIBLE
        user_logo.visibility = View.INVISIBLE

        // chatbot1_next_floating_button.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_botao))

        chatbot1_next_floating_button.setImageResource(R.drawable.ic_right_arow)

        chatbot1_next.setOnClickListener { view ->

            val name = etxt_name.editableText.toString()
            sharedPreference.save("name", name)
            val imm: InputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

            etxt_name.visibility = View.INVISIBLE
            user_logo.visibility = View.VISIBLE
            chatbot1_next.visibility = View.INVISIBLE
            txt_name.visibility = View.VISIBLE
            if (sharedPreference.getValueString("name") != null) {
                txt_name.setText(sharedPreference.getValueString("name")!!)

            }

        }



        chatbot1_next_floating_button.setOnClickListener { view ->


            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }


    }
}


