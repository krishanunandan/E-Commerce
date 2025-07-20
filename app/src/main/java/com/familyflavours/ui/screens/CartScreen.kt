package com.familyflavours.ui.screens


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.familyflavours.R
import com.familyflavours.ui.components.PrimaryButton
import com.familyflavours.ui.models.CartData
import com.familyflavours.ui.navigation.Routes
import com.familyflavours.ui.theme.robotoFontFamily
import com.familyflavours.ui.viewmodel.CartViewModel
import com.familyflavours.utils.DummyData.getCartItemList


@Composable
fun CartScreen(
    navController: NavController,
    modifier: Modifier
) {
    val cartViewModel: CartViewModel = hiltViewModel()
    val cartItems = remember { mutableStateOf(getCartItemList()) }
    //  val cartItems: List<CartItem> by cartViewModel.cartItems.collectAsState()

    fun increment(cartItem: CartData) {
        Log.d("Increment", "Clicked")
        val updatedList = cartItems.value.map {
            if (it == cartItem) {
                val updatedItem = it.copy(quantity = it.quantity + 1)
                updatedItem.copy(totalPrice = updatedItem.quantity * updatedItem.price)
            } else it
        }
        cartItems.value = updatedList
    }

    fun decrement(cartItem: CartData) {
        val updatedList = cartItems.value.map {
            if (it == cartItem && it.quantity > 1) {
                val updatedItem = it.copy(quantity = it.quantity - 1)
                updatedItem.copy(totalPrice = updatedItem.quantity * updatedItem.price)
            } else it
        }
        cartItems.value = updatedList
    }

    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Log.d("LazyColumn", "Called")
                items(cartItems.value) { item ->
                    com.familyflavours.ui.components.CartItem(
                        cartData = item,
                        onClickPlus = { increment(item) },
                        onClickMinus = { decrement(item) },
                        onClickDelete = {})
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .background(color = Color.White)
                .padding(horizontal = 25.dp, vertical = 10.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = stringResource(R.string.rs) + "${25}  ",
                        fontFamily = robotoFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = stringResource(R.string.total),
                        fontFamily = robotoFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.LightGray
                    )
                }

                PrimaryButton(
                    buttonText = "Checkout", modifier = Modifier
                        .width(150.dp)
                        .height(48.dp)
                        .align(Alignment.CenterEnd)
                ) {
                    navController.navigate(Routes.CheckoutScreen.route)
                }
            }


        }
    }

}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController(), Modifier)
}