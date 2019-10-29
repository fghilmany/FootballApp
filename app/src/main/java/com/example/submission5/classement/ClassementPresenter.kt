package com.example.submission5.classement

import android.util.Log
import com.example.submission5.api.ApiRepository
import com.example.submission5.api.TheSportDBApi
import com.example.submission5.match.MatchView
import com.example.submission5.model.MainResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ClassementPresenter (
    private val view: ClassementView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getClassement(league: String?) {
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getClassement(league)),
                MainResponse::class.java
            )

            uiThread {
                view.showClassement(data.table)
            }
        }
    }
}