package com.familyflavours.ui.usecase

import com.familyflavours.network.repository.CartRepository
import javax.inject.Inject

class IncrementCartItemUseCase @Inject constructor(private val cartRepository: CartRepository) :
    UseCase<IncrementCartItemUseCase.Params, Unit> {
    data class Params(val itemId: String)

    override suspend fun invoke(params: Params) {
        cartRepository.incrementCartItem(params.itemId)
    }
}