package com.arthurabreu.olympicathletes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import com.arthurabreu.olympicathletes.ui.details.DetailsScreen
import com.arthurabreu.olympicathletes.ui.home.AppBar
import com.arthurabreu.olympicathletes.ui.theme.OlympicAthletesTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlympicAthletesTheme {
                Scaffold (
                    topBar = { AppBar() }
                ) {
//                    HomeScreen(it)
                    DetailsScreen(it)
                }
            }
        }
    }
}