package com.mikail.sauceshopping.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mikail.sauceshopping.databinding.ActivityLoginBinding
import com.mikail.sauceshopping.models.LoginData
import com.mikail.sauceshopping.utils.Constants.TAG_VAL
import com.mikail.sauceshopping.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()



    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.logIn.setOnClickListener {
            val email = binding.email.toString()
            val password = binding.password.toString()

            val loginData = LoginData(email,password)
            viewModel.login(loginData)
        }

        viewModel.login.observe(this, Observer {response->
            when(response){

                is Resource.Loading->{showProgress()}
                is Resource.Success->{hideProgress()
                    hideProgress()
                    response.data?.let {
                        Log.d(TAG_VAL,it.toString())
                    }

                }
                is Resource.Error ->{
                    hideProgress()
                    Log.d(TAG_VAL,"${response.message.toString()}")



                }

            }
        })


        binding.signUp.setOnClickListener {

            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
    fun showProgress()
    {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideProgress()
    {
        binding.progressBar.visibility = View.INVISIBLE
    }
}