package com.example.submission5.match

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.home.LeagueViewHolder
import com.example.submission5.model.Main


class MatchAdapter (private val events : List<Main>)
    : RecyclerView.Adapter<MatchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_match_item, parent, false))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(events[position])
    }

}

class MatchViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val homeName : TextView = view.findViewById(R.id.tv_home_name)
    private val awayName : TextView = view.findViewById(R.id.tv_away_name)
    private val homeScore : TextView = view.findViewById(R.id.tv_home_score)
    private val awayScore : TextView = view.findViewById(R.id.tv_away_score)
    private val dateMatch : TextView = view.findViewById(R.id.tv_date_match)

    fun bindItem (matches : Main){

        homeName.text = matches.strHomeTeam
        awayName.text = matches.strAwayTeam
        homeScore.text = matches.intHomeScore.toString()
        awayScore.text = matches.intAwayScore.toString()
        dateMatch.text = matches.dateEvent

        if (matches.intHomeScore == null){
            homeScore.text = null
            awayScore.text = null
        }

    }

}
