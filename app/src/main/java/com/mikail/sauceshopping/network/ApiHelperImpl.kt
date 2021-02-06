package com.mikail.sauceshopping.network

import com.mikail.sauceshopping.localDb.SauceDao
import com.mikail.sauceshopping.models.*
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val api: SauceApi, private val dao: SauceDao):ApiHelper {

    override suspend fun login(loginData: LoginData): Response<LoginResponse> {
        return  api.login(loginData)
    }

    override suspend fun signUp(register: SignUpData): Response<LoginResponse> {

        return api.signUp(register)
    }

    override suspend fun getProducts(): Response<ProductsModel> {
        return api.getProducts()
    }

    override suspend fun getProductsCategory(data: ProductsCategoryModel): Response<ProductsModel> {
        return api.getProductsCategory(data)
    }
}