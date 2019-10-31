package com.example.submission5.api

import com.example.submission5.BuildConfig

object TheSportDBApi {
    fun getLeagues(league:String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupleague.php?id=" + league
    }
    // https://www.thesportsdb.com/api/v1/json/1/lookupleague.php?id={idLeague}

    fun getPastMatch(league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id={idLeague}
        //https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4387
    }

    fun getNextMatch(league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id={idLeague}
    }

    fun getClassement(league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookuptable.php?l=" + league
        //https://www.thesportsdb.com/api/v1/json/1/lookuptable.php?l=4328
    }

    fun getTeam(league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookup_all_teams.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id={idLeague}
    }

    fun getPlayer(league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookup_all_players.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/lookup_all_players.php?id=133604
    }

    fun getSearchMatch (league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchevents.php?e=" + league
        //https://www.thesportsdb.com/api/v1/json/1/searchevents.php?e={query}
    }

    fun getSearchTeam (league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchteams.php?t=" + league
        //https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t={query}
    }

    fun getTeamDetail (league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id={idTeam}
    }

    fun getPlayerDetail(league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupplayer.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/lookupplayer.php?id={idPemain}
    }

    fun getMatchDetail (league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupevent.php?id=" + league
        //https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id={idEvent}
    }

    fun getBadgeTeam (league: String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchteams.php?t=" + league
        //"/searchteams.php?t="
    }
}