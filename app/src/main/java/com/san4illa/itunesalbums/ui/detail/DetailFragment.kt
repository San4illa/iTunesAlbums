package com.san4illa.itunesalbums.ui.detail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.data.model.Album
import com.san4illa.itunesalbums.di.AlbumId
import com.san4illa.itunesalbums.ui.base.BaseFragment
import com.san4illa.itunesalbums.util.hide
import com.san4illa.itunesalbums.util.show
import kotlinx.android.synthetic.main.fragment_detail.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import toothpick.Scope
import toothpick.config.Module

class DetailFragment : BaseFragment(), DetailView {
    override val layoutId: Int = R.layout.fragment_detail

    override fun installModules(scope: Scope) {
        scope.installModules(object : Module() {
            init {
                bind(String::class.java)
                    .withName(AlbumId::class.java)
                    .toInstance(arguments?.getString(ALBUM_ID))
            }
        })
    }

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @ProvidePresenter
    fun providePresenter(): DetailPresenter = scope.getInstance(DetailPresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener {
            presenter.onBackPressed()
        }
    }

    override fun showAlbum(album: Album) {
        progressBar.hide()
        tracksRecyclerView.show()
        errorTextView.hide()

        albumNameTextView.text = album.albumName
        artistNameTextView.text = album.artistName
        releaseDateTextView.text = album.releaseDate
        Glide.with(this)
            .load(album.imageUrl)
            .placeholder(R.drawable.empty_cover)
            .into(coverImageView)

        album.tracks?.let {
            tracksRecyclerView.layoutManager = LinearLayoutManager(context)
            tracksRecyclerView.adapter = TracksAdapter(it)
        }
    }

    override fun showError() {
        progressBar.hide()
        tracksRecyclerView.hide()
        errorTextView.show()
    }

    companion object {
        private const val ALBUM_ID = "album_id"

        fun newInstance(albumId: String) = DetailFragment().apply {
            arguments = Bundle().apply { putString(ALBUM_ID, albumId) }
        }
    }
}