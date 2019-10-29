package com.example.submission5.match.nextmatch


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.match.MatchAdapter
import com.example.submission5.match.MatchPresenter
import com.example.submission5.match.MatchView
import com.example.submission5.match.pastmatch.PastFragment
import com.example.submission5.model.Main
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.find

class NextFragment : Fragment(),MatchView {

    private var matches : MutableList<Main> = mutableListOf()
    private lateinit var presenter : MatchPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var item : Main

    private var idMatch : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = activity!!.intent
        idMatch = intent.getStringExtra("idLeague")


        val request = ApiRepository()
        val gson = Gson()
        presenter = MatchPresenter(this, request, gson)
        presenter.getNextMatch(idMatch)

        adapter = MatchAdapter(matches)
        val rvMatch = find<RecyclerView>(R.id.rv_match_next)
        rvMatch.layoutManager = LinearLayoutManager(activity)
        rvMatch.adapter = adapter

    }

    companion object{
        const val ID_LEAGUE_1 = "id_league"
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showDataList(data: List<Main>) {

        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()

        item = Main(
            data[0].idLeague,
            data[0].strHomeTeam,
            data[0].strAwayTeam,
            data[0].intHomeScore.toString(),
            data[0].intAwayScore.toString(),
            data[0].dateEvent

        )

    }


}
