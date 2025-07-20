package com.familyflavours.network.repository_imp


import com.familyflavours.network.data.CartItem
import com.familyflavours.network.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor() : CartRepository {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    override fun getCartItems(): Flow<List<CartItem>> {
        return _cartItems.asStateFlow()
    }
    init {
        _cartItems.value = listOf(
            CartItem("1", "Item 1", 10.0, 2),
            CartItem("2", "Item 2", 15.0, 1),
            CartItem("3", "Item 3", 20.0, 3),
        )
    }
    override suspend fun incrementCartItem(itemId: String) {
        _cartItems.update { currentCartItems ->
            currentCartItems.map { cartItem ->
                if (cartItem.id == itemId) {
                    cartItem.copy(quantity = cartItem.quantity + 1)
                } else {
                    cartItem
                }
            }
        }
    }

    override suspend fun decrementCartItem(itemId: String) {
        _cartItems.update { currentCartItems ->
            currentCartItems.map { cartItem ->
                if (cartItem.id == itemId && cartItem.quantity > 1) {
                    cartItem.copy(quantity = cartItem.quantity - 1)
                } else {
                    cartItem
                }
            }
        }
    }
}