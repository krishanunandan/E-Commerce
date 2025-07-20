package com.familyflavours.ui.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class FieldState(
    var value: MutableState<String> = mutableStateOf(""),
    var error: MutableState<String> = mutableStateOf("")
)
