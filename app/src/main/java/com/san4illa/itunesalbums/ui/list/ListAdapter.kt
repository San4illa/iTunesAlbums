package com.san4illa.itunesalbums.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.san4illa.itunesalbums.R
import com.san4illa.itunesalbums.data.model.Album
import kotlinx.android.synthetic.main.album_item.view.*

class ListAdapter(private var albums: List<Album>) : RecyclerView.Adapter<ListAdapter.ListAdapterVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return ListAdapterVH(view)
    }

    override fun onBindViewHolder(holder: ListAdapterVH, position: Int) = holder.bind(albums[position])

    override fun getItemCount(): Int = albums.size

    inner class ListAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(album: Album) {
            with(itemView) {
                albumName.text = album.albumName
                artistName.text = album.artistName
                Glide.with(context)
                    .load(album.imageUrl)
                    .placeholder(R.drawable.empty_cover)
                    .into(image)
            }
        }
    }
}