package pt.ren.mobile.investors.utils.viewpager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.main.MainActivity


class ViewPagerAdapter internal constructor(
    context: MainActivity,
    data: List<String>,
    viewPager2: ViewPager2
) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    private val mData: List<String>
    private val mInflater: LayoutInflater
    private val viewPager2: ViewPager2
    private val colorArray = intArrayOf(
        R.color.blue_100,
        R.color.chuck_colorAccent,
        R.color.chuck_status_error

    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = mInflater.inflate(R.layout.item_viewpager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val animal = mData[position]
        holder.myTextView.text = animal
        holder.constraintLayout.setBackgroundResource(colorArray[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var myTextView: TextView
        var constraintLayout: ConstraintLayout
        var button: Button

        init {
            myTextView = itemView.findViewById(R.id.tvTitle)
            constraintLayout = itemView.findViewById(R.id.container)
            button = itemView.findViewById(R.id.btnToggle)
            button.setOnClickListener {
                if (viewPager2.orientation == ViewPager2.ORIENTATION_VERTICAL) viewPager2.orientation =
                    ViewPager2.ORIENTATION_HORIZONTAL else {
                    viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
                }
            }
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
        mData = data
        this.viewPager2 = viewPager2
    }


}

