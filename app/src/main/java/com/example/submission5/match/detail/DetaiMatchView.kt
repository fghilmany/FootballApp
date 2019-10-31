package com.example.submission5.match.detail

import com.example.submission5.model.Main

interface DetaiMatchView {
    fun showDetail(data:List<Main>)
    fun showHomeBadge(data:List<Main>)
    fun showAwayBadge(data:List<Main>)
}