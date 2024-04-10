package com.example.myrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrecyclerview.model.City
import com.example.myrecyclerview.model.Singleton

class MainViewModel : ViewModel(){
    var citiesLiveData = MutableLiveData<List<City>>()

    fun add(city: City){
        Singleton.add(city)
        citiesLiveData.value = Singleton.cities
    }

    fun delete(city: City){
        Singleton.delete(city)
        citiesLiveData.value = Singleton.cities
    }

    fun update(city: City){
        Singleton.update(city)
        citiesLiveData.value = Singleton.cities
    }

}