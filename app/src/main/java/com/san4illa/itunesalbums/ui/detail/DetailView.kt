package com.san4illa.itunesalbums.ui.detail

import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.ui.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailView : BaseView {
    fun showAlbum(album: Album)
}