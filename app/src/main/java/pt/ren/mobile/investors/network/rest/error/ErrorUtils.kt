package pt.ren.mobile.investors.network.rest.error


import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import pt.ren.mobile.investors.InvestorsApp
import pt.ren.mobile.investors.R
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


object ErrorUtils : Serializable {
    fun parseError(response: Response<*>): RENServiceErrorModel? {
        val tokenExpired = "expired_token"
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(15, TimeUnit.SECONDS)
        val client = builder.build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(InvestorsApp.getInstance().getString(R.string.baseurl))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val converter: Converter<ResponseBody?, RENServiceErrorModel> =
            retrofit.responseBodyConverter<RENServiceErrorModel>(
                RENServiceErrorModel::class.java, arrayOfNulls(0)
            )
        val error: RENServiceErrorModel
        error = try {
            converter.convert(response.errorBody())
        } catch (e: IOException) {
            return RENServiceErrorModel()
        }
        return if (error.getMessage().equalsIgnoreCase(tokenExpired)) {
            RENServiceErrorModel("", "", "")
        } else {
            error
        }
    }
}