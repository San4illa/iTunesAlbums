package com.san4illa.itunesalbums.ui.list

import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.ui.base.BaseFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ListFragment : BaseFragment(), ListView {
    override val layoutId: Int = R.layout.fragment_list

    @InjectPresenter
    lateinit var presenter: ListPresenter

    @ProvidePresenter
    fun providePresenter(): ListPresenter = scope.getInstance(ListPresenter::class.java)

    override fun showAlbums() {
    }

    override fun showEmptyView() {
    }

    override fun showError() {
    }
}