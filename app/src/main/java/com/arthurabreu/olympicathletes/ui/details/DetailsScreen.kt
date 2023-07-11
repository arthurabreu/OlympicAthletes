package com.arthurabreu.olympicathletes.ui.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arthurabreu.olympicathletes.R
import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.navigation.NavScreen
import com.arthurabreu.olympicathletes.ui.components.AthleteDetails
import com.arthurabreu.olympicathletes.ui.components.BioDetails
import com.arthurabreu.olympicathletes.ui.components.MedalDetails

@Composable
fun DetailsScreen(
    athleteId: String,
    paddingValues: PaddingValues,
    navController: NavController
) {
    BackHandler(true) {
        navController.navigate(NavScreen.HomeScreen.route)
    }
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
//            AthleteDetails(Athlete(
//                0,
//                "Michael Phelps",
//                R.drawable.user,
//                "28/12/1989",
//                "100kg",
//                "192cm"
//            ))
            Spacer(modifier = Modifier.height(30.dp))
            MedalDetails()
            Spacer(modifier = Modifier.height(30.dp))
            BioDetails()
        }
    }
}