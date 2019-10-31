package com.example.submission5.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.submission5.favorite.match.FavoriteMatch
import com.example.submission5.favorite.team.FavoriteTeam
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Favorite.db", null, 1){

    companion object{
        private var instance : MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context):MyDatabaseOpenHelper{
            if (instance==null){
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        //membuat table
        db.createTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true,
            FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteMatch.ID_EVENT to TEXT + UNIQUE,
            FavoriteMatch.NAME_HOME to TEXT,
            FavoriteMatch.NAME_AWAY to TEXT,
            FavoriteMatch.SCORE_HOME to TEXT,
            FavoriteMatch.SCORE_AWAY to TEXT,
            FavoriteMatch.DATE_MATCH to TEXT

            )

        db.createTable(FavoriteTeam.TABLE_FAVORITE_TEAM, true,
            FavoriteTeam.ID_F_TEAM to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteTeam.ID_TEAM to TEXT + UNIQUE,
            FavoriteTeam.NAME_TEAM to TEXT,
            FavoriteTeam.TEAM_BADGE to TEXT)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true)

        db.dropTable(FavoriteTeam.TABLE_FAVORITE_TEAM, true)
    }

}

val Context.database : MyDatabaseOpenHelper
get() = MyDatabaseOpenHelper.getInstance(applicationContext)