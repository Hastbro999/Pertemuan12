package com.example.android.pertemuan12

import android.app.Application
import timber.log.Timber

class DevByteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
