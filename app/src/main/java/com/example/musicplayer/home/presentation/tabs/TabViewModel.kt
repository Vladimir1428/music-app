package com.example.musicplayer.home.presentation.tabs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayer.home.data.TabRepository
import com.example.musicplayer.home.presentation.tabs.model.UiArtist
import com.example.musicplayer.home.presentation.tabs.model.mappers.ArtistMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TabViewModel @Inject constructor(
    private val tabRepository: TabRepository,
    private val artistMapper: ArtistMapper
) : ViewModel() {

    private val _artists = MutableLiveData<List<UiArtist>>()
    val artists: LiveData<List<UiArtist>> = _artists

    init {
        getArtists()
    }

    private fun getArtists() {
        viewModelScope.launch {
            val result = tabRepository.getArtists()
            _artists.value = artistMapper.mapToUiArtists(result)
        }
    }
}