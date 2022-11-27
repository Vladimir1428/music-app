package com.example.musicplayer.home.data

import com.example.musicplayer.common.di.IoDispatcher
import com.example.musicplayer.home.data.model.NetworkArtist
import com.example.musicplayer.home.data.network.TabApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TabRepositoryImp @Inject constructor(
    private val tabApi: TabApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : TabRepository {
    override suspend fun getArtists(): List<NetworkArtist> = withContext(dispatcher) {
         tabApi.getArtists()
    }
}