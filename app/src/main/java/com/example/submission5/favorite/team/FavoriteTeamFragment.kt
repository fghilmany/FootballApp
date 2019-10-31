package com.example.submission5.favorite.team


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.helper.database
import com.google.gson.Gson
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.find

class FavoriteTeamFragment : Fragment() {

    private var favorites : MutableList<FavoriteTeam> = mutableListOf()
    private lateinit var adapter: FavoriteTeamAdapter

    private var idMatch : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val intent = activity!!.intent
        idMatch = intent.getStringExtra("idLeague")*/

        //Toast.makeText(activity, idMatch, Toast.LENGTH_SHORT).show()

        adapter = FavoriteTeamAdapter(favorites){

        }
        val rvMatch = find<RecyclerView>(R.id.rv_team_favorite)
        rvMatch.layoutManager = LinearLayoutManager(activity)
        rvMatch.adapter = adapter

        showFavorite()

    }

    override fun onResume() {
        super.onResume()
        showFavorite()
    }

    private fun showFavorite(){
        favorites.clear()
        context?.database?.use {
            val result = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
            val favorite = result.parseList(classParser<FavoriteTeam>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()

        }
    }


}
