package com.familyflavours.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UIStateViewModel @Inject constructor() : ViewModel() {

    private val _isTopBarVisible = mutableStateOf(true)
    val isTopBarVisible: State<Boolean> = _isTopBarVisible

    private val _isBottomBarVisible = mutableStateOf(true)
    val isBottomBarVisible: State<Boolean> = _isBottomBarVisible

    // Methods to hide or show top and bottom bars
    fun hideTopBar() {
        _isTopBarVisible.value = false
        Log.d("UIState", "Top bar hidden: ${_isTopBarVisible.value}")
    }

    fun showTopBar() {
        _isTopBarVisible.value = true

    }

    fun hideBottomBar() {
        _isBottomBarVisible.value = false
        Log.d("UIState", "Bottom bar hidden: ${_isBottomBarVisible.value}")
    }

    fun showBottomBar() {
        _isBottomBarVisible.value = true
    }

}