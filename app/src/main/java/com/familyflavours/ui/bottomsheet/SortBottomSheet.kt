package com.familyflavours.ui.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.R
import com.familyflavours.ui.components.CircularButton
import com.familyflavours.ui.components.CustomSearchBar
import com.familyflavours.ui.components.FilterItem
import com.familyflavours.ui.components.PrimaryButton
import com.familyflavours.ui.components.RadioButtonWithText
import com.familyflavours.ui.components.SecondaryButton
import com.familyflavours.ui.theme.LightWhite
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.utils.DummyData.getFilterItemList
import com.familyflavours.utils.getScreenHeightPercentage


@Composable
fun showSortBottomSheet(message: String, onCloseClick: () -> Unit) {
    val showBottomSheet = remember { mutableStateOf(true) }

    if (showBottomSheet.value) {
        SortBottomSheet(message = message, setShowBottomSheet = {
            showBottomSheet.value = it
        }, onCloseClick = {
            onCloseClick.invoke()
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortBottomSheet(
    message: String,
    setShowBottomSheet: (Boolean) -> Unit,
    onCloseClick: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val bottomSheetHeight = getScreenHeightPercentage(60f)
    var selectedOption = remember { mutableStateOf("Relevant (default)") }

    ModalBottomSheet(
        sheetState = sheetState,
        containerColor = Color.Transparent,
        dragHandle = null,
        onDismissRequest = { setShowBottomSheet(false) },
        properties = ModalBottomSheetProperties(shouldDismissOnBackPress = false),
        sheetMaxWidth = bottomSheetHeight
    ) {
        Column(
            modifier = Modifier
                .background(Color.Transparent)
                .height(bottomSheetHeight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircularButton(icon = Icons.Rounded.Close, onClick = {
                onCloseClick()
                setShowBottomSheet(false)
            }, color = LightWhite)
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .background(LightWhite)
            ) {

                Column {
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
                        text = "Sort",
                        fontFamily = robotoFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Divider(
                        thickness = 1.dp,
                        color = Color.LightGray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    RadioButtonWithText(
                        text = "Relevant (default)",
                        isSelected = selectedOption.value == "Relevant (default)"
                    ) {
                        selectedOption.value = "Relevant (default)"
                    }
                    RadioButtonWithText(
                        text = "Price (low to high)",
                        isSelected = selectedOption.value == "Price (low to high)"
                    ) {
                        selectedOption.value = "Price (low to high)"
                    }
                    RadioButtonWithText(
                        text = "Price (high to low)",
                        isSelected = selectedOption.value == "Price (high to low)"
                    ) {
                        selectedOption.value = "Price (high to low)"
                    }
                    RadioButtonWithText(
                        text = "Discount (high to low)",
                        isSelected = selectedOption.value == "Discount (high to low)"
                    ) {
                        selectedOption.value = "Discount (high to low)"
                    }

                }


            }
        }
    }
}

@Preview
@Composable
fun SortBottomSheetPreview() {
    showSortBottomSheet(message = stringResource(id = R.string.dummy_text), onCloseClick = {})
}