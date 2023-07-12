package com.arthurabreu.olympicathletes.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

object RetrofitInstance {
    private const val BASE_URL = "https://ocs-test-backend.onrender.com/"

    private val retrofit: Retrofit by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .callTimeout(Duration.ofMinutes(2))
            .readTimeout(Duration.ofMinutes(2))
            .connectTimeout(Duration.ofMinutes(2))
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val olympicServices: OlympicServices by lazy {
        retrofit.create(OlympicServices::class.java)
    }
}