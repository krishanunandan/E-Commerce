package com.familyflavours.ui.navigation

sealed class Routes (val route: String) {
    object LoginSignUpScreen : Routes("LoginSignupScreen")
    object HomeScreen : Routes("HomeScreen")
    object Home : Routes("Home")
    object Category : Routes("Category")
    object Cart : Routes("Cart")
    object Profile : Routes("Profile")
    object ProductDetails : Routes("ProductDetails/{productName}")
    object NotificationScreen : Routes("NotificationScreen")
    object SearchScreen : Routes("SearchScreen")
    object UpdateProfile : Routes("UpdateProfile")
    object AddUpdateAddress : Routes("AddUpdateAddress")
    object AboutUsScreen : Routes("AboutUsScreen")
    object DeleteAccountScreen : Routes("DeleteAccountScreen")
    object ProductListScreen : Routes("ProductListScreen")
    object CheckoutScreen : Routes("CheckoutScreen")
}