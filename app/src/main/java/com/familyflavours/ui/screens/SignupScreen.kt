package com.familyflavours.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.familyflavours.ui.viewmodel.SignupViewModel


@Composable
fun SignupScreen(navController: NavController, signupViewModel: SignupViewModel = hiltViewModel()) {
    val focusManager = LocalFocusManager.current
    Box {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = signupViewModel.fullName.value.value,
                onChange = signupViewModel::setFullName,
                placeholder = stringResource(R.string.full_name),
                isError = signupViewModel.fullName.error.value.isNotEmpty(),
                icon = Icons.Rounded.Person,
                errorMessage = signupViewModel.fullName.error.value,
                keyboardType = KeyboardType.Text,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = signupViewModel.email.value.value,
                onChange = signupViewModel::setEmail,
                placeholder = stringResource(R.string.email),
                isError = signupViewModel.email.error.value.isNotEmpty(),
                icon = Icons.Rounded.Email,
                errorMessage = signupViewModel.email.error.value,
                keyboardType = KeyboardType.Email,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = signupViewModel.mobileNo.value.value,
                onChange = signupViewModel::setMobileNo,
                placeholder = stringResource(R.string.mobile_no),
                isError = signupViewModel.mobileNo.error.value.isNotEmpty(),
                icon = Icons.Rounded.Phone,
                errorMessage = signupViewModel.mobileNo.error.value,
                keyboardType = KeyboardType.Number,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = signupViewModel.password.value.value,
                onChange = signupViewModel::setPassword,
                placeholder = stringResource(R.string.password),
                isError = signupViewModel.password.error.value.isNotEmpty(),
                icon = Icons.Rounded.Password,
                isPassword = true,
                errorMessage = signupViewModel.password.error.value,
                imeAction = ImeAction.Done,
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = signupViewModel.isTermAndConditionChecked.value,
                    onCheckedChange = signupViewModel::setTermsAndConditionsChecked,
                    colors = CheckboxDefaults.colors(checkedColor = Color.Blue, uncheckedColor = Color.Blue)
                )
                Text(text = stringResource(R.string.terms_agreements),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Blue,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(2.dp)
                        .clickable { })
            }
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
                    signupViewModel.validateFields()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
            ) {
                Text(
                    text = stringResource(R.string.signup).uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}