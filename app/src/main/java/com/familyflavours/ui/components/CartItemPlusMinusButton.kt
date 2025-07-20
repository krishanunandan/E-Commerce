package com.familyflavours.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.theme.robotoFontFamily


@Composable
fun CartItemPlusMinusButton(quantity: Int, onClickPlus: () -> Unit, onClickMinus: () -> Unit) {
    Box(
        modifier = Modifier
            .size(150.dp, 60.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Transparent)
            .border(1.dp, Color.LightGray, RoundedCornerShape(25.dp))
            .padding(10.dp)


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            CircularButton(icon = Icons.Rounded.Remove, onClick = { onClickMinus.invoke()}, size = 50.dp)
            Text(
                modifier =Modifier.padding(2.dp),
                text = "$quantity",
                color = Color.Blue,
                fontFamily = robotoFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            CircularButton(icon = Icons.Rounded.Add, onClick = {onClickPlus.invoke() }, size = 50.dp)

        }
    }
}

@Preview
@Composable
fun CartItemPlusMinusButtonPreview() {
    CartItemPlusMinusButton(1, onClickPlus = {}, onClickMinus = {})
}