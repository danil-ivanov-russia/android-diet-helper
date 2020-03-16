package com.example.diethelperapp.db2

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [DietDAO.Diet::class,
        DietDAO.Dishes::class,
        DietDAO.CrossRefDietOwnDishes::class,
        DietDAO.Ingredients::class,
        DietDAO.ListIngredients::class,
    DietDAO.Calendar::class,
    DietDAO.CrossRefCalendarOwnDishes::class],
    version = 9
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDietDAO(): DietDAO


}