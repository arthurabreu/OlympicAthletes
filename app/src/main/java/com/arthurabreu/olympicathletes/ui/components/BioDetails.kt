package com.arthurabreu.olympicathletes.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arthurabreu.olympicathletes.R

@Preview
@Composable
fun BioDetails() {
    Column() {
        Text(
            text = stringResource(id = R.string.bio),
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier
        )
        Text(
            text = stringResource(id = R.string.bio),
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(top = 14.dp)
        )
    }
}