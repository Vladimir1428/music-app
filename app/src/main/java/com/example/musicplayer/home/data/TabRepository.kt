package com.example.musicplayer.home.data

import com.example.musicplayer.home.data.model.NetworkArtist

interface TabRepository {
    suspend fun getArtists(): List<NetworkArtist>
}