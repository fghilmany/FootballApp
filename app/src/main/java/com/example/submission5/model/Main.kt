package com.example.submission5.model

import com.google.gson.annotations.SerializedName

data class Main (

    //Match
    @SerializedName("idEvent")
    var idEvent : String? = null,

    @SerializedName("strHomeTeam")
    var strHomeTeam : String? = null,

    @SerializedName("strAwayTeam")
    var strAwayTeam : String? = null,

    @SerializedName("intHomeScore")
    var intHomeScore : Int? = 0,

    @SerializedName("intAwayScore")
    var intAwayScore : Int = 0,

    @SerializedName("dateEvent")
    var dateEvent : String? = null,

    //league
    @SerializedName("idLeague")
    var idLeague : String? = null,

    @SerializedName("strBadge")
    var strBadgeLeague : String? = null,

    @SerializedName("strLeague")
    var strLeague :String? = null,


    //Classement
    @SerializedName("name")
    var nameTeam : String? = null,

    @SerializedName("total")
    var pointTeam : Int? = 0,

    @SerializedName("win")
    var win : Int? = 0,

    @SerializedName("draw")
    var draw : Int? = 0,

    @SerializedName("loss")
    var lose : Int? = 0,

    @SerializedName("played")
    var play : Int? = 0,

    //List Team
    @SerializedName("idTeam")
    var idTeam : String? = null,

    @SerializedName("strTeam")
    var teamName : String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge : String? = null,

    //player
    @SerializedName("idPlayer")
    var idPlayer : String? = null,

    @SerializedName("strPlayer")
    var playerName : String? = null,

    @SerializedName("strCutout")
    var playerIcon : String? = null,

    //detail team
    //team name ada di list team
    //team badge ada di list team,

    @SerializedName("strDescriptionEN")
    var descTeam : String? = null,

    //detail player
    @SerializedName("strFanart2")
    var fanArt : String? = null,

    //player name ada di player
    @SerializedName("strPosition")
    var playerPosition : String? = null,
    //player team pakai yang di atas

    /*@SerializedName("strTeam")
    var playerTeam : String? = null*/

    //desc pakai yang di atas

//    @SerializedName("strDescriptionEN")
//    var playerDesc : String? = null

    //detail match
    @SerializedName("strHomeFormation")
    var strHomeFormation : String? = null,

    @SerializedName("strAwayFormation")
    var strAwayFormation : String? = null,

    @SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails : String? = null,

    @SerializedName("strAwayGoalDetails")
    var strAwayGoalDetails : String? = null,

    @SerializedName("strHomeYellowCards")
    var strHomeYellowCards : String? = null,

    @SerializedName("strAwayYellowCards")
    var strAwayYellowCards : String? = null,

    @SerializedName("strHomeRedCards")
    var strHomeRedCards : String? = null,

    @SerializedName("strAwayRedCards")
    var strAwayRedCards : String? = null


)