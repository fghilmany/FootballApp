package com.example.submission5.search

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.home.MainAdapter
import com.example.submission5.home.MainPresenter
import com.example.submission5.home.MainView
import com.example.submission5.match.MatchAdapter
import com.example.submission5.match.MatchPresenter
import com.example.submission5.match.detail.DetailMatchActivity
import com.example.submission5.model.Main
import com.example.submission5.pageradapter.PagerAdapter
import com.example.submission5.pageradapter.SearchPagerAdapter
import com.example.submission5.team.TeamAdapter
import com.example.submission5.team.TeamPresenter
import com.google.gson.Gson
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.startActivity
import java.nio.file.Files.find

class SearchActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val viewPager = find<ViewPager>(R.id.search_viewpager)
        val tabmain = find<TabLayout>(R.id.search_tab_main)

        viewPager.adapter = SearchPagerAdapter(supportFragmentManager)
        tabmain.setupWithViewPager(viewPager)
    }
}
