package com.example.unsplash

import android.accounts.AuthenticatorDescription


data class Photo(
    val urls: Urls,
    val description: String,
) {
}

data class Urls(
    val regular: String,

)
