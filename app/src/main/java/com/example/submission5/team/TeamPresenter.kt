package com.example.submission5.team

import android.util.Log
import com.example.submission5.api.ApiRepository
import com.example.submission5.api.TheSportDBApi
import com.example.submission5.home.MainView
import com.example.submission5.model.MainResponse
import com.example.submission5.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter (
    private val view : TeamView,
    private val apiRepository: ApiRepository,
    private val gson: Gson){

    fun getLeague(league:String?){
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeam(league)),
                MainResponse::class.java)

            uiThread {
                view.listTeam(data.teams)
            }
        }


    }

    fun getPlayer(league: String?) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getPlayer(league)),
                MainResponse::class.java
            )

            uiThread {
                view.listTeam(data.player)
            }
        }
    }

    fun getDetailTeams (league:String?) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.detailTeam(data.teams)
            }
            Log.e("cek teams","${data.teams}")
        }
    }

    fun getDetailPlayer(league: String?){
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getPlayerDetail(league)),
                MainResponse::class.java
            )

            uiThread {
                view.listTeam(data.players)
            }
            Log.e("cek id player","${data.players}")
        }
    }
}