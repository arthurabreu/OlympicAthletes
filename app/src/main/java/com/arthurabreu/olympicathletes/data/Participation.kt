package com.arthurabreu.olympicathletes.data

data class Participation(
    val year: Long,
    val name: String,
    val athletes: List<Athlete>
)
