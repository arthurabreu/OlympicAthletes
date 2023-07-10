package com.arthurabreu.olympicathletes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arthurabreu.olympicathletes.ui.details.DetailsScreen
import com.arthurabreu.olympicathletes.ui.home.HomeScreen

@Composable
fun AppNavigator(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.HomeScreen.route) {
        composable(route = NavScreen.HomeScreen.route) {
            HomeScreen(paddingValues = paddingValues, navController)
        }
        composable(
            route = NavScreen.DetailsScreen.route + "/{athlete_details_id}",
            arguments = listOf(
                navArgument("athlete_details_id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailsScreen(
                paddingValues = paddingValues,
                athleteId = entry.arguments?.getString("athlete_details_id").toString(),
                navController = navController
            )
        }
    }
}