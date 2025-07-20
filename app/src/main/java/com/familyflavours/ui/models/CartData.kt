package com.familyflavours.ui.models

import com.familyflavours.network.data.CartItem

data class CartData(
    val id: Int,
    val name: String,
    val unit: String,
    val price: Double,
    var totalPrice: Double,
    val imageUrl: String,
    var quantity: Int = 1
)
fun CartData.toCartItem(): CartItem {
    return CartItem(
        id = this.id.toString(),
        name = this.name,
        price = this.price,
        quantity = this.quantity
    )
}
