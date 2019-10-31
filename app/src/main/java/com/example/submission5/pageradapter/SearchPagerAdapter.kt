package com.example.submission5.pageradapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.submission5.search.searchmatch.SearchMatch
import com.example.submission5.search.searchteam.SearchTeam

class SearchPagerAdapter (fm : FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        SearchMatch(),
        SearchTeam()
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