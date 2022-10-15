package com.example.hammersystemstesttask

import android.app.Application
import android.content.Context
import com.example.hammersystemstesttask.di.AppComponent
import com.example.hammersystemstesttask.di.DaggerAppComponent

class MyApp: Application() {

    lateinit var appComponent: AppComponent

    init {
        instance = this
    }

    companion object {
        private var instance: MyApp? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}