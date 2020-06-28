package com.san4illa.itunesalbums.data.model

data class Result(
    val wrapperType: String,
    val collectionId: String,
    val collectionName: String,
    val artistName: String,
    val artworkUrl100: String,
    val releaseDate: String,
    val trackName: String,
    val trackCount: String,
    val trackNumber: String,
    val trackTimeMillis: String,
    val primaryGenreName: String
)