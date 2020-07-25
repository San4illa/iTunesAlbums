package com.san4illa.itunesalbums.ui.detail

import com.san4illa.itunesalbums.di.AlbumId
import com.san4illa.itunesalbums.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class DetailPresenter @Inject constructor(
    @AlbumId private val albumId: String
) : BasePresenter<DetailView>() {
    override fun onFirstViewAttach() {
    }
}