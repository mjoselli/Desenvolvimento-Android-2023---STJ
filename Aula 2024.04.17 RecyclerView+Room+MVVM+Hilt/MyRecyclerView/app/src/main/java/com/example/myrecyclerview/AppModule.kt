package com.example.myrecyclerview

import android.content.Context
import androidx.room.Room
import com.example.myrecyclerview.model.CityDao
import com.example.myrecyclerview.model.CityDatabase
import com.example.myrecyclerview.model.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app:Context) =
        Room.databaseBuilder(app,CityDatabase::class.java,"city.sqlite")
            .allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideDao(db: CityDatabase) = db.cityDao()

    @Singleton
    @Provides
    fun provideRepository(dao: CityDao) = CityRepository(dao)
}