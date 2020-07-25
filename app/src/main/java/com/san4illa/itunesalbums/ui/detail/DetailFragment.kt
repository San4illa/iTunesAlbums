package com.san4illa.itunesalbums.ui.detail

import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.ui.base.BaseFragment
import com.san4illa.itunesalbums.util.hide
import com.san4illa.itunesalbums.util.show
import kotlinx.android.synthetic.main.fragment_detail.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class DetailFragment : BaseFragment(), DetailView {
    override val layoutId: Int = R.layout.fragment_detail

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @ProvidePresenter
    fun providePresenter(): DetailPresenter = scope.getInstance(DetailPresenter::class.java)

    override fun showAlbum(album: Album) {
        progressBar.hide()
        tracksRecyclerView.hide()
        errorTextView.hide()
    }

    override fun showError() {
        progressBar.hide()
        tracksRecyclerView.hide()
        errorTextView.show()
    }
}