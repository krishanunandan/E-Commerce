package com.familyflavours.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.Text
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
import com.familyflavours.ui.theme.LightWhite
import com.familyflavours.ui.theme.robotoFontFamily


@Composable
fun showInfoBottomSheet(message: String, onCloseClick: () -> Unit) {
    val showBottomSheet = remember { mutableStateOf(true) }

    if (showBottomSheet.value) {
        InfoBottomSheet(message = message, setShowBottomSheet = {
            showBottomSheet.value = it
        }, onCloseClick = {
            onCloseClick.invoke()
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoBottomSheet(
    message: String,
    setShowBottomSheet: (Boolean) -> Unit,
    onCloseClick: () -> Unit
) {

    ModalBottomSheet(
        containerColor = Color.Transparent,
        dragHandle = null,
        onDismissRequest = { setShowBottomSheet(false) },
        properties = ModalBottomSheetProperties(shouldDismissOnBackPress = false)
    ) {
        Column(
            modifier = Modifier.background(Color.Transparent),
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
                    .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .background(LightWhite)
            ) {
                Text(
                    text = message,
                    modifier = Modifier
                        .padding(25.dp)
                        .align(Alignment.Center),
                    fontFamily = robotoFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowInfoBottomSheetPreview() {
    showInfoBottomSheet(message = stringResource(id = R.string.dummy_text), onCloseClick = {})
}