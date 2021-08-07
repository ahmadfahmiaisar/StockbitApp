package com.example.stockbitapp.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import com.example.base.abstraction.BaseActivityBinding
import com.example.stockbitapp.databinding.ActivityLoginBinding
import com.example.stockbitapp.presentation.main.MainActivity

class LoginActivity : BaseActivityBinding<ActivityLoginBinding>() {
    override val getViewBinding: (LayoutInflater) -> ActivityLoginBinding
        get() = ActivityLoginBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogin.setOnClickListener {
            MainActivity.start(this)
        }
    }
}