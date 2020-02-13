package pt.ren.mobile.investors.network.rest

import android.R
import com.google.gson.GsonBuilder
import com.sun.corba.se.impl.activation.CommandHandler.parseError
import okhttp3.OkHttpClient
import org.junit.experimental.results.ResultMatchers.isSuccessful
import pt.ren.mobile.investors.utils.constants.RENConstants
import retrofit2.Retrofit
import retrofit2.http.GET
import sun.util.logging.LoggingSupport.setLevel


class RENServices {

    private var restService: RestService? = null
    private val REN_AUTH: String? = "anonymous"
    private val REN_ACTION: String? = "Criar"
    private val REN_FIELDS: String? = "*"
    private val REN_FIRST_ITEM: String? = "0"
    private val REN_MAX_ITEMS: String? = "20"
    private val REN_MAX_ARTICLES: String? = "50"
    private val REN_MAX_ITEMS_CHART: String? = "1"
    private val REN_DETAIL: String? = "1"
    private val REN_NO_DETAIL: String? = "0"
    private val REN_DATA_CONSENT: String? = "1"

    private val SORT_OP_EVENTS: String? = "StartDate,asc"
    private val COND_EVENTS: String? = "StartDate,greaterOrEqual,"
    private val COND_OPPORTUNITIES: String? = "pt_pt__Title,equals,Tabela Oportunidades"
    private val SORT_RNT: String? = "detail_identifier,asc"
    private val SORT_INVESTMENT: String? = "order,asc"
    private val COND_ARTICLE: String? = "pt_pt__title,equals,"

    private interface RestService {
        @GET("contentlistConditional")
        fun getREIndicadoresAnuais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<REIndicadoresAnuaisList?>?

        @GET("contentListConditional")
        fun getREIndicadoresTrimestrais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<REIndicadoresTrimestraisList?>?

        @GET("contentListConditional")
        fun getAIDIndicadoresAnuais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<AIDIndicadoresAnuaisList?>?

        @GET("contentListConditional")
        fun getAIDIndicadoresTrimestrais(
            @Query("authentication") auth: String?, @Query(
                "channelPath"
            ) path: String?, @Query("first") first: String?, @Query("max") max: String?, @Query(
                "detail"
            ) detail: String?, @Query("fieldlist") fieldlist: String?
        ): Call<AIDIndicadoresTrimestraisList?>?

        @GET("contentListConditional")
        fun getAcaoIndicadoresAnuais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<AcaoIndicadoresAnuaisList?>?

        @GET("contentListConditional")
        fun getAcaoIndicadoresTrimestrais(
            @Query("authentication") auth: String?, @Query(
                "channelPath"
            ) path: String?, @Query("first") first: String?, @Query("max") max: String?, @Query(
                "detail"
            ) detail: String?, @Query("fieldlist") fieldlist: String?
        ): Call<AcaoIndicadoresTrimestraisList?>?

        @GET("contentListConditional")
        fun getOIIndicadoresAnuais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<OIIndicadoresAnuaisList?>?

        @GET("contentListConditional")
        fun getOIIndicadoresTrimestrais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<OIIndicadoresTrimestraisList?>?

        @GET("contentListConditional")
        fun getDivIndicadoresAnuais(
            @Query("authentication") auth: String?, @Query("channelPath") path: String?, @Query(
                "first"
            ) first: String?, @Query("max") max: String?, @Query("detail") detail: String?, @Query(
                "fieldlist"
            ) fieldlist: String?
        ): Call<DividendosList?>? //@GET("contentlistConditional")
    }

    private fun getRest(): RestService? {
        if (restService == null) {
            val url: String = InvestorsApp.getInstance().getString(R.string.baseurl)
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val builder = OkHttpClient.Builder()
            builder.connectTimeout(15, TimeUnit.SECONDS)
            builder.addInterceptor(interceptor)
            builder.readTimeout(20, TimeUnit.SECONDS)
            val client = builder.build()
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(buildGsonConverter())
                .build()
            restService = retrofit.create(RestService::class.java)
        }
        return restService
    }

    fun GetIndicadoresAnuais(getIndicadoresAnuaisCallback: GetREIndicadoresAnuaisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<REIndicadoresAnuaisList?>? = service.getREIndicadoresAnuais(
                REN_AUTH,
                RENConstants.CHANNEL_EXPLORACAO_INDICADORES_ANUAIS,
                REN_FIRST_ITEM,
                REN_MAX_ARTICLES,
                REN_NO_DETAIL,
                REN_FIELDS
            )
            currentCall.enqueue(object : Callback<REIndicadoresAnuaisList?>() {
                fun onResponse(
                    call: Call<REIndicadoresAnuaisList?>?,
                    response: Response<REIndicadoresAnuaisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getIndicadoresAnuaisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getIndicadoresAnuaisCallback!!.onError(error)
                    }
                }

                fun onFailure(
                    call: Call<REIndicadoresAnuaisList?>?,
                    t: Throwable?
                ) {
                    getIndicadoresAnuaisCallback?.onError(
                        RENServiceErrorModel()
                    )
                }
            })
        }
    }

    fun GetResultadosExploracaoIndicadoresTrimestrais(getIndicadoresTrimCallback: GetREIndicadoresTrimestraisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<REIndicadoresTrimestraisList?>? =
                service.getREIndicadoresTrimestrais(
                    REN_AUTH,
                    RENConstants.CHANNEL_EXPLORACAO_INDICADORES_TRIMESTRAIS,
                    REN_FIRST_ITEM,
                    REN_MAX_ARTICLES,
                    REN_NO_DETAIL,
                    REN_FIELDS
                )
            currentCall.enqueue(object : Callback<REIndicadoresTrimestraisList?>() {
                fun onResponse(
                    call: Call<REIndicadoresTrimestraisList?>?,
                    response: Response<REIndicadoresTrimestraisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getIndicadoresTrimCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getIndicadoresTrimCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<REIndicadoresTrimestraisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    fun GetAIDIndicadoresAnuais(getAIDIndicadoresAnuaisCallback: GetAIDIndicadoresAnuaisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<AIDIndicadoresAnuaisList?>? = service.getAIDIndicadoresAnuais(
                REN_AUTH,
                RENConstants.CHANNEL_AID_INDICADORES_ANUAIS,
                REN_FIRST_ITEM,
                REN_MAX_ARTICLES,
                REN_NO_DETAIL,
                REN_FIELDS
            )
            currentCall.enqueue(object : Callback<AIDIndicadoresAnuaisList?>() {
                fun onResponse(
                    call: Call<AIDIndicadoresAnuaisList?>?,
                    response: Response<AIDIndicadoresAnuaisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getAIDIndicadoresAnuaisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getAIDIndicadoresAnuaisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<AIDIndicadoresAnuaisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }


    fun GetAIDIndicadoresTrimestrais(getAIDIndicadoresTrimestraisCallback: GetAIDIndicadoresTrimestraisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<AIDIndicadoresTrimestraisList?>? =
                service.getAIDIndicadoresTrimestrais(
                    REN_AUTH,
                    RENConstants.CHANNEL_AID_INDICADORES_TRIMESTRAIS,
                    REN_FIRST_ITEM,
                    REN_MAX_ARTICLES,
                    REN_NO_DETAIL,
                    REN_FIELDS
                )
            currentCall.enqueue(object : Callback<AIDIndicadoresTrimestraisList?>() {
                fun onResponse(
                    call: Call<AIDIndicadoresTrimestraisList?>?,
                    response: Response<AIDIndicadoresTrimestraisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getAIDIndicadoresTrimestraisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getAIDIndicadoresTrimestraisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<AIDIndicadoresTrimestraisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    fun GetAcaoIndicadoresAnuais(getAcaoIndicadoresAnuaisCallback: GetAcaoIndicadoresAnuaisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<AcaoIndicadoresAnuaisList?>? = service.getAcaoIndicadoresAnuais(
                REN_AUTH,
                RENConstants.CHANNEL_ACAO_INDICADORES_ANUAIS,
                REN_FIRST_ITEM,
                REN_MAX_ARTICLES,
                REN_NO_DETAIL,
                REN_FIELDS
            )
            currentCall.enqueue(object : Callback<AcaoIndicadoresAnuaisList?>() {
                fun onResponse(
                    call: Call<AcaoIndicadoresAnuaisList?>?,
                    response: Response<AcaoIndicadoresAnuaisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getAcaoIndicadoresAnuaisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getAcaoIndicadoresAnuaisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<AcaoIndicadoresAnuaisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    fun GetAcaoIndicadoresTrimestrais(getAcaoIndicadoresTrimestraisCallback: GetAcaoIndicadoresTrimestraisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<AcaoIndicadoresTrimestraisList?>? =
                service.getAcaoIndicadoresTrimestrais(
                    REN_AUTH,
                    RENConstants.CHANNEL_ACAO_INDICADORES_TRIMESTRAIS,
                    REN_FIRST_ITEM,
                    REN_MAX_ARTICLES,
                    REN_NO_DETAIL,
                    REN_FIELDS
                )
            currentCall.enqueue(object : Callback<AcaoIndicadoresTrimestraisList?>() {
                fun onResponse(
                    call: Call<AcaoIndicadoresTrimestraisList?>?,
                    response: Response<AcaoIndicadoresTrimestraisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getAcaoIndicadoresTrimestraisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getAcaoIndicadoresTrimestraisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<AcaoIndicadoresTrimestraisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    fun GetOIIndicadoresAnuais(getOIIndicadoresAnuaisCallback: GetOIIndicadoresAnuaisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<OIIndicadoresAnuaisList?>? = service.getOIIndicadoresAnuais(
                REN_AUTH,
                RENConstants.CHANNEL_OI_INDICADORES_ANUAIS,
                REN_FIRST_ITEM,
                REN_MAX_ARTICLES,
                REN_NO_DETAIL,
                REN_FIELDS
            )
            currentCall.enqueue(object : Callback<OIIndicadoresAnuaisList?>() {
                fun onResponse(
                    call: Call<OIIndicadoresAnuaisList?>?,
                    response: Response<OIIndicadoresAnuaisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getOIIndicadoresAnuaisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getOIIndicadoresAnuaisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<OIIndicadoresAnuaisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    fun GetOIIndicadoresTrimestrais(getOIIndicadoresTrimestraisCallback: GetOIIndicadoresTrimestraisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<OIIndicadoresTrimestraisList?>? =
                service.getOIIndicadoresTrimestrais(
                    REN_AUTH,
                    RENConstants.CHANNEL_OI_INDICADORES_TRIMESTRAIS,
                    REN_FIRST_ITEM,
                    REN_MAX_ARTICLES,
                    REN_NO_DETAIL,
                    REN_FIELDS
                )
            currentCall.enqueue(object : Callback<OIIndicadoresTrimestraisList?>() {
                fun onResponse(
                    call: Call<OIIndicadoresTrimestraisList?>?,
                    response: Response<OIIndicadoresTrimestraisList?>?
                ) {
                    if (response.isSuccessful()) {
                        getOIIndicadoresTrimestraisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getOIIndicadoresTrimestraisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<OIIndicadoresTrimestraisList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    fun GetDivIndicadoresAnuais(getDivIndicadoresAnuaisCallback: GetDivIndicadoresAnuaisCallback?) {
        val service = getRest()
        if (service != null) {
            val currentCall: Call<DividendosList?>? = service.getDivIndicadoresAnuais(
                REN_AUTH,
                RENConstants.CHANNEL_DIVIDENDOS_INDICADORES_ANUAIS,
                REN_FIRST_ITEM,
                REN_MAX_ARTICLES,
                REN_DETAIL,
                REN_FIELDS
            )
            currentCall.enqueue(object : Callback<DividendosList?>() {
                fun onResponse(
                    call: Call<DividendosList?>?,
                    response: Response<DividendosList?>?
                ) {
                    if (response.isSuccessful()) {
                        getDivIndicadoresAnuaisCallback!!.onSuccess(response.body())
                    } else {
                        val error: RENServiceErrorModel = ErrorUtils.parseError(response)
                        getDivIndicadoresAnuaisCallback!!.onError(RENServiceErrorModel())
                    }
                }

                fun onFailure(
                    call: Call<DividendosList?>?,
                    t: Throwable?
                ) {
                }
            })
        }
    }

    private fun buildGsonConverter(): GsonConverterFactory? {
        val gsonBuilder = GsonBuilder()
        // Adding custom deserializers
        gsonBuilder.registerTypeAdapter(
            REIndicadoresAnuaisList::class.java,
            REIndicadoresAnuaisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            REIndicadoresTrimestraisList::class.java,
            REIndicadoresTrimestraisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            AIDIndicadoresAnuaisList::class.java,
            AIDIndicadoresAnuaisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            AIDIndicadoresTrimestraisList::class.java,
            AIDIndicadoresTrimestraisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            AcaoIndicadoresAnuaisList::class.java,
            AcaoIndicadoresAnuaisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            AcaoIndicadoresTrimestraisList::class.java,
            AcaoIndicadoresTrimestraisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            OIIndicadoresAnuaisList::class.java,
            OIIndicadoresAnuaisDeserializer()
        )
        gsonBuilder.registerTypeAdapter(
            OIIndicadoresTrimestraisList::class.java,
            OIIndicadoresTrimestraisDeserializer()
        )
        val myGson = gsonBuilder.create()
        return GsonConverterFactory.create(myGson)
    }

    interface RENServiceCallback<T> {
        fun onSuccess(loaderWrapper: T?)
        fun onError(errorModel: RENServiceErrorModel?)
    }

    interface GetREIndicadoresAnuaisCallback : RENServiceCallback<REIndicadoresAnuaisList?>


    interface GetREIndicadoresTrimestraisCallback :
        RENServiceCallback<REIndicadoresTrimestraisList?>

    interface GetAIDIndicadoresAnuaisCallback :
        RENServiceCallback<AIDIndicadoresAnuaisList?>

    interface GetAIDIndicadoresTrimestraisCallback :
        RENServiceCallback<AIDIndicadoresTrimestraisList?>

    interface GetAcaoIndicadoresAnuaisCallback :
        RENServiceCallback<AcaoIndicadoresAnuaisList?>

    interface GetAcaoIndicadoresTrimestraisCallback :
        RENServiceCallback<AcaoIndicadoresTrimestraisList?>

    interface GetOIIndicadoresAnuaisCallback : RENServiceCallback<OIIndicadoresAnuaisList?>

    interface GetOIIndicadoresTrimestraisCallback :
        RENServiceCallback<OIIndicadoresTrimestraisList?>

    interface GetDivIndicadoresAnuaisCallback : RENServiceCallback<DividendosList?>
}