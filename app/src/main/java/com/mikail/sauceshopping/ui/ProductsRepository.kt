package com.mikail.sauceshopping.ui

import com.mikail.sauceshopping.models.ProductsCategoryModel
import com.mikail.sauceshopping.models.ProductsModel
import com.mikail.sauceshopping.network.ApiHelper
import retrofit2.Response
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val apiHelper: ApiHelper){


    suspend fun getProducts(): Response<ProductsModel> = apiHelper.getProducts()

    suspend fun getProductsCategory(data: ProductsCategoryModel): Response<ProductsModel> =
            apiHelper.getProductsCategory(data)

}