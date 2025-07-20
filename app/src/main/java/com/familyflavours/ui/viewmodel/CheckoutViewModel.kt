package com.familyflavours.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.familyflavours.ui.models.AddressData
import com.familyflavours.ui.models.Discount
import com.familyflavours.ui.models.PaymentBreakup
import com.familyflavours.ui.models.PaymentMode


class CheckoutViewModel : ViewModel() {

    // Address State
    private val _allAddresses = mutableStateListOf(
        AddressData(
            1,
            "John Doe",
            "555-123-4567",
            "Apt 4B",
            "Delhi",
            "Delhi",
            "110092",
            "India"
        ),
        AddressData(
            2,
            "Jane Smith",
            "555-987-6543",
            "Springfield Test",
            "Noida",
            "UP",
            "110096",
            "India"
        )
    )
    var selectedAddress = mutableStateOf(_allAddresses[0])
        private set

    fun updateSelectedAddress(address: AddressData) {
        selectedAddress.value = address
    }

    // Discount State
    var appliedDiscount = mutableStateOf<Discount?>(null)
        private set
    var discountCode = mutableStateOf("")
        private set

    fun updateDiscountCode(code: String) {
        discountCode.value = code
    }

    fun applyDiscount() {
        // In a real app, you'd validate the discount code against a backend
        if (discountCode.value == "SAVE10") {
            appliedDiscount.value = Discount("SAVE10", 10.0)
        } else {
            appliedDiscount.value = null
        }
    }

    fun removeDiscount() {
        appliedDiscount.value = null
        discountCode.value = ""
    }

    // Payment Breakup State (example values)
    var paymentBreakup = mutableStateOf(
        PaymentBreakup(
            subtotal = 100.0,
            discount = appliedDiscount.value?.amount ?: 0.0,
            taxes = 8.0,
            shipping = 5.0,
            total = 100.0
        )
    )
        private set

    fun updatePaymentBreakup() {
        val total = paymentBreakup.value.subtotal - (appliedDiscount.value?.amount
            ?: 0.0) + paymentBreakup.value.taxes + paymentBreakup.value.shipping
        paymentBreakup.value = paymentBreakup.value.copy(
            discount = appliedDiscount.value?.amount ?: 0.0,
            total = total
        )
    }

    // Payment Mode State
    val paymentModes = listOf(
        PaymentMode(1, "UPI"),
        PaymentMode(2, "Credit/Debit Card"),
        PaymentMode(3, "Net Banking"),
        PaymentMode(4, "Cash on Delivery")
    )
    var selectedPaymentMode = mutableStateOf(paymentModes[0])
        private set

    fun updateSelectedPaymentMode(mode: PaymentMode) {
        selectedPaymentMode.value = mode
    }

    init {
        updatePaymentBreakup()
    }

}