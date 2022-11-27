package com.example.musicplayer.common.di

import com.example.musicplayer.common.Constants
import com.example.musicplayer.home.data.TabRepositoryImp
import com.example.musicplayer.home.data.network.TabApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    @Provides
    fun provideTabApi(retrofit: Retrofit): TabApi = retrofit.create(TabApi::class.java)
}