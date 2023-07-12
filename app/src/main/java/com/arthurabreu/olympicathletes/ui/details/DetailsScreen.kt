package com.arthurabreu.olympicathletes.ui.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arthurabreu.olympicathletes.R
import com.arthurabreu.olympicathletes.navigation.NavScreen
import com.arthurabreu.olympicathletes.ui.components.AthleteDetails
import com.arthurabreu.olympicathletes.ui.components.BioDetails
import com.arthurabreu.olympicathletes.ui.components.MedalRow
import com.arthurabreu.olympicathletes.ui.components.ProgressBar
import java.net.URLDecoder

@Composable
fun DetailsScreen(
    athleteId: String,
    athleteName: String,
    imageUrl: String,
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val athlete = viewModel.athlete.collectAsState()
    val results = viewModel.athleteResults.collectAsState()

    val decodedUrl = URLDecoder.decode(imageUrl, "utf-8")

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(30.dp)
    ) {
        if (athlete.value != null && results.value.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    AthleteDetails(athlete = athlete.value!!, imageUrl = decodedUrl)
                    Spacer(modifier = Modifier.height(30.dp))
                }
                item {
                    Text(
                        text = stringResource(id = R.string.medals),
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(results.value.size) {index ->
                    val result = results.value[index]
                    if (result.gold != 0 || result.silver != 0 || result.bronze != 0) {
                        Spacer(modifier = Modifier.height(5.dp))
                        MedalRow(result)
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                    BioDetails(athlete.value!!.bio)
                }
            }
        } else {
            ProgressBar(modifier = Modifier.align(Alignment.Center))
        }
    }

    BackHandler(true) {
        navController.navigate(NavScreen.HomeScreen.route)
    }
}