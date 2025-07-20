package com.familyflavours.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.familyflavours.R
import com.familyflavours.ui.components.HeaderWithTitle
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.ui.viewmodel.UIStateViewModel


@Composable
fun AboutUsScreen(navController: NavController, uiStateViewModel: UIStateViewModel) {

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


    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderWithTitle(stringResource(R.string.aboutus)) {
            onBackClick()
        }

        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(25.dp),
                    text = stringResource(R.string.aboutus_content),
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black
                )

            }
        }
    }
}
