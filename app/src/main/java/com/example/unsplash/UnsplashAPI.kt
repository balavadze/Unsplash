package com.example.unsplash

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashAPI {

    @Headers("Authorization: Client-ID GRBjPqVLr84VeyckRPvhPgKMHytRQlHLfdI9-NT47Y4")
    @GET("photos/random")
    fun getRandomImage(): Call<Photo>
}