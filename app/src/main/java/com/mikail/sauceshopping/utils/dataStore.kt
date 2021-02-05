package com.mikail.sauceshopping.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import com.mikail.sauceshopping.di.SauceApplication.Companion.applicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object dataStore {

    private val dataStore: DataStore<Preferences> = applicationContext().createDataStore(
        name = "userToken"
    )

    suspend fun addToken(token:String)
    {
        dataStore.edit { userToken ->
            userToken[TOKEN_KEY] = token
        }

    }


    private val TOKEN_KEY = stringPreferencesKey("token")
    val getToken: Flow<String?> = dataStore.data
        .map { preferences ->
            // No type safety.
            preferences[TOKEN_KEY]?:null
        }

}