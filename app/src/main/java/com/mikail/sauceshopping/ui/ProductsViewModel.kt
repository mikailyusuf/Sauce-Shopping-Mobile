package com.mikail.sauceshopping.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikail.sauceshopping.models.ProductsCategoryModel
import com.mikail.sauceshopping.models.ProductsModel
import com.mikail.sauceshopping.utils.NetWorkHelper
import com.mikail.sauceshopping.utils.Resource
import kotlinx.coroutines.launch
import java.io.IOException

class ProductsViewModel@ViewModelInject constructor(private val repository: ProductsRepository,
                                                    private val networkHelper: NetWorkHelper): ViewModel() {

    val _products: MutableLiveData<Resource<ProductsModel>> = MutableLiveData()
    val products: LiveData<Resource<ProductsModel>> = _products


    val _productsCategory: MutableLiveData<Resource<ProductsModel>> = MutableLiveData()
    val productsCategory: LiveData<Resource<ProductsModel>> = _productsCategory



    fun getProducts() = viewModelScope.launch {
        products()
    }

    fun getProductsCategory(data: ProductsCategoryModel) = viewModelScope.launch {
        productsCategory(data)
    }

    suspend fun products(){
        _products.postValue(Resource.Loading())

        try {

            if(networkHelper.isNetworkConnected()){
                val response = repository.getProducts()
                if (response.isSuccessful)
                {
                    response.body()?.let {
                        _products.postValue(Resource.Success(it))
                    }
                }
                else{
                    _products.postValue(Resource.Error(response.message()))
                }
            }
            else{
                _products.postValue(Resource.Error("No Internet Connection"))
            }
        }
        catch (t: Throwable){
            when (t) {
                is IOException -> _products.postValue(Resource.Error("Network Error"))
                else -> _products.postValue(Resource.Error("${t.message}"))
            }

        }

    }
    suspend fun productsCategory(data:ProductsCategoryModel){
        _productsCategory.postValue(Resource.Loading())

        try {

            if(networkHelper.isNetworkConnected()){
                val response = repository.getProductsCategory(data)
                if (response.isSuccessful)
                {
                    response.body()?.let {
                        _productsCategory.postValue(Resource.Success(it))
                    }
                }
                else{
                    _productsCategory.postValue(Resource.Error(response.message()))
                }
            }
            else{
                _productsCategory.postValue(Resource.Error("No Internet Connection"))
            }
        }
        catch (t: Throwable){
            when (t) {
                is IOException -> _productsCategory.postValue(Resource.Error("Network Error"))
                else -> _productsCategory.postValue(Resource.Error("${t.message}"))
            }

        }

    }


}