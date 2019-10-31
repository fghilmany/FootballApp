package com.example.submission5.team.player

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.model.Main
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_player.view.*

class PlayerAdapter(val player : List<Main>, private val listener:(Main)->Unit)
    :RecyclerView.Adapter<PlayerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_grid_player_item, parent, false))
    }

    override fun getItemCount(): Int = player.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bindItem(player[position],listener)
    }

}

class PlayerViewHolder(view : View):RecyclerView.ViewHolder(view) {
    private val playerName : TextView = view.findViewById(R.id.tv_player_grid_name)
    private val playerIcon : ImageView = view.findViewById(R.id.iv_grid_player)

    fun bindItem(players:Main, listener: (Main) -> Unit){
        playerName.text = players.playerName
        Picasso.get().load(players.playerIcon)
            .into(playerIcon)

        itemView.setOnClickListener { listener(players) }
    }

}
