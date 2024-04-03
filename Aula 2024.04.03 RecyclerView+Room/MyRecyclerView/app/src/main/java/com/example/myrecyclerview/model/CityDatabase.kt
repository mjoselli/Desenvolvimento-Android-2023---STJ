package com.example.myrecyclerview.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [City::class], version = 1)
abstract class CityDatabase: RoomDatabase() {
    abstract fun cityDao(): CityDao
    companion object{
        private var INSTANCE: CityDatabase? = null
        fun getInstance(context: Context): CityDatabase?{
            if (INSTANCE == null){
                synchronized(CityDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CityDatabase::class.java,
                        "city.sqlite"
                        ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
        fun destroyDatabase(){
            INSTANCE = null
        }
    }
}