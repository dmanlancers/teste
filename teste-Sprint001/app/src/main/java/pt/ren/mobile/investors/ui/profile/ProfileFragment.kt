package pt.ren.mobile.investors.ui.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.fragment_profile.*
import pt.ren.mobile.investors.R


class ProfileFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_profile, parent, false)

    }


}