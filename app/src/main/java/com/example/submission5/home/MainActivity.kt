package com.example.submission5.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.utils.invisivle
import com.example.submission5.model.Main
import com.example.submission5.utils.visible
import com.google.gson.Gson
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), MainView {


    private var leagues : MutableList<Main> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var idLeague : String
    private lateinit var progressBar: ProgressBar
    private lateinit var item : Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar = findViewById(R.id.progress_bar)

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)

        val idLeague = resources.getStringArray(R.array.league_id)

        for (i in idLeague.indices){
            presenter.getLeague("${idLeague[i]}")
//            Toast.makeText(applicationContext, "${idLeague[i]}", Toast.LENGTH_LONG).show()
        }



        var rvleague = find<RecyclerView>(R.id.rv_league_list)

        rvleague.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(leagues)
        rvleague.adapter = adapter



    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisivle()

    }

    override fun showLeague(data: List<Main>) {
        leagues.clear()
        leagues.addAll(data)
        adapter.notifyDataSetChanged()

        item = Main(
            data[0].idLeague,
            data[0].strBadgeLeague,
            data[0].strLeague
        )

    }
}
