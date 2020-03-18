package com.example.diethelperapp.db2

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.common.JsonUtil
import com.example.diethelperapp.db2.relationDataClasses.CalendarWithDishes
import com.example.diethelperapp.db2.relationDataClasses.DietWithDishes
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
        val tmp: JsonUtil = JsonUtil(context)
        viewModelScope.launch {
            try {
                DB_work?.insertDiets(tmp.listDiets)
                DB_work?.insertCrossRefDietWithDishes(tmp.listCrossRefDietOwnDishes)
                DB_work?.insertDishes(tmp.listDishes)
                DB_work?.insertCalendar(tmp.listCalendar)
                DB_work?.insertCrossRefCalendarWithDishes(tmp.listCrossRefCalendarOwnDishes)


            } catch (t: Throwable) {
                print(t.message)
            }
        }
    }

    fun getLogs() {
        var diet: List<DietDAO.Diet>?
        var testD: List<DietDAO.Dishes>?
        var testC: List<DietDAO.CrossRefCalendarOwnDishes>?
        var tmpTest: List<CalendarWithDishes>?

        viewModelScope.launch {
            try {
                diet = DB_work?.getAllDiet()
                testC = DB_work?.getCrossRefCalendarWithDishes()
                testD = DB_work?.getAllDishes()
                tmpTest = DB_work?.getCalendar()


            } catch (t: Throwable) {
                print(t.message)
            }
        }

    }
}