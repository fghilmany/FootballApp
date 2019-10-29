package com.example.submission5.search

import android.util.Log
import com.example.submission5.api.ApiRepository
import com.example.submission5.api.TheSportDBApi
import com.example.submission5.home.MainView
import com.example.submission5.match.MatchView
import com.example.submission5.model.MainResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SearchPresenter (
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
){

    fun getSearchMatch(league:String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchMatch(league)),
                MainResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showLeague(data.event)
            }

        }
    }

    fun getSearchTeam(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getSearchTeam(league)),
                MainResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showLeague(data.teams)
            }
            Log.e("cek skuy","${data.teams}")
        }
    }
}