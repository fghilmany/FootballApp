package com.example.submission5.model

import com.google.gson.annotations.SerializedName

data class Team (

    @SerializedName("idTeam")
    var idTeam : String? = null,

    @SerializedName("strTeam")
    var teamName : String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge : String? = null,

    @SerializedName("strDescriptionEN")
    var descTeam : String? = null
)