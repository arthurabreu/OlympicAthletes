package com.arthurabreu.olympicathletes.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arthurabreu.olympicathletes.ui.components.GamesSection
import com.arthurabreu.olympicathletes.ui.components.ProgressBar

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val participations = viewModel.participation.collectAsState()

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        if (participations.value.isEmpty()) {
            ProgressBar(modifier = Modifier.align(Alignment.Center))
        } else {
            Column {
                GamesSection(
                    participations.value,
                    navController
                )
            }
        }
    }
}