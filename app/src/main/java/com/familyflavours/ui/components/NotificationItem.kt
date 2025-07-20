package com.familyflavours.ui.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.models.NotificationData
import com.familyflavours.ui.theme.Gray
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun NotificationItem(notificationData: NotificationData) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Icon(
                imageVector = Icons.Filled.NotificationsOff,
                contentDescription = "Notification Type Icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier=Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                Text(
                    text = notificationData.title,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = notificationData.message,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = notificationData.createdOn,
            modifier = Modifier.align(Alignment.End),
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Gray
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
fun NotificationItemPreview() {
    NotificationItem(
        notificationData = NotificationData(
            1,
            "A",
            "Alert Notification",
            "This is a demo notification text message.",
            "03/04/2025"
        )
    )
}