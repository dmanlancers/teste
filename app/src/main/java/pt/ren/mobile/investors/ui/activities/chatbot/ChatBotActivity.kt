package pt.ren.mobile.investors.ui.activities.chatbot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_chatbot.*
import pt.ren.mobile.investors.R


class ChatBotActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_chatbot)

chatbot1_next_floating_button.setImageResource(R.drawable.chatbot1_btn_next)
            chatbot1_next_floating_button.setOnClickListener {view ->

                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }



        }
}


