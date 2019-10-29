package com.example.submission5.classement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.match.MatchAdapter
import com.example.submission5.match.MatchPresenter
import com.example.submission5.model.Main
import com.google.gson.Gson

class ClassementActivity : AppCompatActivity(), ClassementView {


    private var matches : MutableList<Main> = mutableListOf()
    private lateinit var presenter : ClassementPresenter
    private lateinit var adapter: ClassementAdapter
    private lateinit var item : Main

    private var idMatch : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classement)

        val intent = intent
        idMatch = intent.getStringExtra("idLeague")

        val request = ApiRepository()
        val gson = Gson()
        presenter = ClassementPresenter(this, request, gson)
        presenter.getClassement(idMatch)

        adapter = ClassementAdapter(matches)
        val rvClassement = findViewById<RecyclerView>(R.id.rv_classement)
        rvClassement.layoutManager = LinearLayoutManager(applicationContext)
        rvClassement.adapter = adapter
    }

    override fun showClassement(data: List<Main>) {
        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()

    }
}
