package com.example.submission5.favorite.match

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.model.Main

class FavoriteMatchAdapter (private val events : List<FavoriteMatch>, private val listener:(FavoriteMatch)->Unit)
    : RecyclerView.Adapter<MatchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_match_item, parent, false))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(events[position],listener)
    }

}

class MatchViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val homeName : TextView = view.findViewById(R.id.tv_home_name)
    private val awayName : TextView = view.findViewById(R.id.tv_away_name)
    private val homeScore : TextView = view.findViewById(R.id.tv_home_score)
    private val awayScore : TextView = view.findViewById(R.id.tv_away_score)
    private val dateMatch : TextView = view.findViewById(R.id.tv_date_match)

    fun bindItem (matches : FavoriteMatch, listener: (FavoriteMatch) -> Unit){

        homeName.text = matches.nameHome
        awayName.text = matches.nameAway
        homeScore.text = matches.scoreHome
        awayScore.text = matches.scoreAway
        dateMatch.text = matches.dateMatch

        Log.e("cek tv nama","${matches.nameHome}")
        Log.e("cek tv nama","${matches.idEvent}")
        Log.e("cek tv nama","${matches.scoreHome}")
        Log.e("cek tv nama","${matches.dateMatch}")

        if (matches.scoreHome == null){
            homeScore.text = null
            awayScore.text = null
        }

        itemView.setOnClickListener { listener(matches) }

    }

}
