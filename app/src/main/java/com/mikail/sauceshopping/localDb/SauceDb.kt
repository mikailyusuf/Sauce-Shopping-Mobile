package com.mikail.sauceshopping.localDb

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
//    entities = [LoginResponse::class,Token::class],
    version = 1
)
abstract class SauceDb : RoomDatabase(){

    abstract fun getDao(): SauceDb
}