package com.san4illa.itunesalbums.data

import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.data.network.Api
import com.san4illa.itunesalbums.util.toAlbum
import com.san4illa.itunesalbums.util.toAlbumsList
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {
    suspend fun getAlbumsCoroutines(query: String): List<Album> {
        val albumsResponse = api.getAlbums(query)
        return albumsResponse.toAlbumsList()
    }

    suspend fun getAlbum(albumId: String): Album {
        val albumResponse = api.getAlbum(albumId)
        return albumResponse.toAlbum()
    }
}