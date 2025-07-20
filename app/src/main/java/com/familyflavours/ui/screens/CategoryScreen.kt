package com.familyflavours.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.familyflavours.ui.components.CategoryWithHeaderItem
import com.familyflavours.utils.DummyData.getCategoryList


@Composable
fun CategoryScreen(navController: NavController, modifier: Modifier) {

    Column(modifier = modifier) {
        LazyColumn(modifier = Modifier.padding(15.dp)) {
            itemsIndexed(getCategoryList()) { index, item ->
                CategoryWithHeaderItem(navController = navController, categoryList = item)
            }
        }
    }
}