package com.familyflavours.ui.screens

import androidx.compose.runtime.Composable

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.familyflavours.R
import com.familyflavours.ui.components.HeaderWithTitle
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.ui.viewmodel.UIStateViewModel


@Composable
fun DeleteAccountScreen(navController: NavController, uiStateViewModel: UIStateViewModel) {

    var text = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

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
        HeaderWithTitle(stringResource(R.string.delete_account)) {
            onBackClick()
        }
        Spacer(Modifier.height(10.dp))
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 25.dp),
            ) {
                Text(
                    text = stringResource(R.string.delete_my_account),
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = stringResource(R.string.why_would_you_like_to_delete_my_account),
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(Modifier.height(25.dp))



                OutlinedTextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    placeholder = { Text("Type something...") },
                    textStyle = TextStyle(fontSize = 16.sp),
                    maxLines = 5,
                    singleLine = false,
                    shape = MaterialTheme.shapes.small
                )

                Spacer(Modifier.height(25.dp))

                Button(
                    onClick = {
                        focusManager.clearFocus()
                        // signupViewModel.validateFields()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
                ) {
                    Text(
                        text = stringResource(R.string.delete_account).uppercase(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }

            }
        }
    }
}
