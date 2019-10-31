package com.example.submission5.match

import android.util.Log
import com.example.submission5.api.ApiRepository
import com.example.submission5.api.TheSportDBApi
import com.example.submission5.model.MainResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchPresenter (
    private val view: MatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson){

    fun getPastMatch(league:String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPastMatch(league)),
                MainResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showDataList(data.events)
            }
        }
    }

    fun getNextMatch(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNextMatch(league)),
                MainResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showDataList(data.events)
            }
        }
    }


}