package com.familyflavours.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.familyflavours.network.data.CartItem
import com.familyflavours.ui.usecase.DecrementCartItemUseCase
import com.familyflavours.ui.usecase.GetCartItemsUseCase
import com.familyflavours.ui.usecase.IncrementCartItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val incrementCartItemUseCase: IncrementCartItemUseCase,
    private val decrementCartItemUseCase: DecrementCartItemUseCase
) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems = _cartItems.asStateFlow()

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        viewModelScope.launch {
            getCartItemsUseCase().collectLatest {
                _cartItems.value = it
            }
        }
    }

    fun incrementItem(itemId: String) {
        viewModelScope.launch {
            incrementCartItemUseCase(IncrementCartItemUseCase.Params(itemId))
        }
    }

    fun decrementItem(itemId: String) {
        viewModelScope.launch {
            decrementCartItemUseCase(DecrementCartItemUseCase.Params(itemId))
        }
    }
}
