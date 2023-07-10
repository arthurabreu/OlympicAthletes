package com.arthurabreu.olympicathletes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arthurabreu.olympicathletes.R

@Preview
@Composable
fun MedalDetails() {
    Column() {
        Text(
            text = stringResource(id = R.string.medals),
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Left,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(5.dp))
        MedalRow()
        Spacer(modifier = Modifier.height(5.dp))
        MedalRow()
        Spacer(modifier = Modifier.height(5.dp))
        MedalRow()
        Spacer(modifier = Modifier.height(5.dp))
        MedalRow()
    }
}

@Preview
@Composable
fun MedalRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "\u2022 London",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(top = 14.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "3",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.gold),
            contentDescription = stringResource(
                id = R.string.gold
            ),
            modifier = Modifier.padding(top = 4.dp).size(40.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "4",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.silver),
            contentDescription = stringResource(
                id = R.string.silver
            ),
            modifier = Modifier.padding(top = 4.dp).size(40.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "6",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bronze),
            contentDescription = stringResource(
                id = R.string.bronze
            ),
            modifier = Modifier.padding(top = 4.dp).size(40.dp)
        )
    }
}