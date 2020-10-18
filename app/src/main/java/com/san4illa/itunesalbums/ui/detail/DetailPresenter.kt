package com.san4illa.itunesalbums.ui.detail

import com.san4illa.itunesalbums.data.Repository
import com.san4illa.itunesalbums.di.AlbumId
import com.san4illa.itunesalbums.ui.base.BasePresenter
import kotlinx.coroutines.launch
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class DetailPresenter @Inject constructor(
    @AlbumId private val albumId: String,
    private val router: Router,
    private val repository: Repository
) : BasePresenter<DetailView>() {
    override fun onFirstViewAttach() {
        launch {
            try {
                val album = repository.getAlbum(albumId)
                viewState.showAlbum(album)
            } catch (cause: Throwable) {
                viewState.showError()
            }
        }
    }

    fun onBackPressed() {
        router.exit()
    }
}