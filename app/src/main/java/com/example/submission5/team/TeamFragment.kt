package com.example.submission5.team


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.match.MatchAdapter
import com.example.submission5.match.MatchPresenter
import com.example.submission5.model.Main
import com.example.submission5.model.Team
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.find

class TeamFragment : Fragment(), TeamView {
    override fun detailTeam(data: List<Team>) {

    }

    private var matches : MutableList<Main> = mutableListOf()
    private lateinit var presenter : TeamPresenter
    private lateinit var adapter: TeamAdapter

    private var idMatch : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = activity!!.intent
        idMatch = intent.getStringExtra("idLeague")

        Toast.makeText(activity, idMatch, Toast.LENGTH_SHORT).show()

        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamPresenter(this, request, gson)
        presenter.getLeague(idMatch)

        adapter = TeamAdapter(matches)
        val rvMatch = find<RecyclerView>(R.id.rv_team)
        rvMatch.layoutManager = LinearLayoutManager(activity)
        rvMatch.adapter = adapter
    }

    override fun listTeam(data: List<Main>) {
        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()
    }



}
