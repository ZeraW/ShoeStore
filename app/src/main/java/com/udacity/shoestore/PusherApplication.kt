package com.udacity.shoestore

import android.app.Application
import timber.log.Timber

class PusherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        PrefsHelper.init(this)

    }
}