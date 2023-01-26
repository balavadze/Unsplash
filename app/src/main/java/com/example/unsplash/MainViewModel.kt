package com.example.unsplash

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class MainViewModel : ViewModel (){
    val viewModelData = MutableLiveData<MutableList<Photo>>(mutableListOf())
    val progessBar = MutableLiveData<Boolean>(false)
    fun loadUnsplash() {
        API.retrofitApi.getRandomImage()
            .enqueue(object : Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    val photo = response.body()
                    if (photo != null) {
                        viewModelData.value?.add(photo)
                        viewModelData.value = viewModelData.value
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {
                }
            })
    }
}