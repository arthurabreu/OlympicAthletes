package com.arthurabreu.olympicathletes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arthurabreu.olympicathletes.R
import com.arthurabreu.olympicathletes.data.Athlete
import com.arthurabreu.olympicathletes.ui.theme.OlympicGold

@Composable
fun AthleteDetails(
    athlete: Athlete
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.user),
                error = painterResource(R.drawable.user),
                contentDescription = stringResource(R.string.athlete_picture),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RectangleShape)
                    .border(border = BorderStroke(2.dp, OlympicGold))
            )
            AthleteInfo(athlete)
        }
    }
}

@Composable
fun AthleteInfo(athlete: Athlete) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        TextInfo(text = textInfoStyle(R.string.name, athlete.name))
        TextInfo(text = textInfoStyle(R.string.dob, athlete.dob))
        TextInfo(text = textInfoStyle(R.string.weight, athlete.weight))
        TextInfo(text = textInfoStyle(R.string.height, athlete.height))
    }
}

@Composable
fun TextInfo(
    text: AnnotatedString
) {
    Text(
        text = text,
        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
        fontSize = 18.sp,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 16.dp, top = 5.dp, bottom = 5.dp)
    )
}

@Composable
private fun textInfoStyle(
    prefix: Int,
    data: String
): AnnotatedString {
    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
    val normalStyle = SpanStyle(fontWeight = FontWeight.Normal)

    val stringRes = stringResource(id = prefix)

    return buildAnnotatedString {
        withStyle(style = boldStyle) {
            append(stringRes)
        }
        append(": ")
        withStyle(style = normalStyle) {
            append(data)
        }
    }
}