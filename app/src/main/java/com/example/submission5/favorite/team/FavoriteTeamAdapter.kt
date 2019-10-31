package com.example.submission5.favorite.team

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.squareup.picasso.Picasso

class FavoriteTeamAdapter (private val teams : List<FavoriteTeam>, private val listener:(FavoriteTeam)->Unit)
    : RecyclerView.Adapter<MatchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_match_item, parent, false))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(teams[position],listener)
    }

}

class MatchViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val teamName : TextView = view.findViewById(R.id.tv_team)
    private val teamBadge : ImageView = view.findViewById(R.id.iv_logo_team)

    fun bindItem (matches : FavoriteTeam, listener: (FavoriteTeam) -> Unit){

        teamName.text = matches.nameTeam
        Picasso.get().load(matches.teamBadge).into(teamBadge)

        itemView.setOnClickListener { listener(matches) }

    }

}