package com.mikail.sauceshopping.models

data class SignUpData(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val phone_number: String,
    val username: String
)