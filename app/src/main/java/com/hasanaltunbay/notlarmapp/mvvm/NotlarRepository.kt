package com.hasanaltunbay.notlarmapp.mvvm

import androidx.lifecycle.LiveData
import com.hasanaltunbay.notlarmapp.db.Notlar
import com.hasanaltunbay.notlarmapp.db.NotlarDao

class NotlarRepository(val dao:NotlarDao){

    fun tumNotlar():LiveData<List<Notlar>>{
        return dao.getTumNotlar()
    }

    suspend fun insertNot(notlar: Notlar){
        dao.insertNot(notlar)
    }

    suspend fun updateNot(notlar: Notlar){
        dao.updateNot(notlar)
    }

    suspend fun deleteNot(notlar: Notlar){
        dao.deleteNot(notlar)
    }

}