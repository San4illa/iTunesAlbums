package com.san4illa.itunesalbums.util

import android.view.View

fun Any.objectScopeName() = "${javaClass.simpleName}_${hashCode()}"

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}