package com.familyflavours.ui.usecase

import com.familyflavours.network.data.CartItem
import com.familyflavours.network.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartItemsUseCase @Inject constructor(private val cartRepository: CartRepository) {
    operator fun invoke(): Flow<List<CartItem>> {
        return cartRepository.getCartItems()
    }
}