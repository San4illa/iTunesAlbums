package com.san4illa.itunesalbums.ui.list

import androidx.recyclerview.widget.LinearLayoutManager
import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.data.Album
import com.san4illa.itunesalbums.ui.base.BaseFragment
import com.san4illa.itunesalbums.util.hide
import com.san4illa.itunesalbums.util.show
import kotlinx.android.synthetic.main.fragment_list.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ListFragment : BaseFragment(), ListView {
    override val layoutId: Int = R.layout.fragment_list

    @InjectPresenter
    lateinit var presenter: ListPresenter

    @ProvidePresenter
    fun providePresenter(): ListPresenter = scope.getInstance(ListPresenter::class.java)

    override fun showAlbums(albums: List<Album>) {
        progressBar.hide()
        albumsRecyclerView.show()
        emptyTextView.hide()
        errorTextView.hide()

        albumsRecyclerView.layoutManager = LinearLayoutManager(context)
        albumsRecyclerView.adapter = ListAdapter(albums)
    }

    override fun showEmptyView() {
        progressBar.hide()
        albumsRecyclerView.hide()
        emptyTextView.show()
        errorTextView.hide()
    }

    override fun showError() {
        progressBar.hide()
        albumsRecyclerView.hide()
        emptyTextView.hide()
        errorTextView.show()
    }
}