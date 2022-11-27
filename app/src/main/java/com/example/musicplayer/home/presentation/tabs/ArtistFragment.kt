package com.example.musicplayer.home.presentation.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.databinding.FragmentArtistBinding
import com.example.musicplayer.home.presentation.tabs.adapters.ArtistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    private var _artistBinding: FragmentArtistBinding? = null
    private val artistBinding: FragmentArtistBinding
        get() = _artistBinding!!

    private val tabViewModel: TabViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _artistBinding = FragmentArtistBinding.inflate(inflater, container, false)
        return artistBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        tabViewModel.artists.observe(viewLifecycleOwner) { artists ->
            artistBinding.artistRw.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ArtistAdapter(artists)
            }
        }
    }

    override fun onDestroy() {
        _artistBinding = null
        super.onDestroy()
    }
}