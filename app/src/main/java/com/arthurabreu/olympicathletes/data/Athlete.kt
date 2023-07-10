package com.arthurabreu.olympicathletes.data

import androidx.annotation.DrawableRes

data class Athlete(
    val id: Int,
    val name: String,
    @DrawableRes val picture: Int?,
    val dob: String,
    val weight: String,
    val height: String
)
