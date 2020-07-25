package com.san4illa.itunesalbums.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.data.model.Track
import kotlinx.android.synthetic.main.track_item.view.*

class TracksAdapter(private val tracks: List<Track>) : RecyclerView.Adapter<TracksAdapter.TracksAdapterVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksAdapterVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.track_item, parent, false)
        return TracksAdapterVH(view)
    }

    override fun onBindViewHolder(holder: TracksAdapterVH, position: Int) = holder.bind(tracks[position])

    override fun getItemCount(): Int = tracks.size

    inner class TracksAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(track: Track) {
            with(itemView) {
                number.text = track.number
                name.text = track.name
                length.text = track.length
            }
        }
    }
}