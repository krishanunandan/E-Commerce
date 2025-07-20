package com.familyflavours.ui.viewmodel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.familyflavours.ui.models.FieldState

class SignupViewModel : ViewModel() {
    var fullName = FieldState()
    var email = FieldState()
    var mobileNo = FieldState()
    var password = FieldState()
    var isTermAndConditionChecked = mutableStateOf(false)


    fun setFullName(fullName: String) {
        this.fullName.value.value = fullName
    }

    fun setEmail(email: String) {
        this.email.value.value = email
    }

    fun setMobileNo(mobileNo: String) {
        this.mobileNo.value.value = mobileNo
    }

    fun setPassword(password: String) {
        this.password.value.value = password
    }

    fun setTermsAndConditionsChecked(isChecked: Boolean) {
        this.isTermAndConditionChecked.value = isChecked
    }


    fun validateFields(): Boolean {
        var isValid = true

        if (fullName.value.value.isBlank() || fullName.value.value.isEmpty()) {
            fullName.error.value = "Full name is required"
            isValid = false
        } else {
            fullName.error.value = ""
        }

        if (email.value.value.isBlank() || email.value.value.isEmpty()) {
            email.error.value = "Email is required"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.value.value).matches()) {
            email.error.value = "Wrong email Format"
            isValid = false
        } else {
            email.error.value = ""
        }

        if (mobileNo.value.value.isBlank() || mobileNo.value.value.isEmpty()) {
            mobileNo.error.value = "Mobile number is required"
            isValid = false
        } else if (mobileNo.value.value.length < 10 || mobileNo.value.value.length > 10) {
            mobileNo.error.value = "Mobile number must be in 10 character"
            isValid = false
        } else {
            mobileNo.error.value = ""
        }

        if (password.value.value.isBlank() || password.value.value.isEmpty()) {
            password.error.value = "Password is required"
            isValid = false
        } else if (password.value.value.length < 6) {
            password.error.value = "Password must more than 6 character"
            isValid = false
        } else {
            password.error.value = ""
        }
        return isValid
    }
}