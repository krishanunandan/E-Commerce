package com.familyflavours.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.models.ProductQuantityData
import com.familyflavours.ui.theme.LightWhite
import com.familyflavours.ui.theme.robotoFontFamily

@Composable
fun ProductQuantityItem(
    quantityItem: ProductQuantityData,
    navController: NavController,
    index: Int,
    selectedIndex: Int,
    onClickItem: (ProductQuantityData) -> Unit
) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        border = BorderStroke(1.dp, if (index == selectedIndex) Color.Blue else Color.LightGray),
        modifier = Modifier
            .width(100.dp)
            .height(70.dp)
            .clickable {onClickItem.invoke(quantityItem) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quantityItem.unit,
                fontSize = 16.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = quantityItem.price,
                fontSize = 16.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun ProductQuantityItemPreview() {
    ProductQuantityItem(quantityItem = ProductQuantityData(
        unit = "200 gram",
        price = "Rs.50.00",
    ), navController = rememberNavController(), 0, 0, onClickItem = {})
}