package com.example.diethelperapp.DB

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase


class App : Application() {
    private var database: AppDatabase? = null
    private var db_work: WorkWithDB? = null


    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        db_work = WorkWithDB()
        if (db_work!!.getCountLines()>0)
        {


        }
        db_work!!.fillTable()
        db_work!!.getLogs()

    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object {
        var instance: App? = null
    }


}