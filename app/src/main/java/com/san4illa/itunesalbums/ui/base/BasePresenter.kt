package com.san4illa.itunesalbums.ui.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<V : MvpView> : MvpPresenter<V>() {
    protected val disposables = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}