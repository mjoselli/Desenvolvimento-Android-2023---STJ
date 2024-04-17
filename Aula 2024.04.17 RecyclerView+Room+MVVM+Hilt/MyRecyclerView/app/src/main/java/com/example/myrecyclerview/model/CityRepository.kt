package com.example.myrecyclerview.model

import javax.inject.Inject


class CityRepository @Inject constructor(var dao: CityDao) {
    var cities = dao.getAll()

    fun add(city: City){
        dao.insertAll(city)
        cities = dao.getAll()
    }
    fun update(city: City){
        dao.update(city)
        cities = dao.getAll()
    }
    fun delete(city: City){
        dao.delete(city)
        cities = dao.getAll()
    }
}