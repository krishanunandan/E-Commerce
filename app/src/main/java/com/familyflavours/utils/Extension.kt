package com.familyflavours.utils

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsCompat


fun String.underlined(): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(this@underlined)
        }
    }
}

@Composable
fun getScreenHeightPercentage(percentage: Float): Dp {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    return screenHeight * (percentage / 100)
}

@Composable
fun WindowInsetsCompat.navBarHeight(): Dp {
    return with(LocalDensity.current) {
        this@navBarHeight.getInsets(WindowInsetsCompat.Type.systemBars()).bottom.toDp()
    }
}


fun Context.shareApp() {
    val appPackageName = packageName
    val appLink = "https://play.google.com/store/apps/details?id=$appPackageName"
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Check out this app!")
        putExtra(Intent.EXTRA_TEXT, "I found this awesome app, check it out:\n$appLink")
    }
    startActivity(Intent.createChooser(shareIntent, "Share via"))
}