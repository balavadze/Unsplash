package com.example.unsplash

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private const val BASE_URL = "https://api.unsplash.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitApi: UnsplashAPI = retrofit.create(UnsplashAPI::class.java)

}