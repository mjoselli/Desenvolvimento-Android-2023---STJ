package com.example.myrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrecyclerview.model.City
import com.example.myrecyclerview.model.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val cityRepository: CityRepository) : ViewModel(){
    var citiesLiveData = MutableLiveData<List<City>>()
    init {
        citiesLiveData.value = cityRepository.cities
    }

    fun get(pos: Int) = cityRepository.cities[pos]

    fun add(city: City){
        cityRepository.add(city)
        citiesLiveData.value = cityRepository.cities
    }

    fun refresh(){
        citiesLiveData.value = cityRepository.cities
    }

    fun delete(city: City){
        cityRepository.delete(city)
        citiesLiveData.value = cityRepository.cities
    }

    fun update(city: City){
        cityRepository.update(city)
        citiesLiveData.value = cityRepository.cities
    }
}