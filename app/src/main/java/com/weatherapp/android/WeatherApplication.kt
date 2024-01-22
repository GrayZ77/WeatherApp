package com.weatherapp.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class WeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        const val TOKEN = "XqEImrfVBMApa9V5"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}