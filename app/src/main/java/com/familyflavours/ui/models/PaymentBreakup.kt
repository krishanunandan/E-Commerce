package com.familyflavours.ui.models

data class PaymentBreakup(
    val subtotal: Double,
    val discount: Double,
    val taxes: Double,
    val shipping: Double,
    val total: Double
)