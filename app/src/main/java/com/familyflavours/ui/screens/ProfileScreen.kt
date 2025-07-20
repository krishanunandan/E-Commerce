package com.familyflavours.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.DeleteForever
import androidx.compose.material.icons.rounded.Logout
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.familyflavours.ui.components.ButtonWithIcon
import com.familyflavours.ui.components.ProfileActionTools
import com.familyflavours.ui.components.ProfileCard
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.utils.shareApp


@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier) {
    val context = LocalContext.current
    var showDialog = remember { mutableStateOf(false) }


    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Confirm Logout") },
            text = { Text("Are you sure you want to log out?") },
            shape = RoundedCornerShape(0.dp),
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = false,
                usePlatformDefaultWidth = true
            ),
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    // Add your logout logic here
                    println("User logged out")
                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text("No")
                }
            }
        )
    }


    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        ProfileCard(navController = navController)
        ProfileActionTools(navController = navController)
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Your Information".uppercase(),
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonWithIcon(buttonText = "Your Order", icon = Icons.Rounded.Book, onClick = {})
        ButtonWithIcon(buttonText = "Address Book", icon = Icons.Rounded.MyLocation, onClick = {
            navController.navigate(
                Routes.AddUpdateAddress.route
            )
        })
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Other Information".uppercase(),
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonWithIcon(buttonText = "Share the app", icon = Icons.Rounded.Share, onClick = {
            context.shareApp()
        })
        ButtonWithIcon(buttonText = "About us", icon = Icons.Rounded.Person, onClick = {
            navController.navigate(Routes.AboutUsScreen.route)
        })
        ButtonWithIcon(
            buttonText = "Delete account",
            icon = Icons.Rounded.DeleteForever,
            onClick = {
                navController.navigate(Routes.DeleteAccountScreen.route)
            })
        ButtonWithIcon(buttonText = "Log out", icon = Icons.Rounded.Logout, onClick = {
            showDialog.value = true
        })
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterHorizontally),
            text = "Kn App",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 16.sp,
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterHorizontally),
            text = "v1.0.0",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.LightGray,
            fontSize = 12.sp,
        )
        Spacer(modifier = Modifier.height(25.dp))
    }


}