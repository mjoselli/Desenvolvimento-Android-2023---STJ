package com.example.unitconverterapp.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.example.unitconverterapp.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository, private val context: Context) : NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ConverterViewModel(repository,context) as T

}

