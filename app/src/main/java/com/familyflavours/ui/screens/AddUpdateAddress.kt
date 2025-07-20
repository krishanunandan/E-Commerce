package com.familyflavours.ui.screens

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddLocation
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.material.icons.rounded.MapsHomeWork
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PersonPin
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.familyflavours.R
import com.familyflavours.ui.components.HeaderWithTitle
import com.familyflavours.ui.components.TextField
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.ui.viewmodel.AddressViewModel
import com.familyflavours.ui.viewmodel.UIStateViewModel
import com.familyflavours.ui.viewmodel.UpdateProfileViewModel
import com.familyflavours.utils.underlined
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AddUpdateAddress(navController: NavController, uiStateViewModel: UIStateViewModel) {

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

    val addressViewModel: AddressViewModel = hiltViewModel()

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current


    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderWithTitle(stringResource(R.string.add_address)) {
            onBackClick()
        }

        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(25.dp))


                TextField(
                    value = addressViewModel.fullName.value.value,
                    onChange = addressViewModel::setFullName,
                    placeholder = stringResource(R.string.full_name),
                    isError = addressViewModel.fullName.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Person,
                    errorMessage = addressViewModel.fullName.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = addressViewModel.mobileNo.value.value,
                    onChange = addressViewModel::setMobileNo,
                    placeholder = stringResource(R.string.mobile_no),
                    isError = addressViewModel.mobileNo.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Phone,
                    errorMessage = addressViewModel.mobileNo.error.value,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = addressViewModel.address.value.value,
                    onChange = addressViewModel::setAddress,
                    placeholder = stringResource(R.string.email),
                    isError = addressViewModel.address.error.value.isNotEmpty(),
                    icon = Icons.Rounded.AddLocation,
                    errorMessage = addressViewModel.address.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = addressViewModel.city.value.value,
                    onChange = addressViewModel::setCity,
                    placeholder = stringResource(R.string.city),
                    isError = addressViewModel.city.error.value.isNotEmpty(),
                    icon = Icons.Rounded.MapsHomeWork,
                    errorMessage = addressViewModel.city.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = addressViewModel.state.value.value,
                    onChange = addressViewModel::setState,
                    placeholder = stringResource(R.string.state),
                    isError = addressViewModel.state.error.value.isNotEmpty(),
                    icon = Icons.Rounded.LocationCity,
                    errorMessage = addressViewModel.state.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = addressViewModel.pinCode.value.value,
                    onChange = addressViewModel::setPinCode,
                    placeholder = stringResource(R.string.pin_code),
                    isError = addressViewModel.pinCode.error.value.isNotEmpty(),
                    icon = Icons.Rounded.PersonPin,
                    errorMessage = addressViewModel.pinCode.error.value,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = addressViewModel.country.value.value,
                    onChange = addressViewModel::setCountry,
                    placeholder = stringResource(R.string.country),
                    isError = addressViewModel.country.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Home,
                    errorMessage = addressViewModel.country.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Done
                )

                Spacer(modifier = Modifier.height(220.dp))

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
                        // signupViewModel.validateFields()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
                ) {
                    Text(
                        text = stringResource(R.string.add_address).uppercase(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
    }
}