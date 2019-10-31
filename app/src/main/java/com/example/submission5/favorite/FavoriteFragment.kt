package com.example.submission5.favorite


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.submission5.R
import com.example.submission5.pageradapter.FavoritePagerAdapter
import com.example.submission5.pageradapter.PagerAdapter
import org.jetbrains.anko.support.v4.find

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = find<ViewPager>(R.id.favorite_viewpager)
        val tabmain = find<TabLayout>(R.id.favorite_tab_main)

        viewPager.adapter = FavoritePagerAdapter(childFragmentManager)
        tabmain.setupWithViewPager(viewPager)

    }

}
