package com.san4illa.itunesalbums.data.network

import com.san4illa.itunesalbums.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search")
    suspend fun getAlbums(
        @Query("term") term: String,
        @Query("entity") entity: String = "album"
    ): Response

    @GET("lookup")
    suspend fun getAlbum(
        @Query("id") albumId: String,
        @Query("entity") entity: String = "song"
    ): Response
}