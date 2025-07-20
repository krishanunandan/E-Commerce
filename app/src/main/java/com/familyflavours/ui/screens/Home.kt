package com.familyflavours.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.familyflavours.ui.components.BottomNavigationBar
import com.familyflavours.ui.navigation.HomeScreenBottomNavigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.familyflavours.ui.components.HeaderWithMenus
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.viewmodel.UIStateViewModel
import kotlinx.coroutines.delay


@Composable
fun Home(navController: NavController) {

    var showToast = remember { mutableStateOf(false) }

    var backPressState = remember { mutableStateOf<BackPress>(BackPress.Idle) }
    val context = LocalContext.current

    if (showToast.value) {
        Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
        showToast.value = false
    }


    LaunchedEffect(key1 = backPressState) {
        if (backPressState.value == BackPress.InitialTouch) {
            delay(2000)
            backPressState.value = BackPress.Idle
        }
    }

    BackHandler(backPressState.value == BackPress.Idle) {
        backPressState.value = BackPress.InitialTouch
        showToast.value = true
    }

    //val viewModelStoreOwner = LocalContext.current as ViewModelStoreOwner
    // Set the ViewModelStore before calling setGraph
    //navController.setViewModelStore(viewModelStoreOwner.viewModelStore)

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val uiStateViewModel: UIStateViewModel = hiltViewModel()


    val isTopBarVisible = uiStateViewModel.isTopBarVisible.value
    val isBottomBarVisible = uiStateViewModel.isBottomBarVisible.value


    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }, topBar = {
        Log.d("UIState1", "Top Bar Visible: $isTopBarVisible")

        if (isTopBarVisible) {
            HeaderWithMenus(onSearchClick = {
                navController.navigate(Routes.SearchScreen.route)
            }, onNotificationClick = {
                navController.navigate(Routes.NotificationScreen.route)
            })
        }
    }, bottomBar = {
        Log.d("UIState1", "Bottom Bar Visible: $isBottomBarVisible")
        if (isBottomBarVisible) {
            BottomNavigationBar(navController = navController)
        }
    }) { paddingValues ->
        // NavigationHost inside Scaffold content

        HomeScreenBottomNavigation(
            navController = navController,
            modifier = Modifier
                .fillMaxSize() // This will ensure the content fills the available space
                .padding(paddingValues),
            uiStateViewModel
        )

    }

}

sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}