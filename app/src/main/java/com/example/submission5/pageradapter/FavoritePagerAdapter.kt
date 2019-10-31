package com.example.submission5.pageradapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.submission5.favorite.match.FavoriteMatchFragment
import com.example.submission5.favorite.team.FavoriteTeamFragment

class FavoritePagerAdapter (fm : FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        FavoriteMatchFragment(),
        FavoriteTeamFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position] as Fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Match"
            else -> "Team"
        }
    }




}