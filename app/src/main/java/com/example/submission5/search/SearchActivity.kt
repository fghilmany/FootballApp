package com.example.submission5.search

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
import com.example.submission5.model.Main
import com.example.submission5.team.TeamAdapter
import com.example.submission5.team.TeamPresenter
import com.google.gson.Gson
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.find
import java.nio.file.Files.find

class SearchActivity : AppCompatActivity(), MainView {
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showLeague(data: List<Main>) {
        matches.clear()
        matches.addAll(data)
        Log.e("cek add all","${teams.addAll(data)}")
        adapterMatch.notifyDataSetChanged()
        teams.clear()
        teams.addAll(data)
        adapterTeam.notifyDataSetChanged()


    }

    private var matches : MutableList<Main> = mutableListOf()
    private var teams : MutableList<Main> = mutableListOf()
    private lateinit var presenter: SearchPresenter
    private lateinit var adapterMatch: MatchAdapter
    private lateinit var adapterTeam: TeamAdapter

    private var keyword : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val intent = intent
        keyword = intent.getStringExtra("keyword")

        Log.e("cek parse",keyword)

        val request = ApiRepository()
        val gson = Gson()
        presenter = SearchPresenter(this, request, gson)
        presenter.getSearchTeam(keyword)
        presenter.getSearchMatch(keyword)

        adapterMatch = MatchAdapter(matches)
        val rvSearchMatch = find<RecyclerView>(R.id.rv_search_match)
        rvSearchMatch.layoutManager = LinearLayoutManager(applicationContext)
        rvSearchMatch.adapter = adapterMatch

        adapterTeam = TeamAdapter(teams)
        val rvSearchTeam = find<RecyclerView>(R.id.rv_search_team)
        rvSearchTeam.layoutManager = LinearLayoutManager(applicationContext)
        rvSearchTeam.adapter = adapterTeam

        Log.e("cek adapte", "$adapterTeam")
    }
}
