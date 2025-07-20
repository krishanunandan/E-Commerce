package com.familyflavours.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun ButtonWithDropDownIcon(
    buttonText: String,
    selectedValue: Int,
    onClick: () -> Unit,
    leadingIcon: ImageVector,
    isSelected: Boolean = false,
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Blue else Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp).clickable {
                onClick.invoke()
            }
    ) {
        Row {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "Leading Icon",
                tint = if (isSelected) Color.Blue else Color.LightGray
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text = if (selectedValue>0) "$buttonText($selectedValue)" else buttonText,
                color = if (isSelected) Color.Blue else Color.LightGray,
                fontFamily = robotoFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Trailing Icon",
                tint = if (isSelected) Color.Blue else Color.LightGray
            )
        }
    }
}

@Preview
@Composable
fun ButtonWithDropDownIconPreview() {
    ButtonWithDropDownIcon(
        "Filter",
        0,
        onClick = {},
        Icons.Default.FilterList,
        false
    )
}