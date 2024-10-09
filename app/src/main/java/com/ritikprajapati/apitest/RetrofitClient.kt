package com.ritikprajapati.apitest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:3000/"  // Replace with your server's IP address or domain

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  // This converts JSON data into Kotlin objects
            .build()
    }

    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }
}