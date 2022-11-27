package com.example.musicplayer.common.di

import com.example.musicplayer.home.data.TabRepository
import com.example.musicplayer.home.data.TabRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindTabRepository(tabRepositoryImp: TabRepositoryImp): TabRepository
}