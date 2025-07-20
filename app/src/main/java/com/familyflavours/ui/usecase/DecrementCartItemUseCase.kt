package com.familyflavours.ui.usecase

import com.familyflavours.network.repository.CartRepository
import javax.inject.Inject

class DecrementCartItemUseCase @Inject constructor(private val cartRepository: CartRepository) :
    UseCase<DecrementCartItemUseCase.Params, Unit> {
    data class Params(val itemId: String)

    override suspend fun invoke(params: Params) {
        cartRepository.decrementCartItem(params.itemId)
    }
}