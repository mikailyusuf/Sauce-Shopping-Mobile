package com.mikail.sauceshopping.network

import com.mikail.sauceshopping.models.LoginData
import com.mikail.sauceshopping.models.LoginResponse
import com.mikail.sauceshopping.models.SignUpData
import retrofit2.Response
import retrofit2.http.POST

interface SauceApi {

    @POST("/auth/login/")
    suspend fun login(loginData: LoginData): Response<LoginResponse>

    @POST("/auth/register")
    suspend fun signUp(register: SignUpData): Response<LoginResponse>


//    @POST("/auth/login/")
//    suspend fun login(loginData: LoginData): Response<LoginResponse>
//
//    @POST("/auth/login/")
//    suspend fun login(loginData: LoginData): Response<LoginResponse>
}