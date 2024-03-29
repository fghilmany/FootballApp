package com.example.submission5.home

import android.util.Log
import com.example.submission5.api.ApiRepository
import com.example.submission5.api.TheSportDBApi
import com.example.submission5.model.MainResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (
    private val view : MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson){

    fun getLeague(league:String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeagues(league)),
                MainResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showLeague(data.leagues)
            }
        }


    }
}