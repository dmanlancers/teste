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


public class RENServicesInterface {

    private var restService: RENServices? = null
    private val REN_AUTH = "anonymous"
    private val REN_ACTION = "Criar"
    private val REN_FIELDS = "*"
    private val REN_FIRST_ITEM = "0"
    private val REN_MAX_ITEMS = "20"
    private val REN_MAX_ARTICLES = "50"
    private val REN_MAX_ITEMS_CHART = "1"
    private val REN_DETAIL = "1"
    private val REN_NO_DETAIL = "0"
    private val REN_DATA_CONSENT = "1"

    private val SORT_OP_EVENTS = "StartDate,asc"
    private val COND_EVENTS = "StartDate,greaterOrEqual,"
    private val COND_OPPORTUNITIES = "pt_pt__Title,equals,Tabela Oportunidades"
    private val SORT_RNT = "detail_identifier,asc"
    private val SORT_INVESTMENT = "order,asc"
    private val COND_ARTICLE = "pt_pt__title,equals,"

    interface RENServicesInterface {
        @GET("contentlistConditional")
        fun getCards(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?, @Query("pt_en_title") card_title: String, @Query("pt_en_detail") card_detail: String
        ): Call<OnBoardingCardsModel?>?


    }


    private fun getRest(): RENServices? {
        if (restService == null) {
            val url: String = "https://backofficesites-qua.ren.pt/REST/"
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val builder = OkHttpClient.Builder()
            builder.connectTimeout(15, TimeUnit.SECONDS)
            builder.addInterceptor(interceptor)
            builder.readTimeout(20, TimeUnit.SECONDS)
            val client = builder.build()
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
           restService = retrofit.create(RENServices::class.java)
        }
        return restService
    }

    interface RENServiceCallback<T> {
        fun onSuccess(loaderWrapper: T)
        fun onError(errorModel: RENServiceErrorModel?)
    }

    interface GetCardsCallback :
        RENServiceCallback<OnBoardingCardsModel?>
    /*  private fun buildGsonConverter(): GsonConverterFactory? {
          val gsonBuilder = GsonBuilder()
          // Adding custom deserializers
          gsonBuilder.registerTypeAdapter(
              OnBoardingCardsModel::class.java,

          )

          val myGson = gsonBuilder.create()
          return GsonConverterFactory.create(myGson)
      }*/
}