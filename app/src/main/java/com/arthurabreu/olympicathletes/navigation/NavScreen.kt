package com.arthurabreu.olympicathletes.navigation

sealed class NavScreen(val route: String) {
    object HomeScreen: NavScreen("home_screen")
    object DetailsScreen: NavScreen("details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
