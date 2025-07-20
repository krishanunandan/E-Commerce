package com.familyflavours.utils

import android.app.Notification
import androidx.compose.runtime.mutableStateListOf
import com.familyflavours.R
import com.familyflavours.ui.models.CartData
import com.familyflavours.ui.models.CategoryData
import com.familyflavours.ui.models.CategoryList
import com.familyflavours.ui.models.FilterData
import com.familyflavours.ui.models.NotificationData
import com.familyflavours.ui.models.ProductData
import com.familyflavours.ui.models.ProductQuantityData
import com.familyflavours.ui.models.SliderData

object DummyData {

    fun getSliderImages(): List<SliderData> {
        val sliderArray = ArrayList<SliderData>()
        sliderArray.add(SliderData(1, "https://picsum.photos/200/300"))
        sliderArray.add(SliderData(2, "https://picsum.photos/200/300"))
        sliderArray.add(SliderData(3, "https://picsum.photos/200/300"))
        return sliderArray
    }

    fun getProductList(): List<ProductData> {
        return listOf(
            ProductData(
                productName = "Product 1",
                productImage = "https://picsum.photos/200/300",
                productUnit = "250 gram",
                productPrice = 25,
            ),
            ProductData(
                productName = "Product 2",
                productImage = "https://picsum.photos/200/300",
                productUnit = "500 gram",
                productPrice = 50,
            ),
            ProductData(
                productName = "Product 3",
                productImage = "https://picsum.photos/200/300",
                productUnit = "200 gram",
                productPrice = 20,
            ),
            ProductData(
                productName = "Product 4",
                productImage = "https://picsum.photos/200/300",
                productUnit = "100 gram",
                productPrice = 10,
            ),
            ProductData(
                productName = "Product 5",
                productImage = "https://picsum.photos/200/300",
                productUnit = "100 gram",
                productPrice = 15,
            ),
            ProductData(
                productName = "Product 6",
                productImage = "https://picsum.photos/200/300",
                productUnit = "100 gram",
                productPrice = 35,
            )
        )
    }

    fun getProductQuantityList(): List<ProductQuantityData> {
        return listOf(
            ProductQuantityData(
                unit = "200 gram",
                price = "Rs.20.00",
            ),
            ProductQuantityData(
                unit = "250 gram",
                price = "Rs.30.00",
            ),
            ProductQuantityData(
                unit = "500 gram",
                price = "Rs.50.00",
            )
        )
    }

    fun getCategoryList(): List<CategoryList> {
        val categoryList = ArrayList<CategoryList>()
        val categoryListData = ArrayList<CategoryData>()
        categoryListData.add(CategoryData(1, "Category 1", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(2, "Category 2", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(3, "Category 3", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(4, "Category 4", "https://picsum.photos/200/300"))
        categoryList.add(CategoryList("Title 1", categoryListData))
        categoryList.add(CategoryList("Title 2", categoryListData))
        categoryList.add(CategoryList("Title 3", categoryListData))

        return categoryList
    }

    fun getCategoryListData(): List<CategoryData> {
        val categoryListData = ArrayList<CategoryData>()
        categoryListData.add(CategoryData(1, "Category 1", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(2, "Category 2", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(3, "Category 3", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(4, "Category 4", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(5, "Category 5", "https://picsum.photos/200/300"))
        categoryListData.add(CategoryData(6, "Category 6", "https://picsum.photos/200/300"))
        return categoryListData
    }

    fun getNotificationList(): List<NotificationData> {
        return listOf(
            NotificationData(
                id = 1,
                type = "A",
                title = "Notification Title 1",
                message = "Test notification message",
                createdOn = "03/04/2025"
            ),
            NotificationData(
                id = 1,
                type = "A",
                title = "Notification Title 1",
                message = "Test notification message",
                createdOn = "02/04/2025"
            ),
            NotificationData(
                id = 1,
                type = "A",
                title = "Notification Title 1",
                message = "Test notification message",
                createdOn = "01/04/2025"
            ),
            NotificationData(
                id = 1,
                type = "A",
                title = "Notification Title 1",
                message = "Test notification message",
                createdOn = "31/03/2025"
            )
        )
    }

    fun getCartItemList(): List<CartData> {
        return mutableStateListOf(
            CartData(
                id = 1,
                name = "Product 1",
                unit = "100 Gram",
                price = 10.00,
                totalPrice = 10.00,
                imageUrl = "https://picsum.photos/200/300",
                quantity = 1
            ),
            CartData(
                id = 1,
                name = "Product 2",
                unit = "200 Gram",
                price = 20.00,
                totalPrice = 20.00,
                imageUrl = "https://picsum.photos/200/300",
                quantity = 1
            ),
            CartData(
                id = 1,
                name = "Product 3",
                unit = "300 Gram",
                price = 30.00,
                totalPrice = 30.00,
                imageUrl = "https://picsum.photos/200/300",
                quantity = 1
            ),
            CartData(
                id = 1,
                name = "Product 4",
                unit = "400 Gram",
                price = 40.00,
                totalPrice = 40.00,
                imageUrl = "https://picsum.photos/200/300",
                quantity = 1
            )
        )
    }

    fun getFilterItemList(): List<FilterData> {
        return listOf(
            FilterData(id = 1, title = "Sub Category 1"),
            FilterData(id = 2, title = "Sub Category 2"),
            FilterData(id = 3, title = "Sub Category 3"),
            FilterData(id = 4, title = "Sub Category 4"),
            FilterData(id = 5, title = "Sub Category 5"),
            FilterData(id = 6, title = "Sub Category 6"),
            FilterData(id = 7, title = "Sub Category 7"),
            FilterData(id = 8, title = "Sub Category 8"),
            FilterData(id = 9, title = "Sub Category 9"),
            FilterData(id = 10, title = "Sub Category 10"),
            FilterData(id = 11, title = "Sub Category 11")
        )
    }
}