package com.example.submission5.team.player

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.model.Main
import com.example.submission5.team.TeamPresenter
import com.example.submission5.team.TeamView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.w3c.dom.Text

class DetailPlayer : AppCompatActivity(), TeamView {

    private lateinit var presenter: TeamPresenter
    private lateinit var item : Main

    private var idPlayer :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        val intent = intent
        idPlayer = intent.getStringExtra("idPlayer")

        Log.e("cek id player","${idPlayer}")

        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamPresenter(this,request,gson)
        presenter.getDetailPlayer(idPlayer)
    }

    override fun listTeam(data: List<Main>) {
        item = Main(
            data[0].fanArt,
            data[0].playerName,
            data[0].playerPosition,
            data[0].intHomeScore,
            data[0].intAwayScore,
            data[0].teamName,
            data[0].descTeam
        )

        val fanArt = find<ImageView>(R.id.iv_fanart_player)
        if (data[0].fanArt == null){
            fanArt.setImageResource(R.drawable.ic_no_image)

        }
        else{
            Picasso.get().load(data[0].fanArt).into(fanArt)
        }

        val playerName = find<TextView>(R.id.tv_player_name)
        playerName.text = data[0].playerName

        val playerPosition = find<TextView>(R.id.tv_player_position)
        playerPosition.text = data[0].playerPosition

        val playerTeam = find<TextView>(R.id.tv_player_team)
        playerTeam.text = data[0].teamName

        val playerDesc = find<TextView>(R.id.tv_player_desc)
        playerDesc.text = data[0].descTeam

    }
}
