package com.familyflavours.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.currentBackStackEntryAsState
import com.familyflavours.ui.models.NavigationItem
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.theme.robotoFontFamily


@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableStateOf(0) // Mutable state instead of mutableIntStateOf
    }

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = Routes.HomeScreen.route
        ),
        NavigationItem(
            title = "Category",
            icon = Icons.Default.Settings,
            route = Routes.Category.route
        ),
        NavigationItem(
            title = "Cart",
            icon = Icons.Default.ShoppingCart,
            route = Routes.Cart.route
        ),
        NavigationItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = Routes.Profile.route
        )
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = item.route == backStackEntry.value?.destination?.route,
                onClick = {
                    navController.navigate(item.route)

                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        fontFamily = robotoFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = if (item.route == backStackEntry.value?.destination?.route)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }


    }

   /* when (backStackEntry.value?.destination?.route) {
        Routes.HomeScreen.route -> {

        }
        else -> {
            bottomNavVisibility = true
            isVisible(false)
        }
    }*/
}


/*
@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = Routes.HomeScreen.route
        ),
        NavigationItem(
            title = "Category",
            icon = Icons.Default.Settings,
            route = Routes.Category.route
        ),
        NavigationItem(
            title = "Cart",
            icon = Icons.Default.ShoppingCart,
            route = Routes.Cart.route
        ),
        NavigationItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = Routes.Profile.route
        )
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route){
                        popUpTo(item.route) { inclusive = true }
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )

            )
        }
    }
}
*/
