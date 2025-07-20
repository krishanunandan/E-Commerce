package com.familyflavours.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.familyflavours.ui.components.BottomNavigationBar
import com.familyflavours.ui.components.HomeSlider
import com.familyflavours.ui.components.ProductListWithHeader
import com.familyflavours.ui.theme.EcomJetpackComposeTheme
import com.familyflavours.utils.DummyData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        HomeSlider(navController = navController)
        Spacer(modifier = Modifier.height(20.dp))
        ProductListWithHeader(
            title = "Recommended for you",
            products = DummyData.getProductList(),
            navController = navController,
            onClickToCart = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
        ProductListWithHeader(
            title = "Deals for you",
            products = DummyData.getProductList(),
            navController =navController,
            onClickToCart = {}
        )
    }

}