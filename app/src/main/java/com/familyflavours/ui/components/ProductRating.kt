package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.familyflavours.ui.theme.robotoFontFamily


@Composable
fun ProductRating(brandName: String, rating: Float, ratingCount: Int) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = brandName,
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.width(2.dp))
        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = Icons.Default.Star,
            contentDescription = "Rating",
            tint = Color.Yellow
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = "$rating",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = "($ratingCount)",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
fun ProductRatingPreview() {
    ProductRating("FF",rating = 4.5f, ratingCount = 75)
}