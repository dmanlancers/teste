package pt.ren.mobile.investors.model.cards

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OnBoardingCardsModel(

    @Expose
    @SerializedName("pt_en_title")
    val title: String,
    @Expose
    @SerializedName("pt_en_detail")
    val detail: String

)
