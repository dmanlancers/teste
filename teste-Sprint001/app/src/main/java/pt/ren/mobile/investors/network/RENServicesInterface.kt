package pt.ren.mobile.investors.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pt.ren.mobile.investors.model.cards.OnBoardingCardsModel
import pt.ren.mobile.investors.model.error.RENServiceErrorModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


 class RENServicesInterface {



    interface getServicesInterface {
        @GET("contentlistConditional")
        fun getCards(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?, @Query("pt_en_title") card_title: String, @Query("pt_en_detail") card_detail: String
        ): Call<OnBoardingCardsModel?>?


    }


    interface RENServiceCallback<T> {
        fun onSuccess(loaderWrapper: T)
        fun onError(errorModel: RENServiceErrorModel?)
    }

    interface GetCardsCallback :
        RENServiceCallback<OnBoardingCardsModel?>

}