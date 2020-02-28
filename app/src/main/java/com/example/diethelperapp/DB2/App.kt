package com.example.diethelperapp.DB

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase
import com.example.diethelperapp.common.DaggerRepositoryComponent
import com.example.diethelperapp.common.RepositoryComponent
import com.example.diethelperapp.common.RepositoryModel


class App : Application() {
    private var database: AppDatabase? = null
    private var db_work: WorkWithDB? = null


    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        repositories = DaggerRepositoryComponent
            .builder()
            .appDatabase(database)
            .repositoryModel(RepositoryModel())
            .build()
        db_work = WorkWithDB()
        // где то здесь надо бы сделать проверку на наличие данных в базе, чтобы заново таблицы не заполнять
        // причем они должны отличаться от предпологаемой замены
        // причем проверка должна идти во всех таблицах
        // или к черту эту проверку?
        db_work!!.fillTable()
        db_work!!.getLogs()
    }
    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object {
        lateinit var repositories: RepositoryComponent
            private set
        var instance: App? = null
    }


}