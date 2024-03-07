package com.training.ecommerce.data.repository.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.training.ecommerce.data.source.datastore.DataStoreKeys
import com.training.ecommerce.data.source.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataStoreRepositoryImpl(private val context: Context): UserPreferencesRepository{
    override fun isUserLoggedIn(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[DataStoreKeys.isUserLoggedIn] ?: false
    }
    override suspend fun setUserLoggedIn(isUserLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DataStoreKeys.isUserLoggedIn] = isUserLoggedIn
        }
    }

    override suspend fun getUserId(): Flow<String> {
        return context.dataStore.data.map {preferences ->
            preferences[DataStoreKeys.USER_ID] ?: ""
        }
    }

    override suspend fun saveUserId(userId: String) {
        context.dataStore.edit { preferences ->
            preferences[DataStoreKeys.USER_ID] = userId
        }
    }
}