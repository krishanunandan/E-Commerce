package com.familyflavours.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.models.FilterData


@Composable
fun FilterItem(filterData: FilterData, onItemClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = filterData.isSelected,
                onCheckedChange = { filterData.isSelected = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Blue
                )
            )
            Text(
                text = filterData.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Blue,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(2.dp)
                    .clickable { })
        }
        Divider(
            thickness = 1.dp,
            color = Color.LightGray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth().padding(horizontal = 20.dp)
        )
    }
}

@Preview
@Composable
fun FilterItemPreview(){
    FilterItem(filterData = FilterData(1,"Category")) { }
}