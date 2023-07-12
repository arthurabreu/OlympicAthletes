package com.arthurabreu.olympicathletes.data

import com.google.gson.annotations.SerializedName

data class Athlete(
    @SerializedName("athlete_id")
    val athleteID: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("dateOfBirth")
    val dob: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("photo_id")
    val photoID: Long,
    @SerializedName("weight")
    val weight: String,
    @SerializedName("height")
    val height: String,
    var image: String? = null
) {
    var score: Int = 0
}
