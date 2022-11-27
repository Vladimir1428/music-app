package com.example.musicplayer.home.data.model

import com.google.gson.annotations.SerializedName

data class NetworkArtist(
    @SerializedName("_id")
    val id:String,

    @SerializedName("name")
    val name:String,

    @SerializedName("img")
    val img:String,

    @SerializedName("songAmount")
    val songAmount: Int
)