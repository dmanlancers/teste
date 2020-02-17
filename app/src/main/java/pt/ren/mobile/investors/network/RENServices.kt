package pt.ren.mobile.investors.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RENServices {

    var restService: RENServicesInterface? = null
    const val REN_AUTH = "anonymous"
    const val REN_FIELDS = "*"
    const val REN_FIRST_ITEM = "0"
    const val REN_MAX_ARTICLES = "50"
    const val REN_NO_DETAIL = "0"

    /* var BASE_URL:String="https://backofficesites-qua.ren.pt/REST/"
    val getCards: RENServicesInterface
        get() {


            val gson = GsonBuilder()
                .setLenient()
                .create()
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(RENServicesInterface::class.java)

        }*/


     fun getRest(): RENServicesInterface? {
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
            restService = retrofit.create(RENServicesInterface::class.java)
        }
        return restService
    }

}