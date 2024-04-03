package com.example.myrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cities")
data class City(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(index = true)
    var name: String,
    var population: Int,
    @ColumnInfo(name="Capital", defaultValue = "false")
    var isCapital: Boolean = false)

