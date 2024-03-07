package com.training.ecommerce.data.source.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.training.ecommerce.data.source.datastore.DataStoreKeys.E_COMMERCE_PREFERENCES

object DataStoreKeys {
    const val E_COMMERCE_PREFERENCES = "E_COMMERCE_PREFERENCES"
    val isUserLoggedIn = booleanPreferencesKey("isUserLoggedIn")
    val USER_ID = stringPreferencesKey("USER_ID")
}
val Context.dataStore by preferencesDataStore(name = E_COMMERCE_PREFERENCES)