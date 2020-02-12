package pt.ren.mobile.investors.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import pt.ren.mobile.investors.R


class OnboardingFragment : Fragment() {
    var viewPager2: ViewPager2? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_onboarding, parent, false)



    }



}