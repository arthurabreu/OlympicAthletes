package com.arthurabreu.olympicathletes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.arthurabreu.olympicathletes.navigation.AppNavigator
import com.arthurabreu.olympicathletes.ui.components.AppBar
import com.arthurabreu.olympicathletes.ui.theme.OlympicAthletesTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OlympicAthletesTheme {
                val navController = rememberNavController()
                Scaffold (
                    topBar = {
                        AppBar(navController)
                    }
                ) {
                    AppNavigator(navController, it)
                }
            }
        }
    }
}