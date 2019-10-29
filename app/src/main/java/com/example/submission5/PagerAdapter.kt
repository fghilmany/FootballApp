package com.example.submission5

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.submission5.match.nextmatch.NextFragment
import com.example.submission5.match.pastmatch.PastFragment

class PagerAdapter(fm : FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        PastFragment(),
        NextFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position] as Fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Past Match"
            else -> "Next Match"
        }
    }




}