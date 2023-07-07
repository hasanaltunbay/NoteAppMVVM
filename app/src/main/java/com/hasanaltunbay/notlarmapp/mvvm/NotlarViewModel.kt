package com.hasanaltunbay.notlarmapp.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanaltunbay.notlarmapp.db.Notlar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotlarViewModel(private val repo:NotlarRepository):ViewModel() {


    val inputBaslik=MutableLiveData<String>()
    val inputAltBaslik=MutableLiveData<String>()
    val inputNotGir=MutableLiveData<String>()

    val displayTumNotlar=repo.tumNotlar()

    fun ekleNot(){
        val baslik=inputBaslik.value
        val altbaslik=inputAltBaslik.value
        val notgir=inputNotGir.value

        insertNot(Notlar(0,baslik!!,altbaslik!!,notgir!!))
    }

    fun insertNot(notlar: Notlar)=viewModelScope.launch {
        Dispatchers.IO

        repo.insertNot(notlar)
    }

    fun duzenleNot(id: Int, baslik: String, altbaslik: String, notgir: String){

        guncelleNot(Notlar(id,baslik,altbaslik,notgir))

    }

    fun guncelleNot(notlar: Notlar)=viewModelScope.launch { Dispatchers.IO
    repo.updateNot(notlar)
    }

    fun silNot(notlar: Notlar)=viewModelScope.launch {Dispatchers.IO
        repo.deleteNot(notlar)
    }


}