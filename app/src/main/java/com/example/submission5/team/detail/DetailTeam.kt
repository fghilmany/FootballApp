package com.example.submission5.team.detail

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.favorite.team.FavoriteTeam
import com.example.submission5.helper.database
import com.example.submission5.model.Main
import com.example.submission5.model.Team
import com.example.submission5.team.TeamPresenter
import com.example.submission5.team.TeamView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class DetailTeam : AppCompatActivity(),TeamView {
    override fun listTeam(data: List<Main>) {

    }

    private lateinit var presenter: TeamPresenter
    private lateinit var item : Team

    private var idTeam :String = ""

    private var menuItem : Menu? = null
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        val intent = intent
        idTeam = intent.getStringExtra("idTeam")

        favoriteState()

        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamPresenter(this,request,gson)
        presenter.getDetailTeams(idTeam)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.home -> {
                finish()
                true
            }

            R.id.add_to_favorite -> {
                if (isFavorite) removeFromFavorite() else addToFavorite()

                isFavorite = !isFavorite
                setFavorite()
                true
            }

            else-> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite(){
        try{
            database.use {
                insert(
                    FavoriteTeam.TABLE_FAVORITE_TEAM,
                    FavoriteTeam.ID_TEAM to item.idTeam,
                    FavoriteTeam.NAME_TEAM to item.teamName,
                    FavoriteTeam.TEAM_BADGE to item.teamBadge)
            }
            Toast.makeText(applicationContext,"add to favorite",Toast.LENGTH_SHORT).show()
        }catch (e : SQLiteConstraintException){
            Toast.makeText(applicationContext,e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun removeFromFavorite(){
        try{
            database.use {
                delete(
                    FavoriteTeam.TABLE_FAVORITE_TEAM, "ID_TEAM = {idTeam}",
                    "idTeam" to idTeam)
            }
            Toast.makeText(applicationContext,"remove from favorite",Toast.LENGTH_SHORT).show()
        }catch (e : SQLiteConstraintException){
            Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_SHORT).show()
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    private fun favoriteState(){
        database.use {
            val result = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
                .whereArgs("(ID_TEAM = {idTeam})",
                    "idTeam" to idTeam)
            val favorite = result.parseList(classParser<FavoriteTeam>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun detailTeam(data: List<Team>) {

        item = Team(
            data[0].idTeam,
            data[0].teamName,
            data[0].teamBadge,
            data[0].descTeam
        )

        val nameTeam = findViewById<TextView>(R.id.tv_detail_name_team)
        nameTeam.text = data[0].teamName

        val teamBadge = findViewById<ImageView>(R.id.iv_detail_logo_team)
        Picasso.get().load(data[0].teamBadge).into(teamBadge)

        val descTeam = findViewById<TextView>(R.id.tv_desc_team)
        descTeam.text = data[0].descTeam

    }
}
