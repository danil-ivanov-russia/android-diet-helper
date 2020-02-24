package com.example.diethelperapp.DB

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.diethelperapp.recipe.RecipeRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


class App : Application() {
    private var database: AppDatabase? = null
    private val db_work = WorkWithDB()


    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
        db_work.FillTable()






    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object {
        var instance: App? = null
    }
    // Здесь идет заполнение таблицы (надо как нибудь по красивее оформить в будущем)

}