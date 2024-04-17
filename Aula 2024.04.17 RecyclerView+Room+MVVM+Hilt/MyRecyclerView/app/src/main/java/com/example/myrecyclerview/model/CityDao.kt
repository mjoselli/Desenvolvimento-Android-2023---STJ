package com.example.myrecyclerview.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CityDao {
    //C - Create (criar)
    @Insert
    fun insertAll(vararg city: City)

    //R - Retrieve (ler)
    @Query("Select * from Cities")
    fun getAll(): List<City>
    @Query("Select * from Cities where name = :name")
    fun getByName(name:String): List<City>

    //U - Update (atualizar)
    @Update
    fun update(city: City): Int

    //D - Delete (deletar)
    @Delete
    fun delete(city: City): Int
}