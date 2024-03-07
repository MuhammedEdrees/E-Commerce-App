package com.training.ecommerce.ui.home

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.training.ecommerce.R
import com.training.ecommerce.data.repository.user.UserDataStoreRepositoryImpl
import com.training.ecommerce.ui.auth.AuthenticationActivity
import com.training.ecommerce.ui.home.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        MainViewModel(UserDataStoreRepositoryImpl(applicationContext))
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        lifecycleScope.launch (Dispatchers.Main){
            val  isLoggedIn = viewModel.isUserLoggedIn().first()
            Log.d("SEERDE", "onCreate: $isLoggedIn")
            if (!isLoggedIn) {
                navigateToAuthenticationActivity()
            } else {
                setContentView(R.layout.activity_main)
            }
        }
    }
    private fun navigateToAuthenticationActivity() {
        val intent = Intent(this, AuthenticationActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val options = ActivityOptions.makeCustomAnimation(
            this, android.R.anim.fade_in, android.R.anim.fade_out
        )
        startActivity(intent, options.toBundle())
    }
}