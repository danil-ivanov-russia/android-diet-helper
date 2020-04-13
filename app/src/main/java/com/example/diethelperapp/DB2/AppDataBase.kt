package com.example.diethelperapp.db2

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.diethelperapp.db2.typeConverter.Converters


@Database(
    entities = [DietDAO.Diet::class,
        DietDAO.Dishes::class,
        DietDAO.CrossRefDietOwnDishes::class,
        DietDAO.Ingredients::class,
        DietDAO.ListIngredients::class,
        DietDAO.Calendar::class,
        DietDAO.CrossRefCalendarOwnDishes::class,
        DietDAO.User::class],
    version = 34
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDietDAO(): DietDAO


}