package com.familyflavours.ui.viewmodel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel



class LoginViewModel: ViewModel() {

    var emailValue = mutableStateOf("")
        private set

    var emailError = mutableStateOf("")
        private set

    fun setEmail(value: String){
        emailValue.value = value
    }

    var passwordValue = mutableStateOf("")
        private set

    var passwordError = mutableStateOf("")
        private set

    fun setPassword(value: String){
        passwordValue.value = value
    }


    fun validateEmail(): Boolean {
        val email = emailValue.value.trim()
        var isValid = true
        var errorMessage = ""
        if (email.isBlank() || email.isEmpty()) {
            errorMessage = "Please fill email field"
            isValid = false
        } else if (!Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matches(email)) {
            errorMessage = "Wrong email Format"
            isValid = false
        }
        emailError.value = errorMessage
        return isValid
    }

    fun validatePassword(): Boolean {
        val password = passwordValue.value.trim()
        var isValid = true
        var errorMessage = ""

        if (password.isBlank() || password.isEmpty()) {
            errorMessage = "Please fill password field"
            isValid = false
        } else if (password.length < 6) {
            errorMessage = "Password must more than 6 character"
            isValid = false
        }
        passwordError.value = errorMessage
        return isValid
    }

    fun validateForm() {
        if (validateEmail() && validatePassword()) {
            // NEXT STEP
        }
    }

}