package com.hasanaltunbay.notlarmapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotlarDao {

    @Query("SELECT * FROM NOTLAR")
    fun getTumNotlar():LiveData<List<Notlar>>

    @Insert
    suspend fun insertNot(notlar: Notlar)

    @Update
    suspend fun updateNot(notlar: Notlar)

    @Delete
    suspend fun deleteNot(notlar: Notlar)

}