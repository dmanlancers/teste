package pt.ren.mobile.investors.ui.chatbot


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pt.ren.mobile.investors.R


class ChatBot1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_chatbot1, parent, false)
    }
}