package com.example.submission5.match.pastmatch


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
import com.example.submission5.match.detail.DetailMatchActivity
import com.example.submission5.model.Main
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_past.*
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.startActivity
import java.nio.file.Files.find

class PastFragment : Fragment(),MatchView {


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
        return inflater.inflate(R.layout.fragment_past, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = activity!!.intent
        idMatch = intent.getStringExtra("idLeague")

        Log.e("cek id","$idMatch")

        val request = ApiRepository()
        val gson = Gson()
        presenter = MatchPresenter(this, request, gson)
        presenter.getPastMatch(idMatch)

        adapter = MatchAdapter(matches){
            startActivity<DetailMatchActivity>(
                "idMatch" to it.idEvent,
                "nameHome" to it.strHomeTeam,
                "nameAway" to it.strAwayTeam
            )
        }
        val rvMatch = find<RecyclerView>(R.id.rv_match_past)
        rvMatch.layoutManager = LinearLayoutManager(activity)
        rvMatch.adapter = adapter

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
            data[0].intHomeScore,
            data[0].intAwayScore,
            data[0].dateEvent

        )


    }


}
