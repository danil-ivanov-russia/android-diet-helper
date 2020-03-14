package com.example.diethelperapp.DB2

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.diethelperapp.DB.DietDAO


@Database(
    entities = [DietDAO.Diet::class,
        DietDAO.Dishes::class,
        DietDAO.CrossRefDietOwnDishes::class,
        DietDAO.Ingredients::class,
        DietDAO.ListIngredients::class],
    version = 5
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDietDAO(): DietDAO


}