package com.arthurabreu.olympicathletes.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arthurabreu.olympicathletes.data.Participation

@Composable
fun GamesSection(
    games: List<Participation>,
    navController: NavController
) {
    LazyColumn {
        items(games.size) {
            GameItem(games[it], navController)
        }
    }
}

@Composable
fun GameItem(
    game: Participation,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        if (game.athletes.isNotEmpty()) {
            Text(
                text = game.name,
                textAlign = TextAlign.Left,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 4.dp)
            )
            AthletesSection(game.athletes, navController)
        }
    }
}