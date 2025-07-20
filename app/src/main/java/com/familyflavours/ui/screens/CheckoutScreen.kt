package com.familyflavours.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.familyflavours.R
import com.familyflavours.ui.components.CheckoutAddressCard
import com.familyflavours.ui.components.DiscountCard
import com.familyflavours.ui.components.HeaderWithTitle
import com.familyflavours.ui.components.PriceBreakupCard
import com.familyflavours.ui.components.PaymentModeCard
import com.familyflavours.ui.viewmodel.CheckoutViewModel
import com.familyflavours.ui.viewmodel.UIStateViewModel


@Composable
fun CheckoutScreen(
    navController: NavController,
    uiStateViewModel: UIStateViewModel
) {
    val checkoutViewModel: CheckoutViewModel = viewModel()


    val insets = LocalDensity.current.density
    //  val navBarHeight = insets.navBarHeight()

    LaunchedEffect(Unit) {
        uiStateViewModel.hideTopBar()
        uiStateViewModel.hideBottomBar()
    }

    fun onBackClick() {
        uiStateViewModel.showTopBar()
        uiStateViewModel.showBottomBar()
        navController.popBackStack()
    }
    BackHandler {
        onBackClick()
    }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            HeaderWithTitle(stringResource(R.string.checkout)) {
                onBackClick()
            }

        },
        bottomBar = {
            Button(
                onClick = { /* Proceed to payment */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Blue)
            ) {
                Text("Proceed to Pay")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                CheckoutAddressCard(
                    selectedAddress = checkoutViewModel.selectedAddress.value,
                    onAddressChange = checkoutViewModel::updateSelectedAddress
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                DiscountCard(
                    discountCode = checkoutViewModel.discountCode.value,
                    appliedDiscount = checkoutViewModel.appliedDiscount.value,
                    onDiscountCodeChange = checkoutViewModel::updateDiscountCode,
                    onApplyDiscount = checkoutViewModel::applyDiscount,
                    onRemoveDiscount = checkoutViewModel::removeDiscount
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                PriceBreakupCard(paymentBreakup = checkoutViewModel.paymentBreakup.value)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                PaymentModeCard(
                    paymentModes = checkoutViewModel.paymentModes,
                    selectedPaymentMode = checkoutViewModel.selectedPaymentMode.value,
                    onPaymentModeChange = checkoutViewModel::updateSelectedPaymentMode
                )
            }
        }
    }

}

@Preview
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(navController = NavController(LocalContext.current), UIStateViewModel())
}