package com.example.diethelperapp.DB

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WorkWithDB: ViewModel()
{// статики в котлине нет, а здесь бы она пригодилась. стоит поискать лучшее решение

    fun FillTable()
    {
        val db: AppDatabase? = App.instance?.getDatabase()
        val dietDAO: DietDAO? = db?.dietDao()
        var diet: DietDAO.Diet = DietDAO.Diet()
        diet.diet_name = "Гречневая"

        viewModelScope.launch {
            try{
                dietDAO?.insert(diet)
            } catch (t: Throwable){
                print(t.message)
                null
            }
        }
    }
}