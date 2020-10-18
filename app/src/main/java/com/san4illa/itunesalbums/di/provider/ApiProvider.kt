package com.san4illa.itunesalbums.di.provider

import com.san4illa.itunesalbums.data.network.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class ApiProvider @Inject constructor() : Provider<Api> {
    companion object {
        private const val BASE_URL = "https://itunes.apple.com/"
    }

    override fun get(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }
}