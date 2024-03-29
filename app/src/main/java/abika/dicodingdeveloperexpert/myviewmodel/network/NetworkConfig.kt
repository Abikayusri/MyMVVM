package abika.dicodingdeveloperexpert.myviewmodel.network

import abika.dicodingdeveloperexpert.myviewmodel.Constans
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkConfig {
    fun getInterceptor(): OkHttpClient {
        // ketika ada request dari a ke b. dapat menerima lognya
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okhttp = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) //koneksi ketika timeout
            .writeTimeout(30, TimeUnit.SECONDS) //koneksi dari device ke server
            .retryOnConnectionFailure(true) //apa yang dilakukan setelah timeout
            .build()
        return okhttp
    }

    fun getNetwork(): Retrofit {
        return Retrofit.Builder().baseUrl(Constans.BASE_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api(): ApiService {
        return getNetwork().create(ApiService::class.java)
    }
}