package com.san4illa.itunesalbums.ui.list

import com.san4illa.itunesalbums.data.Repository
import com.san4illa.itunesalbums.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ListPresenter @Inject constructor(
    val repository: Repository
) : BasePresenter<ListView>() {
    override fun onFirstViewAttach() {
    }
}