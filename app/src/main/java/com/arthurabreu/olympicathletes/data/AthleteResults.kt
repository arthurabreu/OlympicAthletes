package com.arthurabreu.olympicathletes.data

import com.google.gson.annotations.SerializedName

data class AthleteResults(
    @SerializedName("city")
    val city: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("gold")
    val gold: Int,
    @SerializedName("silver")
    val silver: Int,
    @SerializedName("bronze")
    val bronze: Int
)
