package com.mikail.sauceshopping.ui.auth

import com.mikail.sauceshopping.models.LoginData
import com.mikail.sauceshopping.models.LoginResponse
import com.mikail.sauceshopping.models.SignUpData
import com.mikail.sauceshopping.network.ApiHelper
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiHelper:ApiHelper) {

     suspend fun login(loginData: LoginData): Response<LoginResponse>  = apiHelper.login(loginData)

     suspend fun signUp(register: SignUpData): Response<LoginResponse> =  apiHelper.signUp(register)

}