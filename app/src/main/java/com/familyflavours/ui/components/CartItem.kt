package com.familyflavours.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.familyflavours.R
import com.familyflavours.ui.models.CartData
import com.familyflavours.ui.theme.Gray
import com.familyflavours.ui.theme.robotoFontFamily


@Composable
fun CartItem(
    cartData: CartData,
    onClickPlus: (CartData) -> Unit,
    onClickMinus: (CartData) -> Unit,
    onClickDelete: (CartData) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Image(
                painter = rememberImagePainter(data = cartData.imageUrl),
                contentDescription = "Notification Type Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp)
            ) {
                Text(
                    text = cartData.name,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(R.string.unit_with_colon) + cartData.unit,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(R.string.price_with_colon) + stringResource(R.string.rs) + cartData.price,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            CircularButton(
                icon = Icons.Rounded.Delete,
                onClick = { onClickDelete.invoke(cartData) })
        }
        Box(modifier = Modifier.align(Alignment.End)) {
            CartItemPlusMinusButton(
                quantity = cartData.quantity,
                onClickPlus = { onClickPlus.invoke(cartData) },
                onClickMinus = { onClickMinus.invoke(cartData) })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.rs) + "${cartData.totalPrice}  ",
            modifier = Modifier.align(Alignment.End),
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Gray
        )
    }
}

@Preview
@Composable
fun CartItemPreview() {
    CartItem(
        cartData = CartData(
            1,
            "A",
            "100g",
            10.00,
            10.00,
            "https://picsum.photos/200/300"
        ), onClickPlus = {}, onClickMinus = {}, onClickDelete = {}
    )
}