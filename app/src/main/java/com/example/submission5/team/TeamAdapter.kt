package com.example.submission5.team

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.model.Main
import com.example.submission5.team.detail.DetailTeam
import com.example.submission5.team.player.PlayerActivity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.startActivity

class TeamAdapter (val leagues : List<Main>)
    :RecyclerView.Adapter<TeamViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_team_item, parent, false))
    }

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(leagues[position])
    }

}

class TeamViewHolder(view : View): RecyclerView.ViewHolder(view){
    private val nameTeam : TextView = view.findViewById(R.id.tv_team)
    private val teamBadge : ImageView = view.findViewById(R.id.iv_logo_team)
    private val btnPlayer : Button = view.findViewById(R.id.btn_player)
    private val btnDetail : Button = view.findViewById(R.id.btn_detail)

    fun bindItem (leagues:Main){
        nameTeam.text = leagues.teamName
        Picasso.get().load(leagues.teamBadge).into(teamBadge)


        btnPlayer.setOnClickListener {
            itemView.context.startActivity<PlayerActivity>(
                "idTeam" to leagues.idTeam
            )
        }

        btnDetail.setOnClickListener {
            itemView.context.startActivity<DetailTeam>(
                "idTeam" to leagues.idTeam
            )
        }
    }

}
