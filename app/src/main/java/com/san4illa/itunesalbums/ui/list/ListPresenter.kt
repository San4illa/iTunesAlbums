package com.san4illa.itunesalbums.ui.list

import com.san4illa.itunesalbums.data.Repository
import com.san4illa.itunesalbums.ui.base.BasePresenter
import com.san4illa.itunesalbums.util.plusAssign
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ListPresenter @Inject constructor(
    private val repository: Repository
) : BasePresenter<ListView>() {
    fun onSearchClicked(query: String) {
        disposables += repository.getAlbums(query)
            .subscribe({
                if (it.isNotEmpty())
                    viewState.showAlbums(it)
                else
                    viewState.showEmptyView()
            }, {
                viewState.showError()
            })
    }
}