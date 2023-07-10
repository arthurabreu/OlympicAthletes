package com.arthurabreu.olympicathletes.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.data.GameAthletes
import com.arthurabreu.olympicathletes.ui.components.GamesSection

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        Column {
            GamesSection(
                list(),
                navController
            )
        }
    }
}

private fun list(): List<GameAthletes> {
    return listOf(
        GameAthletes(
            name = "Rio de Janeiro 2016",
            athletes = listOf(
                Athlete(1, "Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", "")
            )
        ),
        GameAthletes(
            name = "Tokyo 2020",
            athletes = listOf(
                Athlete(1, "Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", "")
            )
        ),
        GameAthletes(
            name = "Tokyo 2020",
            athletes = listOf(
                Athlete(1, "Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", "")
            )
        ),
        GameAthletes(
            name = "Tokyo 2020",
            athletes = listOf(
                Athlete(1, "Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", "")
            )
        ),
        GameAthletes(
            name = "Tokyo 2020",
            athletes = listOf(
                Athlete(1, "Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", ""),
                Athlete(1,"Michael Phelps", null, "", "", "")
        ),
        )
    )
}