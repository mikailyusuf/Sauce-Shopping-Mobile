package com.mikail.sauceshopping.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class LoginResponse(
        val email: String,
        val tokens: Tokens
)


@Entity(tableName = "dummy")
data class DummyTable(@PrimaryKey val id:Int, val name:String)