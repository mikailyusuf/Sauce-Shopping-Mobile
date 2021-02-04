package com.mikail.sauceshopping.network

import com.mikail.sauceshopping.localDb.SauceDao
import com.mikail.sauceshopping.models.LoginData
import com.mikail.sauceshopping.models.LoginResponse
import com.mikail.sauceshopping.models.SignUpData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(api: SauceApi, dao: SauceDao):ApiHelper {

    override suspend fun login(loginData: LoginData): Response<LoginResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(register: SignUpData): Response<LoginResponse> {
        TODO("Not yet implemented")
    }
}