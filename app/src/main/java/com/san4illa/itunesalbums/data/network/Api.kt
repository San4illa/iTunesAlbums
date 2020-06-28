package com.san4illa.itunesalbums.data.network

import com.san4illa.itunesalbums.data.model.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search")
    fun getAlbums(
        @Query("term") term: String,
        @Query("entity") entity: String = "album"
    ): Single<Response>

    @GET("lookup")
    fun getAlbum(
        @Query("id") albumId: String,
        @Query("entity") entity: String = "song"
    ): Single<Response>
}