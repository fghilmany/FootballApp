package com.example.submission5.search.searchteam


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.home.MainView
import com.example.submission5.model.Main
import com.example.submission5.search.SearchPresenter
import com.example.submission5.team.TeamAdapter
import com.example.submission5.team.detail.DetailTeam
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.startActivity

class SearchTeam : Fragment(), MainView {

    private var teams : MutableList<Main> = mutableListOf()
    private lateinit var presenter: SearchPresenter
    private lateinit var adapterTeam: TeamAdapter

    private var keyword : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = activity!!.intent
        keyword = intent.getStringExtra("keyword")

        Log.e("cek parse",keyword)

        val request = ApiRepository()
        val gson = Gson()
        presenter = SearchPresenter(this, request, gson)
        presenter.getSearchTeam(keyword)

        adapterTeam = TeamAdapter(teams)

        val rvSearchMatch = find<RecyclerView>(R.id.rv_search_item)
        rvSearchMatch.layoutManager = LinearLayoutManager(activity)
        rvSearchMatch.adapter = adapterTeam
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showLeague(data: List<Main>) {
        teams.clear()
        teams.addAll(data)
        adapterTeam.notifyDataSetChanged()
    }


}
