package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Payment
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Support
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.theme.LightWhite

@Composable
fun ProfileActionTools(navController: NavController) {
    Card(
        colors = CardDefaults.cardColors(containerColor = LightWhite),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircularButton(
                icon = Icons.Rounded.Edit,
                onClick = { navController.navigate(Routes.UpdateProfile.route) },
                color = Color.White
            )
            CircularButton(icon = Icons.Rounded.Settings, onClick = { }, color = Color.White)
            CircularButton(icon = Icons.Rounded.Support, onClick = { }, color = Color.White)
            CircularButton(icon = Icons.Rounded.Payment, onClick = { }, color = Color.White)
        }
    }
}