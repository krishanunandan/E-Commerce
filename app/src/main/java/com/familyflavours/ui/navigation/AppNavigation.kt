package com.familyflavours.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.screens.Home
import com.familyflavours.ui.screens.HomeScreen
import com.familyflavours.ui.screens.LoginScreen
import com.familyflavours.ui.screens.LoginSignupScreen
import com.familyflavours.utils.animatedComposable


@Composable
fun AppNavigation(navController: NavController,homeNavController:NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.LoginSignUpScreen.route
    ) {
        composable(Routes.LoginSignUpScreen.route) {
            LoginSignupScreen(navController)
        }
        animatedComposable(route = Routes.Home.route) {
            Home(navController = homeNavController)
        }
/*
        composable(route = Routes.ProductDetails.route) {
            ProductDetails(navController = homeNavController)
        }*/
    }
}
