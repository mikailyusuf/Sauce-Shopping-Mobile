package com.mikail.sauceshopping.localDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikail.sauceshopping.models.DummyTable


@Database(
    entities = [DummyTable::class],
    version = 1
)
abstract class SauceDb : RoomDatabase(){

    abstract fun getDao(): SauceDao
}