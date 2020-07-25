package com.san4illa.itunesalbums.ui.list

import com.san4illa.itunesalbums.Screens
import com.san4illa.itunesalbums.data.Repository
import com.san4illa.itunesalbums.ui.base.BasePresenter
import com.san4illa.itunesalbums.util.plusAssign
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ListPresenter @Inject constructor(
    private val router: Router,
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

    fun onAlbumClicked(albumId: String) {
        router.navigateTo(Screens.Detail(albumId))
    }
}