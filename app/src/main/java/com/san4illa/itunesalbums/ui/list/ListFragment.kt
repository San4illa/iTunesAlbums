package com.san4illa.itunesalbums.ui.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.data.model.Album
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.title = getString(R.string.app_name)
        toolbar.inflateMenu(R.menu.menu)

        val searchItem = toolbar.menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                progressBar.visibility = View.VISIBLE
                albumsRecyclerView.visibility = View.INVISIBLE
                emptyTextView.visibility = View.INVISIBLE
                errorTextView.visibility = View.INVISIBLE

                presenter.onSearchClicked(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean = true
        })
    }

    override fun showAlbums(albums: List<Album>) {
        progressBar.hide()
        albumsRecyclerView.show()
        emptyTextView.hide()
        errorTextView.hide()

        albumsRecyclerView.layoutManager = LinearLayoutManager(context)
        albumsRecyclerView.adapter = ListAdapter(albums, presenter::onAlbumClicked)
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