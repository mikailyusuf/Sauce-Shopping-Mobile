package com.mikail.sauceshopping.localDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mikail.sauceshopping.models.DummyTable

@Dao
interface SauceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(patient: DummyTable):Long

}
