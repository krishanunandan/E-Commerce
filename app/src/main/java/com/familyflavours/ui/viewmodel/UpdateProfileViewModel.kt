package com.familyflavours.ui.viewmodel

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.familyflavours.ui.models.FieldState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateProfileViewModel : ViewModel() {
    var fullName = FieldState()
    var email = FieldState()
    var mobileNo = FieldState()
    var city = FieldState()
    var state = FieldState()
    var pinCode = FieldState()
    var country = FieldState()

    var imageHeight = mutableIntStateOf(0)
    var imageWidth = mutableIntStateOf(0)


    var imageUri by mutableStateOf<Uri?>(null)
        private set
    var imageBitmap by mutableStateOf<Bitmap?>(null)
        private set


    fun setFullName(fullName: String) {
        this.fullName.value.value = fullName
    }

    fun setEmail(email: String) {
        this.email.value.value = email
    }

    fun setMobileNo(mobileNo: String) {
        this.mobileNo.value.value = mobileNo
    }

    fun setCity(city: String) {
        this.city.value.value = city
    }

    fun setState(state: String) {
        this.state.value.value = state
    }

    fun setPinCode(pinCode: String) {
        this.pinCode.value.value = pinCode
    }

    fun setCountry(country: String) {
        this.country.value.value = country
    }

    fun updateImageUri(uri: Uri?) {
        imageUri = uri
    }

    fun updateImageBitmap(bitmap: Bitmap?) {
        imageBitmap = bitmap
        updateImageHeightAndWidth(bitmap)
    }

    private fun updateImageHeightAndWidth(bitmap: Bitmap?) {
        bitmap?.let {
            val width = it.width
            val height = it.height

            imageHeight.intValue = height
            imageWidth.intValue = width
        }
    }

    fun getImageHeightFromURL(context: Context, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val imageLoader = ImageLoader(context)
            val request = ImageRequest.Builder(context)
                .data(url)
                .build()

            val result = imageLoader.execute(request)
            if (result is SuccessResult) {
                val drawable = result.drawable
                val bitmap = (drawable as BitmapDrawable).bitmap
                updateImageBitmap(bitmap)
                // Now you have the Bitmap, you can use it in Compose as well
               // val imageBitmap = bitmap.asImageBitmap()
                if (bitmap != null) {

                    imageHeight.intValue = bitmap.height
                    imageWidth.intValue = bitmap.width
                }


            }
        }
    }


}