package com.example.submission5.classement

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.model.Main
import kotlinx.android.synthetic.main.classement_rv_item.view.*

class ClassementAdapter (val leagues :List<Main>)
    :RecyclerView.Adapter<ClassementViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassementViewHolder {
        return ClassementViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.classement_rv_item, parent, false))
    }

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: ClassementViewHolder, position: Int) {
        holder.bindItem(leagues[position])
    }

}

class ClassementViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val nameTeam : TextView = view.findViewById(R.id.tv_name_club)
    private val point : TextView = view.findViewById(R.id.tv_poin)
    private val win : TextView = view.findViewById(R.id.tv_win)
    private val draw : TextView = view.findViewById(R.id.tv_draw)
    private val lose : TextView = view.findViewById(R.id.tv_lose)
    private val play : TextView = view.findViewById(R.id.tv_play)

    fun bindItem (leagues: Main){

        nameTeam.text = leagues.nameTeam
        point.text = leagues.pointTeam.toString()
        win.text = leagues.win.toString()
        draw.text = leagues.draw.toString()
        lose.text = leagues.lose.toString()
        play.text = leagues.play.toString()
    }

}
