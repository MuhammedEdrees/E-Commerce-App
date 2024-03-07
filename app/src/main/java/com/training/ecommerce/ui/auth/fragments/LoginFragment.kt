package com.training.ecommerce.ui.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.training.ecommerce.R
import com.training.ecommerce.data.repository.user.UserDataStoreRepositoryImpl
import com.training.ecommerce.databinding.FragmentLoginBinding
import com.training.ecommerce.ui.auth.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
//    private lateinit var _binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by lazy {
        LoginViewModel(UserDataStoreRepositoryImpl(requireActivity().applicationContext))
    }
//    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        _binding.viewModel = viewModel
//        _binding.lifecycleOwner = this
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        val TAG = "LoginFragment"
    }
}