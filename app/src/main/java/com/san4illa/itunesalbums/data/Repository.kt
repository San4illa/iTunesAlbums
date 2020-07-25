package com.san4illa.itunesalbums.data

import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.data.network.Api
import com.san4illa.itunesalbums.util.applyAsync
import com.san4illa.itunesalbums.util.toAlbum
import com.san4illa.itunesalbums.util.toAlbumsList
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {
    fun getAlbums(query: String): Single<List<Album>> =
        api.getAlbums(query)
            .map { it.toAlbumsList() }
            .applyAsync()

    fun getAlbum(albumId: String): Single<Album> =
        api.getAlbum(albumId)
            .map { it.toAlbum() }
            .applyAsync()
}