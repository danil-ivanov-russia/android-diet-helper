package com.example.diethelperapp.DB

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase
import com.example.diethelperapp.common.JsonUtil
import kotlinx.coroutines.launch

class WorkWithDB : ViewModel() {// Первоначальное заполнение БД.
init {
    val db: AppDatabase? = App.instance?.getDatabase()
    val dietDAO: DietDAO? = db?.getDietDAO()
    DB_work = dietDAO
}

    companion object {
        var DB_work: DietDAO? = null
    }

    fun getCountLines(): Int {
        var count: Int = 0
        viewModelScope.launch {
            try {
                count = DB_work!!.getCountLines()

            } catch (t: Throwable) {
                print(t.message)
            }
        }
        return count
    }

    fun fillTable(context: Context) {
        val tmp:JsonUtil = JsonUtil(context)
        viewModelScope.launch {
            try {
                DB_work?.insertDiets(tmp.listDiets)
                DB_work?.insertCrossRef(tmp.listCrossRefDietOwnDishes)
            } catch (t: Throwable) {
                print(t.message)
            }
        }
    }

    fun getLogs() {
        var test: List<DietDAO.CrossRefDietOwnDishes>?
        var tmpTest: List<DietDAO.Diet>?
        viewModelScope.launch {
            try {
                test = DB_work?.getCrossRef()
                tmpTest = DB_work?.getAllDiet()

            } catch (t: Throwable) {
                print(t.message)
            }
        }

    }
}