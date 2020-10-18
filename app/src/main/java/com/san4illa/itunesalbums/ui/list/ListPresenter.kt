package com.san4illa.itunesalbums.ui.list

import com.san4illa.itunesalbums.Screens
import com.san4illa.itunesalbums.data.Repository
import com.san4illa.itunesalbums.ui.base.BasePresenter
import kotlinx.coroutines.launch
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ListPresenter @Inject constructor(
    private val router: Router,
    private val repository: Repository
) : BasePresenter<ListView>() {
    fun onSearchClicked(query: String) {
        launch {
            try {
                val albums = repository.getAlbumsCoroutines(query)
                if (albums.isNotEmpty()) {
                    viewState.showAlbums(albums.sortedBy { it.albumName })
                } else {
                    viewState.showEmptyView()
                }
            } catch (cause: Throwable) {
                viewState.showError()
            }
        }
    }

    fun onAlbumClicked(albumId: String) {
        router.navigateTo(Screens.Detail(albumId))
    }
}