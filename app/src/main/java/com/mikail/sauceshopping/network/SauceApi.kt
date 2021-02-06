package com.mikail.sauceshopping.network

import com.mikail.sauceshopping.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface SauceApi {

    @Headers("Content-Type: application/json")
    @POST("/api/auth/login/")
    suspend fun login(@Body loginData: LoginData): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/auth/register")
    suspend fun signUp(@Body register: SignUpData): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @GET("/api/products/products")
    suspend fun getProducts(): Response<ProductsModel>

    @Headers("Content-Type: application/json")
    @POST("/api/products/products_category")
    suspend fun getProductsCategory(@Body data: ProductsCategoryModel): Response<ProductsModel>


//    @POST("/auth/login/")
//    suspend fun login(loginData: LoginData): Response<LoginResponse>
//
//    @POST("/auth/login/")
//    suspend fun login(loginData: LoginData): Response<LoginResponse>
}