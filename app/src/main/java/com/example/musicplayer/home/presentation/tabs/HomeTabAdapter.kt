package com.example.musicplayer.home.presentation.tabs

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return TABS_AMOUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            2 -> ArtistFragment()
            else -> Fragment()
        }
    }

    companion object {
        private const val TABS_AMOUNT = 5
    }
}