package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.models.PaymentBreakup
import com.familyflavours.ui.theme.LightGray
import com.familyflavours.ui.theme.LightWhite

@Composable
fun PriceBreakupCard(paymentBreakup: PaymentBreakup) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = LightWhite)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Payment Breakup", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            PriceBreakupItem("Subtotal", paymentBreakup.subtotal)
            PriceBreakupItem(
                "Discount",
                -paymentBreakup.discount
            ) // Display discount as a negative value
            PriceBreakupItem("Taxes", paymentBreakup.taxes)
            PriceBreakupItem("Shipping", paymentBreakup.shipping)
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp),
                color = LightGray
            )
            PriceBreakupItem("Total", paymentBreakup.total, isBold = true)
        }
    }
}