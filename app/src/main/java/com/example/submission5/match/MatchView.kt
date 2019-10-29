package com.example.submission5.match

import com.example.submission5.model.Main

interface MatchView{
    fun showLoading()
    fun hideLoading()
    fun showDataList (data:List<Main>)
}