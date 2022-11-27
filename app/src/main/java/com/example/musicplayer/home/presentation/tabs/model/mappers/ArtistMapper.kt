package com.example.musicplayer.home.presentation.tabs.model.mappers

import com.example.musicplayer.home.data.model.NetworkArtist
import com.example.musicplayer.home.presentation.tabs.model.UiArtist
import javax.inject.Inject

class ArtistMapper @Inject constructor(){
    private fun mapToUiArtist(networkArtist: NetworkArtist): UiArtist {
        return UiArtist(
            name = networkArtist.name,
            albumsAmount = 100,
            songsAmount = networkArtist.songAmount,
            imgUrl = networkArtist.img
        )
    }

    fun mapToUiArtists(networkArtists: List<NetworkArtist>): List<UiArtist> {
        return networkArtists.map { mapToUiArtist(it) }
    }
}