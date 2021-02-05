package com.mikail.sauceshopping.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mikail.sauceshopping.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val childFragment = supportFragmentManager.findFragmentByTag("fragment_container") as? NavHostFragment
                ?: return
        binding.bottomNavigation.setupWithNavController(childFragment.findNavController())
    }
}