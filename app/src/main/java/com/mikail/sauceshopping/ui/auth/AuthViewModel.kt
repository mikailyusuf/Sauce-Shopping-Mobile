package com.mikail.sauceshopping.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikail.sauceshopping.models.LoginData
import com.mikail.sauceshopping.models.LoginResponse
import com.mikail.sauceshopping.models.SignUpData
import com.mikail.sauceshopping.utils.NetWorkHelper
import com.mikail.sauceshopping.utils.Resource
import kotlinx.coroutines.launch
import java.io.IOException

class AuthViewModel @ViewModelInject constructor(private val repository: AuthRepository,
                                                  private val networkHelper: NetWorkHelper):ViewModel()
{
    val _login: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val login: LiveData<Resource<LoginResponse>> = _login


    val _register: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val register: LiveData<Resource<LoginResponse>> = _register


    fun login(loginData: LoginData) = viewModelScope.launch {
        loginUser(loginData)
    }

    fun register(data: SignUpData) = viewModelScope.launch {
        registerUser(data)
    }

    suspend fun loginUser(loginData: LoginData){
        _login.postValue(Resource.Loading())

        try {

            if(networkHelper.isNetworkConnected()){
                val response = repository.login(loginData)
                if (response.isSuccessful)
                {
                    response.body()?.let {
                        _login.postValue(Resource.Success(it))
                    }
                }
                else{
                    _login.postValue(Resource.Error(response.message()))
                }
            }
            else{
                _login.postValue(Resource.Error("No Internet Connection"))
            }
        }
        catch (t: Throwable){
            when (t) {
                is IOException -> _login.postValue(Resource.Error("Network Error"))
                else -> _login.postValue(Resource.Error("${t.message}"))
            }

        }

    }


    suspend fun registerUser(data : SignUpData){
        _register.postValue(Resource.Loading())

        try {

            if(networkHelper.isNetworkConnected()){
                val response = repository.signUp(data)
                if (response.isSuccessful)
                {
                    response.body()?.let {
                        _register.postValue(Resource.Success(it))
                    }
                }
                else{
                    _register.postValue(Resource.Error(response.message()))
                }
            }
            else{
                _register.postValue(Resource.Error("No Internet Connection"))
            }
        }
        catch (t: Throwable){
            when (t) {
                is IOException -> _register.postValue(Resource.Error("Network Error"))
                else -> _register.postValue(Resource.Error("${t.message}"))
            }

        }

    }


}