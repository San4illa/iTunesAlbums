package com.san4illa.itunesalbums.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<V : MvpView> : MvpPresenter<V>(), CoroutineScope {
    private val job = Job()
    override val coroutineContext = job + Dispatchers.Main

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}