package com.arthurabreu.olympicathletes.ui.components

import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.arthurabreu.olympicathletes.R
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

@Composable
fun BioDetails(bio: String) {
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
        MarkdownView(bio)
    }
}

@Composable
fun MarkdownView(markdownContent: String) {
    val parser = Parser.builder().build()
    val document = parser.parse(markdownContent)
    val renderer = HtmlRenderer.builder().build()

    val isLight = isSystemInDarkTheme().not()
    val backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    val textColor = if (isSystemInDarkTheme()) "#FFFFFF" else "#000000"
    val htmlContent = """
        <html>
            <head>
                <style>
                    body {
                        background-color: $backgroundColor;
                        color: $textColor;
                    }
                </style>
            </head>
            <body>
                ${renderer.render(document)}
            </body>
        </html>
    """.trimIndent()

    AndroidView(factory = { context ->
        WebView(context).apply {
            webViewClient = WebViewClient()
            setBackgroundColor(android.graphics.Color.parseColor(if (isLight) "#FFFFFF" else "#000000"))
            settings.apply {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
                defaultTextEncodingName = "UTF-8"
                layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
            }
        }
    }, update = { webView ->
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null)
    })
}