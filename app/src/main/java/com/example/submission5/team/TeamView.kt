package com.example.submission5.team

import com.example.submission5.model.Main
import com.example.submission5.model.Team

interface TeamView {
    fun listTeam(data:List<Main> )
    fun detailTeam(data:List<Team>)
}