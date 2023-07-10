package com.arthurabreu.olympicathletes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.arthurabreu.olympicathletes.R
import com.arthurabreu.olympicathletes.ui.theme.OlympicBlack
import com.arthurabreu.olympicathletes.ui.theme.OlympicBlue
import com.arthurabreu.olympicathletes.ui.theme.OlympicGold
import com.arthurabreu.olympicathletes.ui.theme.OlympicGreen
import com.arthurabreu.olympicathletes.ui.theme.OlympicRed

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppBar() {
    Surface(
        tonalElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val (image, text) = createRefs()

                        Image(
                            painter = painterResource(id = R.drawable.ic_logo),
                            contentDescription = stringResource(id = R.string.app_logo),
                            modifier = Modifier
                                .constrainAs(image) {
                                    start.linkTo(parent.start)
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                }
                                .padding(start = 4.dp)
                        )

                        Text(
                            text = stringResource(id = R.string.app_name),
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
            OlympicDivider()
        }
    }
}

@Preview
@Composable
fun OlympicDivider() {
    val olympicColors = listOf(
        OlympicBlue,
        OlympicBlack,
        OlympicGold,
        OlympicGreen,
        OlympicRed
    )
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)) {
        olympicColors.forEach { color ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color),
                contentAlignment = Alignment.Center
            ){}
        }
    }
}