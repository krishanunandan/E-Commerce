package com.familyflavours.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.familyflavours.ui.models.Discount
import com.familyflavours.ui.theme.LightWhite
import com.familyflavours.ui.theme.robotoFontFamily


@Composable
fun DiscountCard(
    discountCode: String,
    appliedDiscount: Discount?,
    onDiscountCodeChange: (String) -> Unit,
    onApplyDiscount: () -> Unit,
    onRemoveDiscount: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = LightWhite)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Apply Discount", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = discountCode,
                    onValueChange = onDiscountCodeChange,
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Enter discount code") },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        focusedTextColor = Color.Blue,
                        focusedBorderColor = Color.Blue,
                        errorBorderColor = Color.Red,
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = onApplyDiscount,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Blue)
                ) {
                    Text("Apply", fontFamily = robotoFontFamily)
                }
            }
            appliedDiscount?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Discount Applied: ${it.code} (-$${it.amount})")
                    Spacer(modifier = Modifier.size(8.dp))
                    Button(onClick = onRemoveDiscount) {
                        Text("Remove", fontFamily = robotoFontFamily)
                    }
                }
            }
        }
    }
}