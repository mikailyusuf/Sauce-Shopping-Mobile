package com.mikail.sauceshopping.models

data class ProductsModelItem(
    val category: String,
    val date_created: String,
    val id: Int,
    val images: List<Any>,
    val max_delivery_time: String,
    val price: String,
    val product_description: String,
    val product_name: String,
    val units_available: Int,
    val user: Int
)