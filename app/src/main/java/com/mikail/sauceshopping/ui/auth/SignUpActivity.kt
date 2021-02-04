package com.mikail.sauceshopping.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mikail.sauceshopping.databinding.ActivitySignUpBinding
import com.mikail.sauceshopping.models.SignUpData
import com.mikail.sauceshopping.utils.Constants
import com.mikail.sauceshopping.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val button  = binding.signUp

        button.setOnClickListener {

            val fName = binding.firstName.text.toString()
            val lName = binding.lastName.text.toString()
            val email = binding.email.text.toString()
            val phone = binding.phone.text.toString()
            val password1 = binding.password1.text.toString()
            val password2 = binding.password2.text.toString()

            if (password1!=password2)
            {
                Toast.makeText(this,"Passwords Don't match",Toast.LENGTH_SHORT).show()
            }

            val data = SignUpData(email,fName,lName,password1,phone)
            viewModel.register(data)
        }

        viewModel.register.observe(this, Observer {response->
            when(response)
            {
                is Resource.Loading->{
                    showProgress()
                }
                is Resource.Success->{
                    hideProgress()
                    response.data?.let {
                        Log.d(Constants.TAG_VAL,it.toString())
                    }
                }
                is Resource.Error->{
                    hideProgress()
                    Log.d(Constants.TAG_VAL,"${response.message.toString()}")
                }
            }
        })
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