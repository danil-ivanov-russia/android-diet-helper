package com.example.diethelperapp.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DietDAO.Diet::class] , version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dietDao(): DietDAO
}