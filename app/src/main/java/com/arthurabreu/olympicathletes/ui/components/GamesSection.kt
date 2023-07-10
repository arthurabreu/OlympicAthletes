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
import com.arthurabreu.olympicathletes.data.GameAthletes

@Composable
fun GamesSection(
    games: List<GameAthletes>,
) {
    LazyColumn {
        items(games.size) {
            GameItem(games[it])
        }
    }
}

@Composable
fun GameItem(
    game: GameAthletes
) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
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
        AthletesSection(game.athletes)
    }
}