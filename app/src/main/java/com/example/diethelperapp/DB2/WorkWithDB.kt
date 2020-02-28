package com.example.diethelperapp.DB

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase
import kotlinx.coroutines.launch

class WorkWithDB: ViewModel()
{// Первоначальное заполнение БД.

    fun fillTable()
    {
        val db: AppDatabase? = App.instance?.getDatabase()
        val dietDAO: DietDAO? = db?.getDietDAO()
        var diet: DietDAO.Diet = DietDAO.Diet()
        diet.diet_name = "Гречневая"
        diet.supporting_information = "Тест информация для Гречневое диеты"

        viewModelScope.launch {
            try{
                dietDAO?.insert(diet)
            } catch (t: Throwable){
                print(t.message)
            }
        }
    }
}