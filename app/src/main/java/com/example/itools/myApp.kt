package com.example.itools

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class myApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@myApp)
            modules(listOf(appModule, viewModelModule))
        }
    }

}