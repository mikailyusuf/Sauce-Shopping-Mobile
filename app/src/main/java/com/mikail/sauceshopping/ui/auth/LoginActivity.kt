package com.mikail.sauceshopping.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikail.sauceshopping.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}