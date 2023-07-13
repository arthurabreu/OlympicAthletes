package com.arthurabreu.olympicathletes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arthurabreu.olympicathletes.ui.details.DetailsScreen
import com.arthurabreu.olympicathletes.ui.home.HomeScreen

@Composable
fun AppNavigator(navController: NavController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = NavScreen.HomeScreen.route
    ) {
        composable(route = NavScreen.HomeScreen.route) {
            HomeScreen(paddingValues = paddingValues, navController)
        }
        composable(
            route = NavScreen.DetailsScreen.route +
                    "/{athlete_details_id}/{athlete_image_url}/{athlete_name}",
            arguments = listOf(
                navArgument("athlete_details_id") {
                    type = NavType.StringType
                },
                navArgument("athlete_image_url") {
                    type = NavType.StringType
                },
                navArgument("athlete_name") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailsScreen(
                paddingValues = paddingValues,
                athleteId = entry.arguments?.getString("athlete_details_id").toString(),
                imageUrl = entry.arguments?.getString("athlete_image_url").toString(),
                athleteName = entry.arguments?.getString("athlete_name").toString(),
                navController = navController
            )
        }
    }
}