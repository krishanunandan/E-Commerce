package com.familyflavours.ui.screens

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.material.icons.rounded.MapsHomeWork
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PersonPin
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
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
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.familyflavours.R
import com.familyflavours.ui.components.HeaderWithTitle
import com.familyflavours.ui.components.TextField
import com.familyflavours.ui.theme.robotoFontFamily
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
fun UpdateProfile(navController: NavController, uiStateViewModel: UIStateViewModel) {

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

    val updateProfileViewModel: UpdateProfileViewModel = hiltViewModel()

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    val galleryPermissionState = rememberPermissionState(Manifest.permission.READ_MEDIA_IMAGES)
    val imageUri = updateProfileViewModel.imageUri
    val imageBitmap = updateProfileViewModel.imageBitmap

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            if (bitmap != null) {
                updateProfileViewModel.updateImageBitmap(bitmap)
                val uri = bitmapToUri(context, bitmap)
                updateProfileViewModel.updateImageUri(uri)
            }
        }
    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        updateProfileViewModel.updateImageUri(uri)
        if (uri != null) {
            val bitmap = uriToBitmap(context, uri)
            updateProfileViewModel.updateImageBitmap(bitmap)
        }
    }



    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderWithTitle(stringResource(R.string.update_profile)) {
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

                if (imageBitmap != null) {
                    Image(
                        bitmap = imageBitmap.asImageBitmap(),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                } else {
                    Image(
                        painter = rememberImagePainter(data = "https://picsum.photos/200/300"),
                        contentDescription = stringResource(id = R.string.app_name),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            if (cameraPermissionState.status.isGranted) {
                                cameraLauncher.launch(null)
                            } else {
                                cameraPermissionState.launchPermissionRequest()
                            }

                            //if (galleryPermissionState.status.isGranted) {
                            //    galleryLauncher.launch("image/*")
                            // } else {
                            //     galleryPermissionState.launchPermissionRequest()
                            // }
                        },
                    text = stringResource(R.string.choose_image).underlined(),
                    fontFamily = robotoFontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            if (galleryPermissionState.status.isGranted) {
                                galleryLauncher.launch("image/*")
                            } else {
                                galleryPermissionState.launchPermissionRequest()
                            }
                        },
                    text = "Gallery",
                    fontFamily = robotoFontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Height - ${updateProfileViewModel.imageHeight.value}, Width - ${updateProfileViewModel.imageWidth.value}",
                    fontFamily = robotoFontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(
                    value = updateProfileViewModel.fullName.value.value,
                    onChange = updateProfileViewModel::setFullName,
                    placeholder = stringResource(R.string.full_name),
                    isError = updateProfileViewModel.fullName.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Person,
                    errorMessage = updateProfileViewModel.fullName.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = updateProfileViewModel.email.value.value,
                    onChange = updateProfileViewModel::setEmail,
                    placeholder = stringResource(R.string.email),
                    isError = updateProfileViewModel.email.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Email,
                    errorMessage = updateProfileViewModel.email.error.value,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next,
                    isEnabled = false
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = updateProfileViewModel.mobileNo.value.value,
                    onChange = updateProfileViewModel::setMobileNo,
                    placeholder = stringResource(R.string.mobile_no),
                    isError = updateProfileViewModel.mobileNo.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Phone,
                    errorMessage = updateProfileViewModel.mobileNo.error.value,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = updateProfileViewModel.city.value.value,
                    onChange = updateProfileViewModel::setCity,
                    placeholder = stringResource(R.string.city),
                    isError = updateProfileViewModel.city.error.value.isNotEmpty(),
                    icon = Icons.Rounded.MapsHomeWork,
                    errorMessage = updateProfileViewModel.city.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = updateProfileViewModel.state.value.value,
                    onChange = updateProfileViewModel::setState,
                    placeholder = stringResource(R.string.state),
                    isError = updateProfileViewModel.state.error.value.isNotEmpty(),
                    icon = Icons.Rounded.LocationCity,
                    errorMessage = updateProfileViewModel.state.error.value,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = updateProfileViewModel.pinCode.value.value,
                    onChange = updateProfileViewModel::setPinCode,
                    placeholder = stringResource(R.string.pin_code),
                    isError = updateProfileViewModel.pinCode.error.value.isNotEmpty(),
                    icon = Icons.Rounded.PersonPin,
                    errorMessage = updateProfileViewModel.pinCode.error.value,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    imeAction = ImeAction.Next
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = updateProfileViewModel.country.value.value,
                    onChange = updateProfileViewModel::setCountry,
                    placeholder = stringResource(R.string.country),
                    isError = updateProfileViewModel.country.error.value.isNotEmpty(),
                    icon = Icons.Rounded.Home,
                    errorMessage = updateProfileViewModel.country.error.value,
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
                        updateProfileViewModel.getImageHeightFromURL(context, updateProfileViewModel.country.value.value)


                        // signupViewModel.validateFields()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
                ) {
                    Text(
                        text = stringResource(R.string.update_profile).uppercase(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
    }
}

fun bitmapToUri(context: Context, bitmap: Bitmap): Uri? {
    val imagesFolder = File(context.cacheDir, "images")
    var uri: Uri? = null
    try {
        imagesFolder.mkdirs()
        val file = File(imagesFolder, "captured_image.jpg")
        val stream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        stream.flush()
        stream.close()
        uri = FileProvider.getUriForFile(
            context.applicationContext,
            "com.familyflavours.provider",
            file
        )
    } catch (e: IOException) {
        Toast.makeText(context, "Error save image", Toast.LENGTH_SHORT).show()
    }
    return uri
}

fun uriToBitmap(context: Context, uri: Uri): Bitmap {
    return if (Build.VERSION.SDK_INT < 28) {
        MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
    } else {
        val source = ImageDecoder.createSource(context.contentResolver, uri)
        ImageDecoder.decodeBitmap(source)
    }
}