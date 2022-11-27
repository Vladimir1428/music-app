package com.example.musicplayer.home.data.network

import com.example.musicplayer.home.data.model.NetworkArtist
import retrofit2.http.GET

interface TabApi {
    @GET("/artist")
    suspend fun getArtists(): List<NetworkArtist>
}