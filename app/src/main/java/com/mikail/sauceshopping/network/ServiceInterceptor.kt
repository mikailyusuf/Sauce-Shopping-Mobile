package com.mikail.sauceshopping.network

import com.mikail.sauceshopping.utils.dataStore.getToken
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor:Interceptor {
    val token = runBlocking {
    getToken

}

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if(request.header("No-Authentication")==null){
                val finalToken =  "Bearer "+token
                request = request.newBuilder()
                    .addHeader("Authorization",finalToken)
                    .build()

        }

        return chain.proceed(request)
    }

}
