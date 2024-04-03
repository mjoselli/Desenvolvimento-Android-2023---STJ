package com.example.myrecyclerview.model

import android.content.Context
import java.io.IOException
//Migrar das cidades salvas em arquivo para salva-las no Room https://developer.android.com/training/data-storage/room?hl=pt-br
object Singleton {
    var cities = ArrayList<City>()
    var indexSelected = -1
    val filename = "cities.txt"

    public fun loadCitiesFromFile(context: Context) {
        val fileContents = loadFromFile(context, filename)
        fileContents?.let {
            val cities = it.split("\n").map {
                val cityData = it.split(",")
                if (cityData.size != 3) {
                    return
                }
                City(cityData[0], cityData[1].toInt(), cityData[2].toBoolean())
            }
            Singleton.cities.clear()
            Singleton.cities.addAll(cities)
        }
    }
    public fun saveCitiesToFile(context: Context) {
        val fileContents = cities.joinToString("\n") {
            "${it.name},${it.population},${it.isCapital}"
        }
        saveToFile(context, filename, fileContents)
    }

    private fun saveToFile(context:Context, filename:String, fileContents:String){
        context.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())
        }
    }

    private fun loadFromFile(context:Context, filename:String) : String? {
        return try {
            context.openFileInput(filename).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        } catch (e: IOException) {
            null
        }
    }
}