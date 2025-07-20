package com.familyflavours.ui.models

data class AddressData(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val address: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)