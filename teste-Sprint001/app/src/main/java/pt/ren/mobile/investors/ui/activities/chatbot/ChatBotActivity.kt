package pt.ren.mobile.investors.ui.activities.chatbot


import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.ctb_block01.*
import kotlinx.android.synthetic.main.ctb_block02.*
import kotlinx.android.synthetic.main.ctb_block03.*
import kotlinx.android.synthetic.main.ctb_block05.*
import kotlinx.android.synthetic.main.ctb_block08.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.profile.ProfileActivity
import pt.ren.mobile.investors.utils.shared_preferences.SharedPreference
import timber.log.Timber


class ChatBotActivity : AppCompatActivity() {

    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)
        val marginRowBlock01 = ctb_block01?.layoutParams as MarginLayoutParams

        val editTextBlock01 = divider01?.layoutParams as MarginLayoutParams
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width: Int = size.x
        val heightPx: Int = size.y
        val screenSize = heightPx.pxToDp(this.resources.displayMetrics)




        if (screenSize <= 618) {

            marginRowBlock01.topMargin = 1300

        } else {

            marginRowBlock01.topMargin = 1600
        }
        //etxt_name.requestFocus()

        fab.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_right_arow
            )
        )
        fab.visibility = View.GONE
        txt_name.visibility = View.GONE
        user_logo.visibility = View.GONE
        ctb_block02.visibility = View.GONE
        ctb_block03.visibility = View.GONE
        ctb_block04.visibility = View.GONE
        ctb_block05.visibility = View.GONE
        ctb_block06.visibility = View.GONE
        ctb_block07.visibility = View.GONE
        ctb_block08.visibility = View.GONE
        ctb_block09.visibility = View.GONE
        //profile_block.visibility = View.GONE



        btn_submit_block01.setOnClickListener {


            scrollToBlock3()

        }

        //Button Listeners
        btnProficient()
        btnIntermediate()
        btnElementary()
        btnConsiderably()
        btnModerately()
        btnFew()
        btnFab()
        btnConsiderably()
        btnModerately()
        btnFew()
        btnSocial()
        btnEnvironment()
        btnRenewable()
        btnMarketInformation()
        btnFinancialInformation()
        btnGovernance()
        btnInfrastruture()
        btnStakeholder()
        btnQualityService()
        submitForm()


    }

    //Auto Scroll
    private fun scrollToBlock3() {

        val sharedPreference = SharedPreference(this)
        val name = etxt_block01.editableText.toString()
        sharedPreference.save("name", name)
        val presentation = resources.getString(R.string.txt_greetings, name);


        val imm: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)


        etxt_block01.visibility = View.INVISIBLE
        user_logo.visibility = View.VISIBLE
        btn_submit_block01.visibility = View.INVISIBLE
        txt_name.visibility = View.VISIBLE
        txt_block02.text = presentation

        if (sharedPreference.getValueString("name") != null) {
            txt_name.text = sharedPreference.getValueString("name")!!

        }
        val dividerBlock02 = divider02?.layoutParams as MarginLayoutParams


        Handler().postDelayed({
            ctb_block02.visibility = View.VISIBLE
            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider02.bottom)
            animator.duration = 900
            animator.start()
        }, 500.toLong())




        Handler().postDelayed({


            val dividerBlock03 = divider03?.layoutParams as MarginLayoutParams
            ctb_block03.visibility = View.VISIBLE

            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider03.bottom)
            animator.duration = 900
            animator.start()
            dividerBlock03.bottomMargin = 100

            btn_proficient.visibility = View.GONE
            btn_intermediate.visibility = View.GONE
            btn_elementary.visibility = View.GONE
            Handler().postDelayed({
                btn_proficient.visibility = View.VISIBLE


                btn_proficient.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 200.toLong())

            Handler().postDelayed({
                btn_intermediate.visibility = View.VISIBLE

                btn_intermediate.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 400.toLong())

            Handler().postDelayed({

                btn_elementary.visibility = View.VISIBLE
                btn_elementary.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 600.toLong())


        }, 3000.toLong())


    }

    private fun scrollToBlock5() {

        Handler().postDelayed({
            val dividerBlock04 = divider04?.layoutParams as MarginLayoutParams
            ctb_block04.visibility = View.VISIBLE
            //dividerBlock04.bottomMargin = 200
            val animator = ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider04.bottom)
            animator.duration = 900
            animator.start()


        }, 2000.toLong())

        Handler().postDelayed({
            val dividerBlock05 = divider05?.layoutParams as MarginLayoutParams
            ctb_block05.visibility = View.VISIBLE
            dividerBlock05.bottomMargin = 200
            val animator = ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider05.bottom)
            animator.duration = 900
            animator.start()



            Handler().postDelayed({



                btn_considerably.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 200.toLong())

            Handler().postDelayed({


                btn_moderately.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 400.toLong())

            Handler().postDelayed({


                btn_few.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 600.toLong())


        }, 3000.toLong())
    }

    private fun scrollToBlock8() {

        Handler().postDelayed({
            val dividerBlock06 = divider06?.layoutParams as MarginLayoutParams
            ctb_block06.visibility = View.VISIBLE
            dividerBlock06.bottomMargin = 200
            val animator = ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider06.bottom)
            animator.duration = 900
            animator.start()


        }, 1000.toLong())


        Handler().postDelayed({
            val dividerBlock07 = divide07?.layoutParams as MarginLayoutParams
            ctb_block07.visibility = View.VISIBLE
            // middleBlock07.bottomMargin = 200
            val animator = ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divide07.bottom)
            animator.duration = 900
            animator.start()


        }, 2000.toLong())


        Handler().postDelayed({
            val dividerBlock08 = divider08?.layoutParams as MarginLayoutParams
            ctb_block08.visibility = View.VISIBLE
            dividerBlock08.bottomMargin = 300
            val animator = ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider08.bottom)
            animator.duration = 900
            animator.start()

            Handler().postDelayed({



                scv_block08.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 200.toLong())


        }, 3000.toLong())

    }

    private fun scrollToFinal() {


        val dividerBlock09 = divider09?.layoutParams as MarginLayoutParams
        ctb_block09.visibility = View.VISIBLE
        dividerBlock09.bottomMargin = 200
        val animator = ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider09.bottom)
        animator.duration = 900
        animator.start()

        fab.visibility = View.GONE




        Handler().postDelayed({
        /*    profile_block.visibility = View.VISIBLE
            chatBotScrollView.post {
                chatBotScrollView.fullScroll(View.FOCUS_DOWN)
            }*/

            val mainIntent = Intent(this@ChatBotActivity, ProfileActivity::class.java)
            startActivity(mainIntent)
            overridePendingTransition(R.anim.fade_in, R.anim.slide_in_bottom)
            //profile_fab.visibility = View.VISIBLE

        }, 1000.toLong())


    }

    //Button Listeners

    private fun btnProficient() {

        btn_proficient.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val proficient = "proficient"
            val btnIntermediateStatus = btn_intermediate.isClickable
            val btnElementaryStatus = btn_elementary.isClickable

            sharedPreference.save("rate", proficient)
            btn_proficient.setBackgroundResource(R.drawable.ic_option_selected)
            btn_proficient.setTextColor(Color.parseColor("#001464"))


            if (btnIntermediateStatus && btnElementaryStatus) {

                btn_intermediate.isClickable = false
                btn_elementary.isClickable = false

                scrollToBlock5()

            } else {
                btn_proficient.setBackgroundResource(R.drawable.ic_chatbot_rate_rounded)
                btn_proficient.setTextColor(Color.parseColor("#ffffff"))

                btn_intermediate.isClickable = true
                btn_elementary.isClickable = true

            }


            Timber.i(String.format("BTN, %s", proficient))
        }

    }

    private fun btnIntermediate() {


        btn_intermediate.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val intermediate = "intermediate"
            val btnProficientStatus = btn_proficient.isClickable
            val btnElementaryStatus = btn_elementary.isClickable

            sharedPreference.save("rate", intermediate)
            btn_intermediate.setBackgroundResource(R.drawable.ic_option_selected)
            btn_intermediate.setTextColor(Color.parseColor("#001464"))


            if (btnProficientStatus && btnElementaryStatus) {

                btn_proficient.isClickable = false
                btn_elementary.isClickable = false

                scrollToBlock5()

            } else {
                btn_intermediate.setBackgroundResource(R.drawable.ic_chatbot_rate_rounded)
                btn_intermediate.setTextColor(Color.parseColor("#ffffff"))

                btn_proficient.isClickable = true
                btn_elementary.isClickable = true

            }

            Timber.i(String.format("BTN, %s", intermediate))
        }

    }

    private fun btnElementary() {
        btn_elementary.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val elementary = "elementary"
            val btnProficientStatus = btn_proficient.isClickable
            val btnIntermediateStatus = btn_intermediate.isClickable

            sharedPreference.save("rate", elementary)
            btn_elementary.setBackgroundResource(R.drawable.ic_option_selected)
            btn_elementary.setTextColor(Color.parseColor("#001464"))


            if (btnProficientStatus && btnIntermediateStatus) {

                btn_proficient.isClickable = false
                btn_intermediate.isClickable = false

                scrollToBlock5()

            } else {
                btn_elementary.setBackgroundResource(R.drawable.ic_chatbot_rate_rounded)
                btn_elementary.setTextColor(Color.parseColor("#ffffff"))

                btn_proficient.isClickable = true
                btn_intermediate.isClickable = true

            }

            Timber.i(String.format("BTN, %s", elementary))
        }


    }

    private fun btnConsiderably() {

        btn_considerably.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val considerably = "considerably"
            val btnModeratelyStatus = btn_moderately.isClickable
            val btnFewStatus = btn_few.isClickable

            sharedPreference.save("know", considerably)
            btn_considerably.setBackgroundResource(R.drawable.ic_option_selected)
            btn_considerably.setTextColor(Color.parseColor("#001464"))


            if (btnModeratelyStatus && btnFewStatus) {

                btn_moderately.isClickable = false
                btn_few.isClickable = false

                scrollToBlock8()

            } else {
                btn_considerably.setBackgroundResource(R.drawable.ic_chatbot_rate_rounded)
                btn_considerably.setTextColor(Color.parseColor("#ffffff"))

                btn_moderately.isClickable = true
                btn_few.isClickable = true

            }


            Timber.i(String.format("BTN, %s", considerably))
        }

    }

    private fun btnModerately() {


        btn_moderately.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val moderately = "moderately"
            val btnConsiderablyStatus = btn_considerably.isClickable
            val btnFewStatus = btn_few.isClickable

            sharedPreference.save("know", moderately)
            btn_moderately.setBackgroundResource(R.drawable.ic_option_selected)
            btn_moderately.setTextColor(Color.parseColor("#001464"))


            if (btnConsiderablyStatus && btnFewStatus) {

                btn_considerably.isClickable = false
                btn_few.isClickable = false

                scrollToBlock5()

            } else {
                btn_moderately.setBackgroundResource(R.drawable.ic_chatbot_rate_rounded)
                btn_moderately.setTextColor(Color.parseColor("#ffffff"))

                btn_proficient.isClickable = true
                btn_few.isClickable = true

            }

            Timber.i(String.format("BTN, %s", moderately))
        }

    }

    private fun btnFew() {
        btn_few.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val few = "few"
            val btnConsiderablyStatus = btn_considerably.isClickable
            val btnModeratelyStatus = btn_moderately.isClickable

            sharedPreference.save("know", few)
            btn_few.setBackgroundResource(R.drawable.ic_option_selected)
            btn_few.setTextColor(Color.parseColor("#001464"))
            counter

            if (btnConsiderablyStatus && btnModeratelyStatus) {

                btn_considerably.isClickable = false
                btn_moderately.isClickable = false

                scrollToBlock8()

            } else {
                btn_few.setBackgroundResource(R.drawable.ic_chatbot_rate_rounded)
                btn_few.setTextColor(Color.parseColor("#ffffff"))

                btn_considerably.isClickable = true
                btn_moderately.isClickable = true

            }

            Timber.i(String.format("BTN, %s", few))
        }


    }

    private fun btnSocial() {


        btn_social.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val social = "social"
            counter =
                if (btn_social.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_social.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area1")
                    counter.minus(1)
                } else {

                    btn_social.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area1", social)
                    counter.plus(1)


                }

            Timber.i(String.format("BTN, %s", counter))




            Timber.i(String.format("BTN, %s", social))

        }
        submitForm()

    }

    private fun btnEnvironment() {

        btn_environment.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val environment = "environment"

            counter =
                if (btn_environment.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_environment.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area2")
                    counter.minus(1)
                } else {

                    btn_environment.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area2", environment)
                    counter.plus(1)


                }
            Timber.i(String.format("BTN, %s", counter))
            Timber.i(String.format("BTN, %s", environment))
        }
        submitForm()
    }

    private fun btnRenewable() {

        btn_renewable.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val renewable = "renewable"

            counter =
                if (btn_renewable.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_renewable.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area3")
                    counter.minus(1)
                } else {

                    btn_renewable.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area3", renewable)
                    counter.plus(1)


                }

            Timber.i(String.format("BTN, %s", counter))
            Timber.i(String.format("BTN, %s", renewable))

            submitForm()
        }
    }

    private fun btnMarketInformation() {

        btn_market_information.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val marketInformation = "market_information"

            counter =
                if (btn_market_information.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_market_information.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area4")
                    counter.minus(1)
                } else {

                    btn_market_information.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area4", marketInformation)
                    counter.plus(1)


                }


            Timber.i(String.format("BTN, %s", marketInformation))

            submitForm()
        }
    }

    private fun btnFinancialInformation() {

        btn_financial_information.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val financialInformation = "financial_information"

            counter =
                if (btn_financial_information.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_financial_information.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area5")
                    counter.minus(1)
                } else {

                    btn_financial_information.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area5", financialInformation)
                    counter.plus(1)


                }


            Timber.i(String.format("BTN, %s", financialInformation))

            submitForm()
        }
    }

    private fun btnGovernance() {

        btn_governance.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val governance = "governance"

            counter =
                if (btn_governance.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_governance.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area6")
                    counter.minus(1)
                } else {

                    btn_governance.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area6", governance)
                    counter.plus(1)


                }


            Timber.i(String.format("BTN, %s", governance))

            submitForm()
        }
    }

    private fun btnInfrastruture() {

        btn_infrastructure.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val infrastruture = "infrastruture"

            counter =
                if (btn_infrastructure.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_infrastructure.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area7")
                    counter.minus(1)
                } else {

                    btn_infrastructure.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area7", infrastruture)
                    counter.plus(1)


                }


            Timber.i(String.format("BTN, %s", infrastruture))

            submitForm()
        }
    }

    private fun btnStakeholder() {

        btn_stakeholder.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val stakeholder = "stakeholder"

            counter =
                if (btn_stakeholder.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_stakeholder.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area8")
                    counter.minus(1)
                } else {

                    btn_stakeholder.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area8", stakeholder)
                    counter.plus(1)


                }


            Timber.i(String.format("BTN, %s", stakeholder))

            submitForm()
        }
    }

    private fun btnQualityService() {

        btn_quality_service.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val qualityService = "quality_service"

            counter =
                if (btn_quality_service.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                    btn_quality_service.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                    sharedPreference.removeValue("area9")
                    counter.minus(1)
                } else {

                    btn_quality_service.setBackgroundResource(R.drawable.ic_area_selected)
                    sharedPreference.save("area9", qualityService)
                    counter.plus(1)


                }


            Timber.i(String.format("BTN, %s", qualityService))

            submitForm()
        }
    }

    private fun btnFab() {

        fab.setOnClickListener {

            scrollToFinal()
            /* Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                 .setAction("Action", null)
                 .show()*/
        }

    }

    private fun submitForm() {

        if (counter == 3) {

            fab.visibility = View.VISIBLE
        } else {

            fab.visibility = View.GONE
        }

    }

    //Screen Size
    fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

    fun Int.pxToDp(displayMetrics: DisplayMetrics): Int = (this / displayMetrics.density).toInt()

}


