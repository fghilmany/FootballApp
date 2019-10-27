package com.example.submission5.api

import com.example.submission5.BuildConfig

object TheSportDBApi {
    fun getLeagues(league:String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupleague.php?id=" + league
    }
    // https://www.thesportsdb.com/api/v1/json/1/lookupleague.php?id={idLeague}
}