package com.training.ecommerce.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.training.ecommerce.data.repository.user.UserPreferencesRepository

class LoginViewModel(
    private val userDataStoreRepository: UserPreferencesRepository
): ViewModel() {

}