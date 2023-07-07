package com.arthurabreu.olympicathletes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.arthurabreu.olympicathletes.R

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(paddingValues)
    ) {
        Column {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Surface(
        tonalElevation = 8.dp
    ) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (image, text, divider) = createRefs()

                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .constrainAs(image) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(start = 4.dp)
                    )

                    Text(
                        text = "Olympic Athletes",
                        textAlign = TextAlign.Center,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        modifier = Modifier
                            .constrainAs(text) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    )
                }
            }
        )
    }
}