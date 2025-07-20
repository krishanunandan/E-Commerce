package com.familyflavours.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.familyflavours.R
import com.familyflavours.ui.models.CategoryData
import com.familyflavours.ui.theme.LightWhite
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.utils.DummyData.getCategoryList

@Composable
fun CategoryItem(categoryData: CategoryData, onItemClick: () -> Unit) {
    Column(modifier = Modifier.padding(5.dp)
        .width(150.dp)
        .clickable { onItemClick.invoke() }) {
        Card(colors = CardDefaults.cardColors(containerColor = LightWhite)) {
            Image(
                painter = rememberImagePainter(data = categoryData.categoryImage),
                contentDescription = stringResource(
                    R.string.app_name
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = categoryData.categoryName,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    CategoryItem(getCategoryList()[0].categories[0]) {

    }
}