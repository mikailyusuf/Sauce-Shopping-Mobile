package com.mikail.sauceshopping.di

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SauceApplication:Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: SauceApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        val context: Context = SauceApplication.applicationContext()
    }
}