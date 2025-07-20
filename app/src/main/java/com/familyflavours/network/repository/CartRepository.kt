package com.familyflavours.network.repository


import com.familyflavours.network.data.CartItem
import kotlinx.coroutines.flow.Flow



interface CartRepository {
    fun getCartItems(): Flow<List<CartItem>>
    suspend fun incrementCartItem(itemId: String)
    suspend fun decrementCartItem(itemId: String)
    //suspend fun deleteItemFromCart(itemId: String)
}

