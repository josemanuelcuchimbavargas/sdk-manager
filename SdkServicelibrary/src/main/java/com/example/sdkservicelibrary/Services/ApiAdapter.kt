package com.example.sdkservicelibrary.Services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiAdapter {

    private var API_SERVICE: ApiService? = null

    fun getApiService(): ApiService? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        val baseUrl = "https://jsonplaceholder.typicode.com/"
        if (API_SERVICE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()) // <-- usamos el log level
                .build()
            API_SERVICE = retrofit.create<ApiService>(ApiService::class.java)
        }
        return API_SERVICE
    }
}