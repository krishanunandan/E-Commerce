package com.familyflavours.ui.viewmodel

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.familyflavours.ui.models.AddressData
import com.familyflavours.ui.models.Discount
import com.familyflavours.ui.models.FieldState
import com.familyflavours.ui.models.PaymentBreakup
import com.familyflavours.ui.models.PaymentMode

class AddressViewModel : ViewModel() {
    var fullName = FieldState()
    var mobileNo = FieldState()
    var address = FieldState()
    var city = FieldState()
    var state = FieldState()
    var pinCode = FieldState()
    var country = FieldState()


    var imageUri by mutableStateOf<Uri?>(null)
        private set
    var imageBitmap by mutableStateOf<Bitmap?>(null)
        private set


    fun setFullName(fullName: String) {
        this.fullName.value.value = fullName
    }

    fun setMobileNo(mobileNo: String) {
        this.mobileNo.value.value = mobileNo
    }

    fun setAddress(address: String) {
        this.address.value.value = address
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
    }




}