package com.san4illa.itunesalbums.data

data class Album(
    val id: String,
    val albumName: String,
    val artistName: String,
    val imageUrl: String,
    val trackCount: String,
    val releaseDate: String,
    val tracks: List<Track>? = null
)