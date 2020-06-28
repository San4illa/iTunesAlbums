package com.san4illa.itunesalbums.di

import com.san4illa.itunesalbums.data.Repository
import com.san4illa.itunesalbums.data.network.Api
import com.san4illa.itunesalbums.di.provider.ApiProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class AppModule : Module() {
    init {
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)

        bind(Repository::class.java).singleton()

        bind(Api::class.java).toProvider(ApiProvider::class.java).providesSingleton()
    }
}