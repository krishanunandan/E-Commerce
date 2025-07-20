package com.familyflavours.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.familyflavours.R
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.utils.DummyData.getProductList


@Composable
fun ProductListWithHeader(
    modifier: Modifier = Modifier,
    title: String,
    products: List<ProductData>,
    navController: NavController,
    onClickToCart: (ProductData) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Black
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        navController.navigate(Routes.ProductListScreen.route)
                    },
                text = stringResource(id = R.string.see_all),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Black
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(products) { product ->
                ProductCard(
                    productItem = product,
                    navController = navController,
                    onClickToCart = onClickToCart
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListContentProductPreview() {
    ProductListWithHeader(
        title = "Exclusive Offer",
        products = getProductList(),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}