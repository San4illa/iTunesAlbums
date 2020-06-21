package com.san4illa.itunesalbums.ui.list

import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.ui.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ListView : BaseView {
    fun showAlbums(albums: List<Album>)
    fun showEmptyView()
}