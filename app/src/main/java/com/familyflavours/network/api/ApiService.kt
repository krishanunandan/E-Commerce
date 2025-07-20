package com.familyflavours.network.api

import com.familyflavours.ui.models.ProductData
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductData>

}