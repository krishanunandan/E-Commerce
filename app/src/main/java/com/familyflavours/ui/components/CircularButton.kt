package com.familyflavours.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    size: Dp = 56.dp, // Size of the circle
    color: Color = Color.Transparent // Color of the circle
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .size(size) // Set the size of the circular button
            .clip(CircleShape) // Clip the box to be circular
            .background(color) // Background color of the circle
            .clickable(
                interactionSource = interactionSource, indication = ripple(
                    color = Color.Gray,
                    bounded = true,
                    radius = 24.dp
                )
            ) { onClick() }, contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color.Blue,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(10.dp)
        )
    }
}
