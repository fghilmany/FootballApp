package com.example.submission5.home

import com.example.submission5.model.Main

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeague(data:List<Main>)
}