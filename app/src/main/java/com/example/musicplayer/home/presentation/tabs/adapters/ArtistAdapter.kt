package com.example.musicplayer.home.presentation.tabs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.databinding.ArtistItemBinding
import com.example.musicplayer.home.presentation.tabs.model.UiArtist

class ArtistAdapter(private val artists: List<UiArtist>) :
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    class ArtistViewHolder(private val artistItemBinding: ArtistItemBinding) :
        RecyclerView.ViewHolder(artistItemBinding.root) {
        fun onBind(uiArtist: UiArtist) {
            artistItemBinding.artistNameTv.text = uiArtist.name
            artistItemBinding.albumsAmountTv.text = if (uiArtist.albumsAmount > 1) "${uiArtist.albumsAmount} Albums" else "${uiArtist.albumsAmount} Album"
            artistItemBinding.songsAmountTv.text = if (uiArtist.songsAmount > 1) "${uiArtist.songsAmount} Songs" else "${uiArtist.songsAmount} Song"
            Glide.with(artistItemBinding.root.context)
                .load(uiArtist.imgUrl)
                .into(artistItemBinding.artistImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArtistItemBinding.inflate(inflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.onBind(artists[position])
    }

    override fun getItemCount(): Int {
        return artists.size
    }
}