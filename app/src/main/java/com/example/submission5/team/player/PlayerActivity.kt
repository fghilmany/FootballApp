package com.example.submission5.team.player

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.match.MatchAdapter
import com.example.submission5.match.MatchPresenter
import com.example.submission5.model.Main
import com.example.submission5.model.Team
import com.example.submission5.team.TeamPresenter
import com.example.submission5.team.TeamView
import com.google.gson.Gson
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.find
import java.nio.file.Files.find

class PlayerActivity : AppCompatActivity(), TeamView {
    override fun detailTeam(data: List<Team>) {

    }

    override fun listTeam(data: List<Main>) {
        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()
    }

    private var matches : MutableList<Main> = mutableListOf()
    private lateinit var presenter : TeamPresenter
    private lateinit var adapter: PlayerAdapter

    private var idTeam : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val intent = intent
        idTeam = intent.getStringExtra("idTeam")

        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamPresenter(this, request, gson)
        presenter.getPlayer(idTeam)

        adapter = PlayerAdapter(matches){
            applicationContext.startActivity<DetailPlayer>(
                "idPlayer" to it.idPlayer
            )
        }
        val rvMatch = find<RecyclerView>(R.id.rv_grid_player)
        rvMatch.layoutManager = LinearLayoutManager(applicationContext)
        rvMatch.adapter = adapter
    }
}
