package com.familyflavours.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun SecondaryButton(buttonText: String, modifier: Modifier, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp,color= Color.Blue)
            .clip(RectangleShape)
            .background(color = Color.Transparent)
            .padding(5.dp)
            .clickable(
                interactionSource = interactionSource, indication = ripple(
                    color = Color.Gray,
                    bounded = false,
                    radius = 100.dp
                )
            ) { onClick.invoke() }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText.uppercase(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Blue,
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun SecondaryButtonPreview() {
    SecondaryButton(
        buttonText = "Add To Cart", modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {

    }
}