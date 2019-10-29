package com.example.submission5.match


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.submission5.PagerAdapter
import kotlinx.android.synthetic.main.fragment_match.*

import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.home.MainAdapter
import com.example.submission5.model.Main
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.find

class MatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = find<ViewPager>(R.id.viewpager)
        val tabmain = find<TabLayout>(R.id.tab_main)

        viewPager.adapter = PagerAdapter(childFragmentManager)
        tabmain.setupWithViewPager(viewPager)


    }


}
