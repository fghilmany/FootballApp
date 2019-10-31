package com.example.submission5.favorite.match


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.submission5.R
import com.example.submission5.helper.database
import com.example.submission5.match.detail.DetailMatchActivity
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.find

class FavoriteMatchFragment : Fragment() {

    private var favorites:MutableList<FavoriteMatch> = mutableListOf()
    private lateinit var adapter: FavoriteMatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavoriteMatchAdapter(favorites){
            context?.startActivity<DetailMatchActivity>(
                "idMatch" to it.idEvent,
                "nameHome" to it.nameHome,
                "nameAway" to it.nameAway
            )
            Log.e("cek id fav","${it.idEvent}")
        }

        val rvFavorite = find<RecyclerView>(R.id.rv_favorite_match)
        rvFavorite.layoutManager = LinearLayoutManager(activity)
        rvFavorite.adapter = adapter

        showFavorite()

    }

    override fun onResume() {
        super.onResume()
        showFavorite()
    }

    private fun showFavorite(){
        favorites.clear()
        context?.database?.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()

        }
    }


}
