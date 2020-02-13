import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnBoardingCardTwo
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardOne
import pt.ren.mobile.investors.ui.onboarding.ViewPagerCards.OnboardingCardThree

 class ViewPagerAdapter(fm: FragmentManager?, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm!!, lifecycle) {
    private val intItems = 3

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment =
                OnboardingCardOne()
            1 -> fragment =
                OnBoardingCardTwo()
            2 -> fragment =
                OnboardingCardThree()
            /*   3 -> fragment =
                ViewPagerFragment()
         4 -> fragment =
                ViewPagerFragment()*/
        }
        return fragment!!
    }

    override fun getItemCount(): Int {
        return intItems
    }

}