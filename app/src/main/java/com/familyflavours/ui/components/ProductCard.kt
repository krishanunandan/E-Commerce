package com.familyflavours.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.familyflavours.R
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.theme.LightGray
import com.familyflavours.ui.theme.LightWhite
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    productItem: ProductData,
    navController: NavController,
    onClickToCart: (ProductData) -> Unit
) {
    Column(
        modifier = modifier
            .width(200.dp)
            .padding(12.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = LightWhite),
            modifier = modifier.clickable {
                navController.navigate("ProductDetails/${productItem.productName}")
            }
        ) {
            Image(
                painter = rememberImagePainter(data = productItem.productImage),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ProductRating("FF", rating = 4.5f, ratingCount = 78)

        Text(
            text = productItem.productName,
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            color = Black,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = productItem.productUnit,
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Medium,
            color = LightGray,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Rs. ${productItem.productPrice}.00", fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Black,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 16.sp
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview
@Composable
fun ItemProductPreview() {
    ProductCard(productItem = ProductData(
        productName = "Organic Bananas",
        productImage = "https://picsum.photos/200/300",
        productUnit = "250 gram",
        productPrice = 25,
    ), navController = rememberNavController(), onClickToCart = {})
}