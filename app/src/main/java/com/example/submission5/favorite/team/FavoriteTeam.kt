package com.example.submission5.favorite.team

class FavoriteTeam(
    val idFTeam : Long?,
    val idTeam : String?,
    val nameTeam : String?,
    val teamBadge : String?){

    companion object{
        const val TABLE_FAVORITE_TEAM : String = "TABLE_FAVORITE_TEAM"
        const val ID_F_TEAM : String ="ID_F_TEAM_"
        const val ID_TEAM : String ="ID_TEAM"
        const val NAME_TEAM : String = "NAME_TEAM"
        const val TEAM_BADGE : String = "TEAM_BADGE"
    }
}