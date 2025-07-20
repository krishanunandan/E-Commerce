package com.familyflavours.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.familyflavours.R


@Composable
fun HeaderWithMenus(onSearchClick: () -> Unit, onNotificationClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.White)
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.logo_dummy),
            contentDescription = "Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(200.dp)
                .width(50.dp)
                .padding(1.dp)
        )

        Text(text = "", modifier = Modifier.weight(1f))

        CircularButton(icon = Icons.Rounded.Search, onClick = {onSearchClick.invoke() })
        Spacer(modifier = Modifier.width(2.dp))
        CircularButton(icon = Icons.Rounded.Notifications, onClick = {onNotificationClick.invoke() })

       /* Icon(imageVector = Icons.Rounded.Search,
            contentDescription = "Back Button",
            tint = Color.Blue,
            modifier = Modifier
                .height(55.dp)
                .width(55.dp)
                .padding(10.dp)
                .clickable {
                    onSearchClick.invoke()
                })

        Icon(imageVector = Icons.Rounded.Notifications,
            contentDescription = "Back Button",
            tint = Color.Blue,
            modifier = Modifier
                .height(55.dp)
                .width(55.dp)
                .padding(10.dp)
                .clickable {
                    onNotificationClick.invoke()
                })*/
    }
}

@Preview
@Composable
fun HeaderWithMenusPreview() {
    HeaderWithMenus(onSearchClick = {}, onNotificationClick = {})
}