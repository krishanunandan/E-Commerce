package com.familyflavours.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.familyflavours.ui.bottomsheet.FilterBottomSheet
import com.familyflavours.ui.bottomsheet.SortBottomSheet
import com.familyflavours.ui.components.ButtonWithDropDownIcon
import com.familyflavours.ui.components.CategoryItem
import com.familyflavours.ui.components.HeaderWithTitle
import com.familyflavours.ui.components.ProductCard
import com.familyflavours.ui.viewmodel.UIStateViewModel
import com.familyflavours.utils.DummyData.getCategoryListData
import com.familyflavours.utils.DummyData.getProductList

@Composable
fun ProductListScreen(navController: NavController, uiStateViewModel: UIStateViewModel) {

    LaunchedEffect(Unit) {
        uiStateViewModel.hideTopBar()
        uiStateViewModel.hideBottomBar()
    }

    fun onBackClick() {
        uiStateViewModel.showTopBar()
        uiStateViewModel.showBottomBar()
        navController.popBackStack()
    }
    BackHandler {
        onBackClick()
    }

    val showFilterBottomSheet = remember { mutableStateOf(false) }
    val showSortBottomSheet = remember { mutableStateOf(false) }

    if (showFilterBottomSheet.value) {
        FilterBottomSheet(message = "", setShowBottomSheet = {
            showFilterBottomSheet.value = it
        }, onCloseClick = {

        })
    }

    if (showSortBottomSheet.value) {
        SortBottomSheet(message = "", setShowBottomSheet = {
            showSortBottomSheet.value = it
        }, onCloseClick = {

        })
    }



    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderWithTitle("Product List") {
            onBackClick()
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            modifier = Modifier
                .fillMaxSize()

        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(0.dp) // Use weight instead of fixed width
                    .weight(0.25f)
            ) {
                items(getCategoryListData()) { item ->
                    CategoryItem(item) {
                    }
                }
                item { Spacer(modifier = Modifier.height(100.dp)) }

            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.75f)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(5.dp)
                ) {
                    ButtonWithDropDownIcon(
                        buttonText = "Filter",
                        selectedValue = 0,
                        onClick = {
                            showFilterBottomSheet.value = true
                        },
                        leadingIcon = Icons.Default.FilterList
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    ButtonWithDropDownIcon(
                        buttonText = "Sort",
                        selectedValue = 0,
                        onClick = {
                            showSortBottomSheet.value = true
                        },
                        leadingIcon = Icons.Filled.Sort
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentWidth()
                ) {
                    items(getProductList()) { item ->
                        ProductCard(
                            productItem = item,
                            navController = navController,
                            onClickToCart = {}
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }


                /*LazyRow{
                    items(getProductList()) { item ->
                        ProductCard(
                            productItem = item,
                            navController = navController,
                            onClickToCart = {}
                        )
                    }
                }*/

            }
        }
    }
}
