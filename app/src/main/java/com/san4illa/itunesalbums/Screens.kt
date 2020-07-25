package com.san4illa.itunesalbums

import androidx.fragment.app.Fragment
import com.san4illa.itunesalbums.ui.detail.DetailFragment
import com.san4illa.itunesalbums.ui.list.ListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object List : SupportAppScreen() {
        override fun getFragment(): Fragment = ListFragment()
    }

    data class Detail(val albumId: String) : SupportAppScreen() {
        override fun getFragment(): Fragment = DetailFragment.newInstance(albumId)
    }
}