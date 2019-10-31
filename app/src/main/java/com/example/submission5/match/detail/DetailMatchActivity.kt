package com.example.submission5.match.detail

import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.example.submission5.R
import com.example.submission5.api.ApiRepository
import com.example.submission5.favorite.match.FavoriteMatch
import com.example.submission5.helper.database
import com.example.submission5.model.Main
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.find

class DetailMatchActivity : AppCompatActivity(), DetaiMatchView {

    private lateinit var presenter: DetailMatchPresenter
    private lateinit var item : Main

    private var idMatch : String = ""
    private var idHome : String = ""
    private var idAway : String = ""

    private var menuItem : Menu? = null
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val intent = intent
        idMatch = intent.getStringExtra("idMatch")
        idHome = intent.getStringExtra("nameHome")
        idAway = intent.getStringExtra("nameAway")

        favoriteState()

        val request = ApiRepository()
        val gson = Gson()
        presenter = DetailMatchPresenter(this,request,gson)
        presenter.getMatchDetail(idMatch)
        presenter.getHomeBadge(idHome)
        presenter.getAwayBadge(idAway)
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
                insert(FavoriteMatch.TABLE_FAVORITE_MATCH,
                    FavoriteMatch.ID_EVENT to item.idEvent,
                    FavoriteMatch.NAME_HOME to item.strHomeTeam,
                    FavoriteMatch.NAME_AWAY to item.strAwayTeam,
                    FavoriteMatch.SCORE_HOME to item.intHomeScore,
                    FavoriteMatch.SCORE_AWAY to item.intAwayScore,
                    FavoriteMatch.DATE_MATCH to item.dateEvent)
            }
            Snackbar.make(view,"add to favorite", Snackbar.LENGTH_LONG).show()
        }catch (e : SQLiteConstraintException){
            Snackbar.make(view,e.localizedMessage, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun removeFromFavorite(){
        try{
            database.use {
                delete(FavoriteMatch.TABLE_FAVORITE_MATCH, "ID_EVENT = {idMatch}",
                    "idMatch" to idMatch)
            }
            Snackbar.make(view,"add to favorite", Snackbar.LENGTH_LONG).show()
        }catch (e : SQLiteConstraintException){
            Snackbar.make(view,e.localizedMessage, Snackbar.LENGTH_LONG).show()
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
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
                .whereArgs("(ID_EVENT = {idMatch})",
                    "idMatch" to idMatch)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun showDetail(data: List<Main>) {
        item = Main(
            data[0].idEvent,
            data[0].strHomeTeam,
            data[0].strAwayTeam,
            data[0].intHomeScore,
            data[0].intAwayScore,
            data[0].dateEvent,
            data[0].strHomeFormation,
            data[0].strAwayFormation,
            data[0].strAwayGoalDetails,
            data[0].strHomeYellowCards,
            data[0].pointTeam,
            data[0].win,
            data[0].draw,
            data[0].lose,
            data[0].play,
            data[0].strAwayYellowCards,
            data[0].strHomeRedCards,
            data[0].strAwayRedCards,
            data[0].strHomeGoalDetails
        )

        val homeTeam = findViewById<TextView>(R.id.tv_detail_home_name)
        val awayTeam = findViewById<TextView>(R.id.tv_detail_away_name)
        val scoreHome = findViewById<TextView>(R.id.tv_detail_home_score)
        val scoreAway = findViewById<TextView>(R.id.tv_detail_away_score)
        val date = findViewById<TextView>(R.id.tv_detail_date)
        val homeFormation = findViewById<TextView>(R.id.tv_home_formation)
        val awayFormation = findViewById<TextView>(R.id.tv_away_formation)
        val homeGoal = findViewById<TextView>(R.id.tv_home_goal)
        val awayGoal = findViewById<TextView>(R.id.tv_away_goal)
        val homeYellow = findViewById<TextView>(R.id.tv_home_yellow)
        val awayYellow = findViewById<TextView>(R.id.tv_away_yellow)
        val homeRed = findViewById<TextView>(R.id.tv_home_red)
        val awayRed = findViewById<TextView>(R.id.tv_away_red)

        homeTeam.text = data[0].strHomeTeam
        awayTeam.text = data[0].strAwayTeam
        scoreHome.text = data[0].intHomeScore.toString()
        scoreAway.text = data[0].intAwayScore.toString()
        date.text = data[0].dateEvent
        homeFormation.text = data[0].strHomeFormation
        awayFormation.text = data[0].strAwayFormation
        homeGoal.text = data[0].strHomeGoalDetails
        awayGoal.text = data[0].strAwayGoalDetails
        homeYellow.text = data[0].strHomeYellowCards
        awayYellow.text = data[0].strAwayYellowCards
        homeRed.text = data[0].strHomeRedCards
        awayRed.text = data[0].strAwayRedCards
    }

    override fun showHomeBadge(data: List<Main>) {
        val homeBadge = find<ImageView>(R.id.iv_home_team)
        Picasso.get().load(data[0].teamBadge).into(homeBadge)
    }

    override fun showAwayBadge(data: List<Main>) {
        val awayBadge = find<ImageView>(R.id.iv_away_team)
        Picasso.get().load(data[0].teamBadge).into(awayBadge)
    }
}
