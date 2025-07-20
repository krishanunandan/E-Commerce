package com.familyflavours.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun CartIconWithBadge() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (cartIcon, badge) = createRefs()

        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Cart",
            modifier = Modifier.size(64.dp)
                .constrainAs(cartIcon) {
                    centerTo(parent)
                }
        )

        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color.Red, shape = CircleShape)
                .constrainAs(badge) {
                    top.linkTo(cartIcon.top)
                    end.linkTo(cartIcon.end)
                }
        ) {
            Text(
                text = "3",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun CartIconWithBadgePreview() {
    CartIconWithBadge()
}