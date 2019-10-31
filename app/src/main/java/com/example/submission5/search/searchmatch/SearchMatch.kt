package com.example.submission5.search.searchmatch


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
import com.example.submission5.match.MatchAdapter
import com.example.submission5.match.detail.DetailMatchActivity
import com.example.submission5.model.Main
import com.example.submission5.search.SearchPresenter
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.startActivity

class SearchMatch : Fragment(),MainView {

    private var matches : MutableList<Main> = mutableListOf()
    private lateinit var presenter: SearchPresenter
    private lateinit var adapterMatch: MatchAdapter

    private var keyword : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = activity!!.intent
        keyword = intent.getStringExtra("keyword")

        Log.e("cek parse",keyword)

        val request = ApiRepository()
        val gson = Gson()
        presenter = SearchPresenter(this, request, gson)
        presenter.getSearchMatch(keyword)

        adapterMatch = MatchAdapter(matches){
            startActivity<DetailMatchActivity>(
                "idMatch" to it.idEvent,
                "nameHome" to it.strHomeTeam,
                "nameAway" to it.strAwayTeam
            )
        }
        val rvSearchMatch = find<RecyclerView>(R.id.rv_search_match)
        rvSearchMatch.layoutManager = LinearLayoutManager(activity)
        rvSearchMatch.adapter = adapterMatch



    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showLeague(data: List<Main>) {
        matches.clear()
        matches.addAll(data)
        adapterMatch.notifyDataSetChanged()


    }


}
