package com.api.demo.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {


    val baseUrl = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit {
        var client = OkHttpClient().newBuilder()
        client.connectTimeout(5, TimeUnit.SECONDS)
        var builder = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
        return builder
    }
}