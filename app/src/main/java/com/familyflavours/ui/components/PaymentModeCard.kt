package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.familyflavours.ui.models.PaymentMode
import com.familyflavours.ui.theme.LightWhite


@Composable
fun PaymentModeCard(
    paymentModes: List<PaymentMode>,
    selectedPaymentMode: PaymentMode,
    onPaymentModeChange: (PaymentMode) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = LightWhite)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Payment Mode", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            paymentModes.forEach { paymentMode ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (paymentMode == selectedPaymentMode),
                            onClick = { onPaymentModeChange(paymentMode) },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (paymentMode == selectedPaymentMode),
                        onClick = { onPaymentModeChange(paymentMode) },
                        colors = RadioButtonDefaults.colors()
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = paymentMode.name)
                }
                if (paymentMode != paymentModes.last()) {
                    Divider()
                }
            }
        }
    }
}