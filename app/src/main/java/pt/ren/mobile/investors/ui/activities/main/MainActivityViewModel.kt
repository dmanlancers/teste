package pt.ren.mobile.investors.ui.activities.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pt.ren.mobile.investors.model.cards.OnBoardingCardsModel
import pt.ren.mobile.investors.model.error.ErrorUtils
import pt.ren.mobile.investors.model.error.RENServiceErrorModel
import pt.ren.mobile.investors.network.RENServices

import pt.ren.mobile.investors.network.RENServicesInterface
import pt.ren.mobile.investors.utils.constants.RENConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel() {
    var renConstants: RENConstants? = null
    val service: RENServicesInterface.getServicesInterface? = null
    val title = MutableLiveData<String>()
    val detail = MutableLiveData<String>()


    init {

        title.value = " "
        detail.value = " "

//GetAllCards()

    }



  /*  fun GetAllCards(getCardsCallback: RENServicesInterface.GetCardsCallback) {

        if (service != null) {
            val currentCall: Call<OnBoardingCardsModel?>? =
                service.getCards(
                    RENServices.REN_AUTH,
                    renConstants?.CHANNEL_UI_CARDS,
                    RENServices.REN_FIRST_ITEM,
                    RENServices.REN_MAX_ARTICLES,
                    RENServices.REN_NO_DETAIL,
                    RENServices.REN_FIELDS


                )
            currentCall?.enqueue(object : Callback<OnBoardingCardsModel?> {
                override fun onResponse(
                    call: Call<OnBoardingCardsModel?>,
                    response: Response<OnBoardingCardsModel?>
                ) {
                    if (response.isSuccessful()) {
                        getCardsCallback.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = (ErrorUtils.parseError(response)!!)
                        getCardsCallback.onError(RENServiceErrorModel())
                    }
                }

                override fun onFailure(
                    call: Call<OnBoardingCardsModel?>,
                    t: Throwable
                ) {
                }
            })
        }
    }
*/

    override fun onCleared() {
        super.onCleared()
    }
}