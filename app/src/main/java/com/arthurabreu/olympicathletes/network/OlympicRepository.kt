package com.arthurabreu.olympicathletes.network

import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.data.Game

class OlympicRepository {

    private val service = RetrofitInstance.olympicServices

    suspend fun getGames(): List<Game> {
        return service.getGames()
    }

    suspend fun getGamesAthletes(id: Int): List<Athlete> {
        return service.getGamesAthletes(id)
    }
}