package com.example.submission5.team.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.model.Main
import com.example.submission5.team.TeamPresenter
import com.example.submission5.team.TeamView
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class DetailTeam : AppCompatActivity(),TeamView {

    private lateinit var presenter: TeamPresenter
    private lateinit var item : Main

    private var idTeam :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        val intent = intent
        idTeam = intent.getStringExtra("idTeam")

        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamPresenter(this,request,gson)
        presenter.getDetailTeams(idTeam)

    }

    override fun listTeam(data: List<Main>) {

        item = Main(
            data[0].teamName,
            data[0].teamBadge,
            data[0].descTeam
        )

        val nameTeam = findViewById<TextView>(R.id.tv_detail_name_team)
        nameTeam.text = data[0].teamName

        val teamBadge = findViewById<ImageView>(R.id.iv_detail_logo_team)
        Picasso.get().load(data[0].teamBadge).into(teamBadge)

        val descTeam = findViewById<TextView>(R.id.tv_desc_team)
        descTeam.text = data[0].descTeam

    }
}
