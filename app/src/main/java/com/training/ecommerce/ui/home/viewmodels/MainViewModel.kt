package com.training.ecommerce.ui.home.viewmodels

import androidx.lifecycle.ViewModel
import com.training.ecommerce.data.repository.user.UserDataStoreRepositoryImpl

class MainViewModel (
    private val userPrefs: UserDataStoreRepositoryImpl
) : ViewModel(){
    suspend fun isUserLoggedIn() = userPrefs.isUserLoggedIn()
}