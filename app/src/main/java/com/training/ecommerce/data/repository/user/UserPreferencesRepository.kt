package com.training.ecommerce.data.repository.user

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    fun isUserLoggedIn(): Flow<Boolean>
    suspend fun setUserLoggedIn(isUserLoggedIn: Boolean)
    suspend fun getUserId(): Flow<String>
    suspend fun saveUserId(userId: String)
}