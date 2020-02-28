package com.example.diethelperapp.DB

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase
import com.example.diethelperapp.DB2.Models.DietModel
import kotlinx.coroutines.launch

class WorkWithDB: ViewModel()
{// Первоначальное заполнение БД.

    fun fillTable()
    {
        val db: AppDatabase? = App.instance?.getDatabase()
        val dietDAO: DietDAO? = db?.getDietDAO()
        // По рабоче крестьянски.
        // Сделать коллекцию, в нее добавить эти элементы.
        // В корутине сделать цикл и просто исполнять insert с разными объектами.
        // Не очень способ, но для начала сойдет.

        var diets: MutableCollection<DietDAO.Diet> = mutableListOf()
        diets.add(DietDAO.Diet(0,"Гречневая","Принцип гречневой диеты заключается в питании в течение недели или двух одной лишь гречкой.",7))
        diets.add(DietDAO.Diet(1,"Белковая","Отлично подходит для быстрого снижения веса, а также при активных тренировках.",14))
        diets.add(DietDAO.Diet(2,"Диета парижанки","Простой метод сбалансированного питания, основанный на медицинских знаниях и приспособленный к современному образу жизни",23))
        viewModelScope.launch {
            try{
                for (i in diets)
                {
                    dietDAO?.insert(i)

                }

            } catch (t: Throwable){
                print(t.message)
            }
        }
    }
    fun getLogs()
    {
        val db: AppDatabase? = App.instance?.getDatabase()
        val dietDAO: DietDAO? = db?.getDietDAO()
        var test: String
        viewModelScope.launch {
            try{

                if (dietDAO != null) {
                    test = dietDAO.getNameCertainDiet(1).toString()

                }
            } catch (t: Throwable){
                print(t.message)
            }
        }

    }
}