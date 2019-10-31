package com.example.submission5.favorite.match

data class FavoriteMatch (
    val id : Long?,
    val idEvent : String?,
    val nameHome : String?,
    val nameAway : String?,
    val scoreHome : String?,
    val scoreAway : String?,
    val dateMatch : String?){

    companion object{
        const val TABLE_FAVORITE_MATCH : String = "TABLE_FAVORITE_MATCH"
        const val ID : String = "ID_"
        const val ID_EVENT = "ID_EVENT"
        const val NAME_HOME : String = "NAME_HOME"
        const val NAME_AWAY : String = "NAME_AWAY"
        const val SCORE_HOME : String = "SCORE_HOME"
        const val SCORE_AWAY : String = "SCORE_AWAY"
        const val DATE_MATCH : String = "DATE_MATCH"
    }
}