package com.mikail.sauceshopping.localDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikail.sauceshopping.models.LoginResponse


@Database(
    entities = [LoginResponse::class],
    version = 1
)
abstract class SauceDb : RoomDatabase(){

    abstract fun getDao(): SauceDb
}