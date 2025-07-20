package com.familyflavours.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.familyflavours.ui.usecase.DecrementCartItemUseCase
import com.familyflavours.ui.usecase.GetCartItemsUseCase
import com.familyflavours.ui.usecase.IncrementCartItemUseCase
import com.familyflavours.ui.viewmodel.CartViewModel

class CartViewModelFactory(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val incrementCartItemUseCase: IncrementCartItemUseCase,
    private val decrementCartItemUseCase: DecrementCartItemUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CartViewModel(
                getCartItemsUseCase,
                incrementCartItemUseCase,
                decrementCartItemUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}