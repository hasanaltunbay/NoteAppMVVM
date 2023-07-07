package com.hasanaltunbay.notlarmapp.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NotlarFactoryViewMode(private val repository: NotlarRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotlarViewModel::class.java)){
            return NotlarViewModel(repository) as T
        }
        throw IllegalArgumentException("Bilinmeyen ViewModel Class")

    }
}