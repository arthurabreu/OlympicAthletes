package com.arthurabreu.olympicathletes.data

import androidx.annotation.DrawableRes

data class Athlete(
    val name: String,
    @DrawableRes val picture: Int?
)
