package com.arthurabreu.olympicathletes.data

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("game_id")
    val gameId: Int,
    @SerializedName("city")
    val city: String,
    @SerializedName("year")
    val year: Long
)
