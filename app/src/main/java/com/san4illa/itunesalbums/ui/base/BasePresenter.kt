package com.san4illa.itunesalbums.ui.base

import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<V : MvpView> : MvpPresenter<V>() {
}