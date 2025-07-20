package com.familyflavours.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.familyflavours.R
import com.familyflavours.ui.components.TextField
import com.familyflavours.ui.dialog.AlertMessageDialog
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.viewmodel.LoginViewModel


@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current

    val focusManager = LocalFocusManager.current


    val dialogMessage = remember { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertMessageDialog(message = dialogMessage.value, setShowDialog = {
            showDialog.value = it
        }, onConfirmation = {
            navController.navigate(Routes.Home.route)
        }, "OK")
    }

    Box {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = loginViewModel.emailValue.value,
                onChange = loginViewModel::setEmail,
                placeholder = stringResource(R.string.email),
                isError = loginViewModel.emailError.value.isNotEmpty(),
                icon = Icons.Rounded.Email,
                errorMessage = loginViewModel.emailError.value,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = loginViewModel.passwordValue.value,
                onChange = loginViewModel::setPassword,
                placeholder = stringResource(R.string.password),
                isError = loginViewModel.passwordError.value.isNotEmpty(),
                icon = Icons.Rounded.Password,
                isPassword = true,
                errorMessage = loginViewModel.passwordError.value,
                imeAction = ImeAction.Done,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(R.string.forgot_password),
                style = MaterialTheme.typography.bodyMedium,
                color = Blue,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(40.dp)
                    .padding(end = 24.dp)
                    .align(Alignment.End)
                    .clickable { })
            Spacer(modifier = Modifier.height(20.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .align(Alignment.BottomCenter)
        ) {
            Button(
                onClick = {
                    focusManager.clearFocus()
                    loginViewModel.validateForm()
                    dialogMessage.value = "This is a demo alert dialog box."
                    showDialog.value = true

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Blue)
            ) {
                Text(
                    text = stringResource(R.string.login).uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = White
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }

    }

}