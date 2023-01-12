package com.example.unsplash

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFERENCE_KEY = "SHP_KEY"
        const val USER_OPENED_KEY = "SHP_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharePreferences = getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
        val userOpened = sharePreferences.getBoolean(USER_OPENED_KEY, false)

        if (!userOpened) {
            Toast.makeText(this, "Welcome to Unsplash", Toast.LENGTH_SHORT).show()
            sharePreferences.edit().putBoolean(USER_OPENED_KEY, true).apply()

        }
    } }
