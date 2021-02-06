package com.mikail.sauceshopping.network

import com.mikail.sauceshopping.models.*
import retrofit2.Response

interface ApiHelper {

    suspend fun login(loginData: LoginData): Response<LoginResponse>

    suspend fun signUp(register: SignUpData): Response<LoginResponse>
    suspend fun getProducts(): Response<ProductsModel>
    suspend fun getProductsCategory(data: ProductsCategoryModel): Response<ProductsModel>
}