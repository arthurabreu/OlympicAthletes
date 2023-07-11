package com.arthurabreu.olympicathletes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arthurabreu.olympicathletes.R
import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.navigation.NavScreen
import java.net.URLEncoder

@Composable
fun AthletesSection(
    athletes: List<Athlete>,
    navController: NavController
) {
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth()
    ) {
        items(athletes.size) {
            AthletesItem(athletes[it], navController)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun AthletesItem(
    athlete: Athlete,
    navController: NavController
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .clickable {
                val id = athlete.athleteID.toString()
                val image = URLEncoder.encode(athlete.image.toString(), "utf-8")
                navController.navigate(NavScreen.DetailsScreen.withArgs(id, image))
            }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(athlete.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.user),
            error = painterResource(R.drawable.user),
            contentDescription = stringResource(R.string.athlete_picture),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RectangleShape)
                .border(border = BorderStroke(1.dp, Color.Black))
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        ) {
            Text(
                text = athlete.name + " " + athlete.surname,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(start = 5.dp, end = 5.dp)
            )
        }
    }
}