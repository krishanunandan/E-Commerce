package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun HeaderWithTitle(title: String, onBackClick: () -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(horizontal = 5.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            CircularButton(
                icon = Icons.Rounded.ArrowBackIosNew,
                onClick = { onBackClick() }
            )
            Text(
                text = title,
                modifier = Modifier.align(Alignment.Center),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}