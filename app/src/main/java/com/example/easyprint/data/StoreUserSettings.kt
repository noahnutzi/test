package com.example.easyprint.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserSettings (private val context: Context) {

    //create dataStore and dataStore-Keys
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserInput")
        val USER_IP_KEY = stringPreferencesKey("user_ip")
        val USER_API_KEY = stringPreferencesKey("user_api")
    }

    //To get the IP
    val getIP: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_IP_KEY] ?: ""
        }

    //To get the API-KEY
    val getAPI: Flow<String?> = context.dataStore.data
        .map { preferences ->
           preferences[USER_API_KEY] ?: ""
        }

    //To save the IP
    suspend fun saveIP(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_IP_KEY] = name
        }
    }

    //To save the API-KEY
    suspend fun saveAPI(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_API_KEY] = name
        }
    }
}

