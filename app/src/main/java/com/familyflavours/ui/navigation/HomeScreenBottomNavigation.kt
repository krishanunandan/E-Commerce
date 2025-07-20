package com.familyflavours.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.screens.AboutUsScreen
import com.familyflavours.ui.screens.AddUpdateAddress
import com.familyflavours.ui.screens.CartScreen
import com.familyflavours.ui.screens.CategoryScreen
import com.familyflavours.ui.screens.CheckoutScreen
import com.familyflavours.ui.screens.DeleteAccountScreen
import com.familyflavours.ui.screens.Home
import com.familyflavours.ui.screens.HomeScreen
import com.familyflavours.ui.screens.NotificationScreen
import com.familyflavours.ui.screens.ProductDetails
import com.familyflavours.ui.screens.ProductListScreen
import com.familyflavours.ui.screens.ProfileScreen
import com.familyflavours.ui.screens.SearchScreen
import com.familyflavours.ui.screens.UpdateProfile
import com.familyflavours.ui.viewmodel.UIStateViewModel
import com.familyflavours.utils.animatedComposable

@Composable
fun HomeScreenBottomNavigation(
    navController: NavController,
    modifier: Modifier,
    uiStateViewModel: UIStateViewModel
) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.HomeScreen.route
    ) {
        composable(route = Routes.HomeScreen.route) {
            HomeScreen(navController = navController, modifier)
        }
        composable(route = Routes.Category.route) {
            CategoryScreen(navController = navController, modifier)
        }
        composable(route = Routes.Cart.route) {
            CartScreen(navController = navController, modifier)
        }

        composable(route = Routes.Profile.route) {
            ProfileScreen(navController = navController, modifier)
        }

        composable(route = Routes.ProductDetails.route) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("productName")
            if (name != null) {
                ProductDetails(
                    navController = navController,
                    uiStateViewModel,
                    name
                )
            }
        }
        composable(route = Routes.NotificationScreen.route) {
            NotificationScreen(navController = navController, uiStateViewModel)
        }

        composable(route = Routes.SearchScreen.route) {
            SearchScreen(navController = navController, uiStateViewModel)
        }

        composable(route = Routes.UpdateProfile.route) {
            UpdateProfile(navController = navController, uiStateViewModel)
        }

        animatedComposable(route = Routes.AddUpdateAddress.route) {
            AddUpdateAddress(navController = navController, uiStateViewModel)
        }

        animatedComposable(route = Routes.AboutUsScreen.route) {
            AboutUsScreen(navController = navController, uiStateViewModel)
        }

        animatedComposable(route = Routes.DeleteAccountScreen.route) {
            DeleteAccountScreen(navController = navController, uiStateViewModel)
        }

        animatedComposable(route = Routes.ProductListScreen.route) {
            ProductListScreen(navController = navController, uiStateViewModel)
        }

        animatedComposable(route = Routes.CheckoutScreen.route) {
            CheckoutScreen(navController = navController, uiStateViewModel)
        }
    }
}