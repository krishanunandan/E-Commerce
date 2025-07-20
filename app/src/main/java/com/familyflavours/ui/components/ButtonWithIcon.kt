package com.familyflavours.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun ButtonWithIcon(buttonText: String, icon: ImageVector, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth().height(50.dp)
            .padding(horizontal = 20.dp, vertical = 3.dp)
            .clickable{ onClick.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularButton(
            icon,
            size = 40.dp,
            color = Color.White, onClick = {}
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = buttonText,
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            fontSize = 16.sp
        )
    }
}