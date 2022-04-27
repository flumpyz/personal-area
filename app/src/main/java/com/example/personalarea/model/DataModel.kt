package com.example.personalarea.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {
    val message: MutableLiveData<Balance> by lazy {
        MutableLiveData<Balance>()
    }
}