package com.arthurabreu.olympicathletes.network

import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.data.Game
import retrofit2.http.GET
import retrofit2.http.Path

interface OlympicServices {

    @GET("games")
    suspend fun getGames(): List<Game>

    @GET("games/{id}/athletes")
    suspend fun getGamesAthletes(@Path("id") id: Int): List<Athlete>
}