package com.example.submission5.model

import com.google.gson.annotations.SerializedName

data class Main (

    //league
    @SerializedName("idLeague")
    var idLeague : String? = null,

    @SerializedName("strBadge")
    var strBadgeLeague : String? = null,

    @SerializedName("strLeague")
    var strLeague :String? = null
)