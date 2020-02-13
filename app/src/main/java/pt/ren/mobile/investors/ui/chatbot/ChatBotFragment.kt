package pt.ren.mobile.investors.ui.chatbot


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_chatbot.*
import pt.ren.mobile.investors.R


class ChatBotFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_chatbot, parent, false)





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_next.setOnClickListener {
            val navhost = activity?.supportFragmentManager?.findFragmentById(R.id.my_nav_host_fragment)
            val c = NavHostFragment.findNavController(navhost!!)
            c.navigate(R.id.action_chatBot1Fragment_to_profileFragment)
            Log.i("TESTE", "OUTRO")

        }

        super.onViewCreated(view, savedInstanceState)
    }

}