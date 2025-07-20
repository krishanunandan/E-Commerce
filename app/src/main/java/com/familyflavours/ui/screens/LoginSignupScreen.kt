package com.familyflavours.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.familyflavours.ui.components.HeaderWithBackIcon
import com.familyflavours.ui.components.TabLayout
import com.familyflavours.ui.theme.EcomJetpackComposeTheme


private fun getTabList(): List<String> {
    return listOf(
        "Login",
        "Signup"
    )
}


@Composable
fun LoginSignupScreen(navController: NavController) {
    val tabData = getTabList()
    val pagerState = rememberPagerState(pageCount = { tabData.size })

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 20.dp, 0.dp, 0.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        HeaderWithBackIcon {

        }
        Spacer(modifier = Modifier.size(25.dp))
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(50.dp, 0.dp, 50.dp, 0.dp),
            contentAlignment = Alignment.Center
        ) {
            TabLayout(tabData, pagerState)
        }

        TabsContent(pagerState,navController)
    }
}


@Composable
fun TabsContent(pagerState: PagerState,navController: NavController) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> LoginScreen(navController)
            1 -> SignupScreen(navController)
        }
    }
}


@Preview()
@Composable
fun PreviewTab() {
    EcomJetpackComposeTheme {
        val tabData = getTabList()
        val pagerState = rememberPagerState(pageCount = { tabData.size })
        TabLayout(tabData, pagerState)
    }
}

@Preview()
@Composable
fun PreviewContent() {
    EcomJetpackComposeTheme {
        LoginSignupScreen(navController = rememberNavController())
    }
}