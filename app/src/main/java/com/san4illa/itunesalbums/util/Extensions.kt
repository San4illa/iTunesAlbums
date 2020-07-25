package com.san4illa.itunesalbums.util

import android.view.View
import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.data.model.Response
import com.san4illa.itunesalbums.data.model.Result
import com.san4illa.itunesalbums.data.model.Track
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

fun Any.objectScopeName() = "${javaClass.simpleName}_${hashCode()}"

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

operator fun CompositeDisposable.plusAssign(subscribe: Disposable) {
    add(subscribe)
}

fun <T> Single<T>.applyAsync() =
    compose { upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }

fun Response.toAlbumsList(): List<Album> = results.map { it.toAlbum() }

fun Result.toAlbum() =
    Album(collectionId, collectionName, artistName, formatImageUrl(artworkUrl100), trackCount, formatDate(releaseDate))

private fun formatImageUrl(string: String) = string.replace("100x100bb", "313x0w")

private fun formatDate(string: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val date = sdf.parse(string)
    sdf.applyPattern("dd.MM.yyyy")
    return sdf.format(date)
}

fun Response.toAlbum(): Album {
    val tracks = results.drop(1).map { it.toTrack() }
    val album = results[0].toAlbum()
    return album.copy(tracks = tracks)
}

private fun Result.toTrack() = Track(trackNumber, trackName, formatTrackLength(trackTimeMillis))

private fun formatTrackLength(trackTimeMillis: String): String {
    val milliseconds = trackTimeMillis.toInt()
    val minutes = milliseconds / 1000 / 60
    val seconds = (milliseconds / 1000 % 60).toString().padStart(2, '0')
    return "$minutes:$seconds"
}