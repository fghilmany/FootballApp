package com.example.submission5.match.detail

import com.example.submission5.api.ApiRepository
import com.example.submission5.api.TheSportDBApi
import com.example.submission5.model.MainResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailMatchPresenter (
    private val view: DetaiMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson){
    fun getMatchDetail(league: String?){
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getMatchDetail(league)),
                MainResponse::class.java)

            uiThread {
                view.showDetail(data.events)
//                view.showHomeBadge(data.teams)
 //               view.showAwayBadge(data.teams)
            }
        }
    }

    fun getHomeBadge(league: String?){
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getBadgeTeam(league)),
                MainResponse::class.java)

            uiThread {
                //view.showDetail(data.events)
                view.showHomeBadge(data.teams)
                //view.showAwayBadge(data.teams)
            }
        }
    }

    fun getAwayBadge(league: String?){
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getBadgeTeam(league)),
                MainResponse::class.java)

            uiThread {
                //view.showDetail(data.events)
                //view.showHomeBadge(data.teams)
                view.showAwayBadge(data.teams)
            }
        }
    }
}