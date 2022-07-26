package com.hackyeon.first_hilt.api.network

import com.hackyeon.first_hilt.api.data.res.ResData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface NaverDataService {
    //todo api fun
    @POST("v1/datalab/search")
    fun getData(): ResData

    companion object {
        private const val BASE_URL = "https://openapi.naver.com/"

        fun create(): NaverDataService {
            val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("X-Naver-Client-Id", "")
                        .addHeader("X-Naver-Client-Secret", "")
                        .build()
                    chain.proceed(request)
                }
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(NaverDataService::class.java)
        }



    }
}