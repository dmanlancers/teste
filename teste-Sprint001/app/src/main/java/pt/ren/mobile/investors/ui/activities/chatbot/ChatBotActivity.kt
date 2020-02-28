package pt.ren.mobile.investors.ui.activities.chatbot


import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.UnderlineSpan
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_chatbot.*
import kotlinx.android.synthetic.main.ctb_block01.*
import kotlinx.android.synthetic.main.ctb_block02.*
import kotlinx.android.synthetic.main.ctb_block03.*
import kotlinx.android.synthetic.main.ctb_block05.*
import kotlinx.android.synthetic.main.ctb_block08.*
import pt.ren.mobile.investors.R
import pt.ren.mobile.investors.ui.activities.main.MainActivity
import pt.ren.mobile.investors.ui.activities.profile.ProfileActivity
import pt.ren.mobile.investors.ui.activities.splash_screen.SplashScreenActivity
import pt.ren.mobile.investors.utils.shared_preferences.SharedPreference
import timber.log.Timber


class ChatBotActivity : AppCompatActivity() {

    private var counter = 0


    private val buttonList = ArrayList<ImageButton>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width: Int = size.x
        val heightPx: Int = size.y
        val screenSize = heightPx.pxToDp(this.resources.displayMetrics)

        fab.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_right_arrow
            )
        )

        //Visibility of views
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


        //Add buttons to list for horizontal ScrollView
        buttonList.add(btn_social)
        buttonList.add(btn_environment)
        buttonList.add(btn_renewable)
        buttonList.add(btn_market_information)
        buttonList.add(btn_financial_information)
        buttonList.add(btn_governance)
        buttonList.add(btn_infrastructure)
        buttonList.add(btn_stakeholder)
        buttonList.add(btn_quality_service)

        Timber.i(String.format("SIZE, %s", buttonList.size))


        //Button Listeners
        btnSubmitName()
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


    }

    //Animation items
    private fun animationBlock03() {

        Handler().postDelayed({
            btn_proficient.visibility = View.VISIBLE


            btn_proficient.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.slide_in_left
                )
            )
        }, 400.toLong())


        Handler().postDelayed({
            btn_intermediate.visibility = View.VISIBLE

            btn_intermediate.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.slide_in_left
                )
            )
        }, 600.toLong())


        Handler().postDelayed({

            btn_elementary.visibility = View.VISIBLE
            btn_elementary.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.slide_in_left
                )
            );
        }, 800.toLong())

    }

    private fun animationBlock05() {
        Handler().postDelayed({

            btn_considerably.visibility = View.VISIBLE
            btn_considerably.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.slide_in_left
                )
            );
        }, 400.toLong())

        Handler().postDelayed({

            btn_moderately.visibility = View.VISIBLE
            btn_moderately.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.slide_in_left
                )
            );
        }, 600.toLong())

        Handler().postDelayed({

            btn_few.visibility = View.VISIBLE
            btn_few.startAnimation(
                AnimationUtils.loadAnimation(
                    this, R.anim.slide_in_left
                )
            );
        }, 800.toLong())
    }

    //Auto Scroll
    private fun scrollToBlock3() {

        val sharedPreference = SharedPreference(this)
        val name = etxt_block01.editableText.toString()
        val txtGreetingsStart = resources.getString(R.string.txt_greetings_beginning)
        val txtGreetingsEnd = resources.getString(R.string.txt_greetings_final)
        sharedPreference.save("name", name)

        val investorName = SpannableString(name )
        investorName.setSpan(UnderlineSpan(), 0, investorName.length, 0)



        val presentation = TextUtils.concat(txtGreetingsStart, investorName, txtGreetingsEnd)


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
            dividerBlock03.topMargin = 200



            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider03.bottom)
            animator.duration = 4000
            animator.start()



            animationBlock03()

        }, 2000.toLong())


    }

    private fun scrollToBlock5() {

        Handler().postDelayed({
            val dividerBlock04 = divider04?.layoutParams as MarginLayoutParams
            ctb_block04.visibility = View.VISIBLE
            //dividerBlock04.bottomMargin = 200
            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider04.bottom)
            animator.duration = 900
            animator.start()


        }, 500.toLong())

        Handler().postDelayed({
            val dividerBlock05 = divider05?.layoutParams as MarginLayoutParams
            ctb_block05.visibility = View.VISIBLE
            dividerBlock05.bottomMargin = 200
            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider05.bottom)
            animator.duration = 2000
            animator.start()

            animationBlock05()


        }, 2000.toLong())

        //
    }

    private fun scrollToBlock8() {

        Handler().postDelayed({
            val dividerBlock06 = divider06?.layoutParams as MarginLayoutParams
            ctb_block06.visibility = View.VISIBLE
            dividerBlock06.bottomMargin = 200
            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider06.bottom)
            animator.duration = 900
            animator.start()


        }, 1000.toLong())


        Handler().postDelayed({
            val dividerBlock07 = divide07?.layoutParams as MarginLayoutParams
            ctb_block07.visibility = View.VISIBLE
            // middleBlock07.bottomMargin = 200
            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divide07.bottom)
            animator.duration = 900
            animator.start()


        }, 2000.toLong())


        Handler().postDelayed({
            val dividerBlock08 = divider08?.layoutParams as MarginLayoutParams
            ctb_block08.visibility = View.VISIBLE
            dividerBlock08.bottomMargin = 300
            val animator =
                ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider08.bottom)
            animator.duration = 2000
            animator.start()

            Handler().postDelayed({

                scv_block08.visibility = View.VISIBLE
                scv_block08.startAnimation(
                    AnimationUtils.loadAnimation(
                        this, R.anim.slide_in_left
                    )
                );
            }, 400.toLong())


        }, 2000.toLong())

    }

    private fun scrollToFinal() {


        val dividerBlock09 = divider09?.layoutParams as MarginLayoutParams
        ctb_block09.visibility = View.VISIBLE
        dividerBlock09.bottomMargin = 200
        val animator =
            ObjectAnimator.ofInt(chatBotScrollView, "scrollY", divider09.bottom)
        animator.duration = 900
        animator.start()






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
    private fun btnSubmitName() {

        btn_submit_block01.setOnClickListener {

            if (etxt_block01.text.isNotEmpty()) {


                scrollToBlock3()

            } else {
                /*val view = this.currentFocus
                view?.let { v ->
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                    imm?.hideSoftInputFromWindow(v.windowToken, 0)
                }*/

                btn_submit_block01.visibility = View.GONE
                etxt_block01.error = "Please enter your name";

                Handler().postDelayed({
                    etxt_block01.error = null
                    btn_submit_block01.visibility = View.VISIBLE

                }, 2200.toLong())


            }
        }
    }

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

                scrollToBlock8()

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


            if (btn_social.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                btn_social.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area1")
                buttonList.add(btn_social)
                counter = counter.minus(1)

                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
                fab.visibility = View.GONE
            } else {

                btn_social.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area1", social)
                buttonList.remove(btn_social)
                counter = counter.plus(1)



                Timber.i(String.format("SIZE_SOCIAL, %s", buttonList.size))
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }

            Timber.i(String.format("BTN, %s", counter))




            Timber.i(String.format("BTN, %s", social))

        }


    }

    private fun btnEnvironment() {


        btn_environment.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val environment = "environment"


            if (btn_environment.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                btn_environment.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area2")
                buttonList.add(btn_environment)
                counter = counter.minus(1)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }

            } else {

                btn_environment.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area2", environment)
                buttonList.remove(btn_environment)
                counter = counter.plus(1)



                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }


            Timber.i(String.format("BTN, %s", counter))
            Timber.i(String.format("BTN, %s", environment))
        }

    }

    private fun btnRenewable() {

        btn_renewable.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val renewable = "renewable"


            if (btn_renewable.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                btn_renewable.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area3")
                buttonList.add(btn_renewable)
                counter = counter.minus(1)

                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }

            } else {

                btn_renewable.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area3", renewable)
                buttonList.remove(btn_renewable)
                counter = counter.plus(1)

                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }

                }


            }

            Timber.i(String.format("BTN, %s", counter))
            Timber.i(String.format("BTN, %s", renewable))


        }
    }


    private fun btnMarketInformation() {

        btn_market_information.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val market = "market"


            if (btn_market_information.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                btn_market_information.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area4")
                buttonList.add(btn_market_information)
                counter = counter.minus(1)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
            } else {

                btn_market_information.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area4", market)
                buttonList.remove(btn_market_information)
                counter = counter.plus(1)
                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }


            Timber.i(String.format("BTN, %s", market))

        }
    }

    private fun btnFinancialInformation() {

        btn_financial_information.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val financialInformation = "financial_information"


            if (btn_financial_information.background.constantState === resources.getDrawable(
                    R.drawable.ic_area_selected
                ).constantState
            ) {
                btn_financial_information.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area5")
                counter = counter.minus(1)
                buttonList.add(btn_financial_information)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
            } else {

                btn_financial_information.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area5", financialInformation)
                counter = counter.plus(1)
                buttonList.remove(btn_financial_information)

                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }


            Timber.i(String.format("BTN, %s", financialInformation))


        }
    }

    private fun btnGovernance() {


        btn_governance.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val governance = "governance"


            if (btn_governance.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                btn_governance.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area6")
                counter = counter.minus(1)
                buttonList.add(btn_governance)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
            } else {

                btn_governance.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area6", governance)
                counter = counter.plus(1)
                buttonList.remove(btn_governance)
                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }


            Timber.i(String.format("BTN, %s", governance))


        }
    }

    private fun btnInfrastruture() {

        btn_infrastructure.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val infrastruture = "infrastruture"


            if (btn_infrastructure.background.constantState === resources.getDrawable(
                    R.drawable.ic_area_selected
                ).constantState
            ) {
                btn_infrastructure.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area7")
                counter = counter.minus(1)
                buttonList.add(btn_governance)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
            } else {

                btn_infrastructure.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area7", infrastruture)
                counter = counter.plus(1)
                buttonList.remove(btn_governance)

                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }


            Timber.i(String.format("BTN, %s", infrastruture))


        }
    }

    private fun btnStakeholder() {

        btn_stakeholder.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val stakeholder = "stakeholder"


            if (btn_stakeholder.background.constantState === resources.getDrawable(R.drawable.ic_area_selected).constantState) {
                btn_stakeholder.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area8")
                counter = counter.minus(1)
                buttonList.add(btn_governance)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
            } else {

                btn_stakeholder.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area8", stakeholder)
                counter = counter.plus(1)
                buttonList.remove(btn_governance)

                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }


            }


            Timber.i(String.format("BTN, %s", stakeholder))


        }
    }

    private fun btnQualityService() {

        btn_quality_service.setOnClickListener {
            val sharedPreference = SharedPreference(this)
            val qualityService = "quality_service"


            if (btn_quality_service.background.constantState === resources.getDrawable(
                    R.drawable.ic_area_selected
                ).constantState
            ) {
                btn_quality_service.setBackgroundResource(R.drawable.ic_chatbot_multi_selection)
                sharedPreference.removeValue("area9")
                counter = counter.minus(1)
                buttonList.add(btn_quality_service)
                for (i in 0 until buttonList.size) {
                    val tempButton = buttonList[i]



                    if (counter < 3) {

                        fab.visibility = View.GONE
                        tempButton.isClickable = true
                    }


                }
            } else {

                btn_quality_service.setBackgroundResource(R.drawable.ic_area_selected)
                sharedPreference.save("area9", qualityService)
                counter = counter.plus(1)
                buttonList.remove(btn_quality_service)

                for (i in 0 until buttonList.size) {

                    val tempButton = buttonList[i]

                    if (counter == 3) {

                        fab.visibility = View.VISIBLE
                        tempButton.isClickable = false
                    }


                }

            }


            Timber.i(String.format("BTN, %s", qualityService))

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


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) { // your code here

            val mainIntent = Intent(this@ChatBotActivity, SplashScreenActivity::class.java)
            startActivity(mainIntent)

            false
        } else super.onKeyDown(keyCode, event)
    }

    //Screen Size converter
    fun Int.dpToPx(displayMetrics: DisplayMetrics): Int =
        (this * displayMetrics.density).toInt()

    fun Int.pxToDp(displayMetrics: DisplayMetrics): Int =
        (this / displayMetrics.density).toInt()

}


