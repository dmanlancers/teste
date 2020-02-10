package pt.ren.mobile.investors.ui.chatbot


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pt.ren.mobile.investors.R

class ChatBot4Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.chatbot4_fragment,
            container, false)

        return view
    }


}