package com.example.diethelperapp.DB2

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.diethelperapp.DB.DietDAO

@Database(
    entities = [DietDAO.Diet::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDietDAO(): DietDAO
}