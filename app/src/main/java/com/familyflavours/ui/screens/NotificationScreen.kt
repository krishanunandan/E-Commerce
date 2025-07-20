package com.familyflavours.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.familyflavours.R
import com.familyflavours.ui.components.CircularButton
import com.familyflavours.ui.components.NotificationItem
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.ui.viewmodel.UIStateViewModel
import com.familyflavours.utils.DummyData.getNotificationList

@Composable
fun NotificationScreen(navController: NavController, uiStateViewModel: UIStateViewModel) {

    LaunchedEffect(Unit) {
        uiStateViewModel.hideTopBar()
        uiStateViewModel.hideBottomBar()
    }

    fun onBackClick() {
        uiStateViewModel.showTopBar()
        uiStateViewModel.showBottomBar()
        navController.popBackStack()
    }
    BackHandler {
        onBackClick()
    }

    Column() {
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(horizontal = 5.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            CircularButton(
                icon = Icons.Rounded.ArrowBackIosNew,
                onClick = { onBackClick() }
            )
            Text(
                text = stringResource(R.string.notifications),
                modifier=Modifier.align(Alignment.Center),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign= TextAlign.Center,
                color = Color.Black,
                fontSize = 18.sp
            )

        }

        LazyColumn {
            itemsIndexed(getNotificationList()) { index, item ->
                NotificationItem(notificationData = item)
            }
        }
    }
}