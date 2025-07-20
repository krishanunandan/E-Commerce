package com.familyflavours.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.familyflavours.R
import com.familyflavours.ui.components.CircularButton
import com.familyflavours.ui.components.HeaderWithBackIcon
import com.familyflavours.ui.components.HomeSlider
import com.familyflavours.ui.components.PrimaryButton
import com.familyflavours.ui.components.ProductCard
import com.familyflavours.ui.components.ProductDetailsImageSlider
import com.familyflavours.ui.components.ProductQuantityItem
import com.familyflavours.ui.components.ProductRating
import com.familyflavours.ui.components.SecondaryButton
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.theme.LightGray
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.ui.viewmodel.UIStateViewModel
import com.familyflavours.utils.DummyData.getProductQuantityList


@Composable
fun ProductDetails(navController: NavController, uiStateViewModel: UIStateViewModel,productName: String) {

    val selectedIndex = mutableStateOf(0)

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
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .padding(horizontal = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CircularButton(
                    icon = Icons.Rounded.ArrowBackIosNew,
                    onClick = { onBackClick() }
                )
                Text(
                    text = "Product Details",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                CircularButton(icon = Icons.Rounded.Favorite, onClick = {})

            }
            ProductDetailsImageSlider(navController = navController, size = 300.dp)

            Column(modifier = Modifier.padding(15.dp)) {


                ProductRating("FF", rating = 4.5f, ratingCount = 78)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = productName,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Quantity",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    itemsIndexed(getProductQuantityList()) { index, productQuantity ->
                        ProductQuantityItem(
                            quantityItem = productQuantity,
                            navController = navController,
                            index = index,
                            selectedIndex.value,
                            onClickItem = {
                                selectedIndex.value = index
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Description",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(R.string.dummy_text),
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp
                )

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, bottom = 50.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SecondaryButton(
                buttonText = "Add To Cart",
                modifier = Modifier
                    .height(50.dp)
                    .weight(weight = 1f), onClick = {})

            PrimaryButton(
                buttonText = "Buy Now",
                modifier = Modifier
                    .height(50.dp)
                    .weight(weight = 1f), onClick = {}
            )
        }
    }

}