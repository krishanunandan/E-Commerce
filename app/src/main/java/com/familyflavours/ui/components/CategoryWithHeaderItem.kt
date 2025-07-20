package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.familyflavours.ui.models.CategoryList
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.utils.DummyData
import com.familyflavours.utils.DummyData.getCategoryList

@Composable
fun CategoryWithHeaderItem(navController: NavController, categoryList: CategoryList) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Category Title",
            fontFamily = robotoFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(3),  modifier = Modifier
            .heightIn(max = 1000.dp)
            .fillMaxWidth(),contentPadding = PaddingValues(10.dp)) {
            itemsIndexed(categoryList.categories) { index, categoryData ->
                CategoryItem(categoryData) {

                }
            }
        }
    }
}

@Preview
@Composable
fun CategoryWithHeaderItemPreview() {
    CategoryWithHeaderItem(rememberNavController(), getCategoryList()[0])
}