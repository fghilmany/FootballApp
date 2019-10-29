package com.example.submission5.home

import android.content.Intent
import android.media.Image
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.submission5.R
import com.example.submission5.classement.ClassementActivity
import com.example.submission5.detail.DetailActivity
import com.example.submission5.match.nextmatch.NextFragment
import com.example.submission5.match.pastmatch.PastFragment
import com.example.submission5.model.Main
import com.example.submission5.team.TeamFragment
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainAdapter(private val leagues:List<Main>)
    : RecyclerView.Adapter<LeagueViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.league_card_view_item, parent, false))
        //return LeagueViewHolder(view)
    }

    override fun getItemCount(): Int = leagues.size


    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(leagues[position])

    }

}

class LeagueViewHolder (view: View):RecyclerView.ViewHolder(view){

    private val leagueBadge : ImageView = view.findViewById(R.id.item_card_league)
    private val leagueName : TextView = view.findViewById(R.id.tv_league)
    val btnClassment : Button = view.findViewById(R.id.btn_classement)
    val btnDetail : Button = view.findViewById(R.id.detail)

    fun bindItem(leagues:Main){
        Picasso.get().load(leagues.strBadgeLeague).fit().into(leagueBadge)
        leagueName.text = leagues.strLeague

        btnDetail.setOnClickListener {
            itemView.context.startActivity<DetailActivity>(
                "idLeague" to leagues.idLeague
            )
            Toast.makeText(itemView.context, leagues.strLeague, Toast.LENGTH_SHORT).show()
        }

        btnClassment.setOnClickListener {
            itemView.context.startActivity<ClassementActivity>(
                "idLeague" to leagues.idLeague
            )
        }


    }

}
