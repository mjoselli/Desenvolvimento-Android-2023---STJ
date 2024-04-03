package com.example.myrecyclerview.model

import android.content.Context
import java.io.IOException

object Singleton {
    var citySelected: City? = null
    val filename = "cities.txt"
    lateinit var dao: CityDao
    lateinit var cities: List<City>

    fun setContext(context: Context){
        CityDatabase.getInstance(context)?.apply {
            dao = cityDao()
            cities = dao.getAll()
        }
    }
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