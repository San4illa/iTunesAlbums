package com.san4illa.itunesalbums

import android.app.Application
import com.san4illa.itunesalbums.di.AppModule
import com.san4illa.itunesalbums.di.DI
import toothpick.Toothpick
import toothpick.configuration.Configuration

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initToothpick()
        initAppScope()
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction())
        }
    }

    private fun initAppScope() {
        Toothpick.openScope(DI.APP_SCOPE)
            .installModules(AppModule())
    }
}