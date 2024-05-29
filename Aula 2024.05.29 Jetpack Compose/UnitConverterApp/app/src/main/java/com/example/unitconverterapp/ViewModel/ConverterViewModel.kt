package com.example.unitconverterapp.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverterapp.R
import com.example.unitconverterapp.data.Conversion
import com.example.unitconverterapp.data.ConversionResult
import com.example.unitconverterapp.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val repository: ConverterRepository,private val context: Context) : ViewModel() {

    @SuppressLint("StringFormatInvalid")
    fun getConversions() = listOf(
        Conversion(1, context.resources.getString(R.string.lb_kg),
            context.resources.getString(R.string.lb),
            context.resources.getString(R.string.kg),0.453592),
        Conversion(2,context.resources.getString(R.string.kg_lb),
            context.resources.getString(R.string.kg),
                context.resources.getString(R.string.lb),2.20462),
        Conversion(3,context.resources.getString(R.string.mi_km),
            context.resources.getString(R.string.mi),
                context.resources.getString(R.string.km),1.60934),
        Conversion(4,context.resources.getString(R.string.km_mi),
            context.resources.getString(R.string.km),
                context.resources.getString(R.string.mi),0.621371)
    )

    val resultList = repository.getSavedResults()

    fun addResult(message1 : String, message2 : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0,message1,message2))
        }
    }

    fun removeResult(item : ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(item)
        }
    }

    fun clearAll(){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteAllResults()
        }
    }

}