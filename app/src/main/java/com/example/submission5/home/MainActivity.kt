package com.example.submission5.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import com.example.submission5.LeaguesItem
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.utils.invisivle
import com.example.submission5.model.Main
import com.example.submission5.utils.visible
import com.google.gson.Gson
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {


    private var leagues : MutableList<LeaguesItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)

        val idLeague = resources.getStringArray(R.array.league_id)
        //val idLeague = Leagues.listData

        for (i in idLeague.indices){
            leagues.add(Main(idLeague[i]))
            presenter.getLeague(leagues.toString())
            Toast.makeText(applicationContext, "${leagues}", Toast.LENGTH_LONG).show()
        }
        //presenter.getLeague(idLeague[3])

        //presenter.getLeague(Leagues.listData.toString())
        Log.e("cek id league","${leagues}")

*/

        val rvleague = find<RecyclerView>(R.id.rv_league_list)
        initData()
        /*val idLeague = resources.getStringArray(R.array.league_id)
        val nameLeague = resources.getStringArray(R.array.club_name)
        val leagueaBadge = resources.obtainTypedArray(R.array.club_image)
        leagues.clear()
        Log.e("cek id ","$idLeague")
        for (i in idLeague.indices){
            leagues.add(LeaguesItem(
                idLeague[i],
                nameLeague[i],
                leagueaBadge.getResourceId(i,0))
            )
            Log.e("cek id ","$idLeague")

            leagueaBadge.recycle()
        }*/

        rvleague.layoutManager = LinearLayoutManager(this)
        /*adapter = MainAdapter(this,leagues)
        rvleague.adapter = adapter
*/      rvleague.adapter = MainAdapter( leagues)
        Log.e("cek rv","$rvleague")
        //Log.e("cek init ","${initData()}")

    }

    fun initData(){
        val idLeague = resources.getStringArray(R.array.league_id)
        val nameLeague = resources.getStringArray(R.array.club_name)
        val leagueaBadge = resources.obtainTypedArray(R.array.club_image)
        leagues.clear()
        for (i in idLeague.indices){
            leagues.add(LeaguesItem(
                idLeague[i],
                nameLeague[i],
                leagueaBadge.getResourceId(i,0))
                )
            Log.e("cek id ","$idLeague")

            //leagueaBadge.recycle()
        }

    }

}
