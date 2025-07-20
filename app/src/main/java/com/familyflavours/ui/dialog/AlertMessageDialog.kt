package com.familyflavours.ui.dialog

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun showAlertDialog(message: String,buttonText: String,onCloseClick: () -> Unit){
    val context = LocalContext.current


    val showDialog = remember { mutableStateOf(true) }

    if (showDialog.value) {
        AlertMessageDialog(message = message, setShowDialog = {
            showDialog.value = it
        }, onConfirmation = {
           onCloseClick.invoke()
        },buttonText)
    }
}

@Composable
fun AlertMessageDialog(
    message: String,
    setShowDialog: (Boolean) -> Unit,
    onConfirmation: () -> Unit,
    buttonText: String? = ""
) {


    Dialog(
        onDismissRequest = { setShowDialog(false) }, properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = true
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = message,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.End,
                ) {

                    TextButton(
                        onClick = {
                            onConfirmation()
                            setShowDialog(false)
                        },
                        modifier = Modifier.padding(8.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text(buttonText!!)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AlertDialogPreview() {
    showAlertDialog("Hello this is a demo dialog box.","OK", onCloseClick = {})
}