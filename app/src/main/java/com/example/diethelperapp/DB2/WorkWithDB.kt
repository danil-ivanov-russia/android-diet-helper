package com.example.diethelperapp.DB

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase
import kotlinx.coroutines.launch

class WorkWithDB: ViewModel()
{// Первоначальное заполнение БД.
    init {
        val db: AppDatabase? = App.instance?.getDatabase()
        val dietDAO: DietDAO? = db?.getDietDAO()
        DB_work = dietDAO
    }
    companion object
    {
        var DB_work: DietDAO? = null
    }
    fun getCountLines(): Int
    {
        var  count: Int = 0
        viewModelScope.launch {
            try{
                    count = DB_work!!.getCountLines()

            } catch (t: Throwable){
                print(t.message)
            }
        }
        return count
    }
    fun fillTable()
    {
        // По рабоче крестьянски.
        // Сделать коллекцию, в нее добавить эти элементы.
        // В корутине сделать цикл и просто исполнять insert с разными объектами.
        // Не очень способ, но для начала сойдет.
        var diets: MutableCollection<DietDAO.Diet> = mutableListOf()
        diets.add(DietDAO.Diet(0,"Гречневая","Принцип гречневой диеты заключается в питании в течение недели или двух одной лишь гречкой.",7))
        diets.add(DietDAO.Diet(1,"Белковая","Отлично подходит для быстрого снижения веса, а также при активных тренировках.",14))
        diets.add(DietDAO.Diet(2,"Диета парижанки","Простой метод сбалансированного питания, основанный на медицинских знаниях и приспособленный к современному образу жизни. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",23))
        viewModelScope.launch {
            try{
                for (i in diets)
                {
                    DB_work?.insert(i)
                }
            } catch (t: Throwable){
                print(t.message)
            }
        }
    }
    fun getLogs()
    {
        var test: List<DietDAO.Diet>
        viewModelScope.launch {
            try{
                    test = DB_work!!.getAllDiet()

            } catch (t: Throwable){
                print(t.message)
            }
        }

    }
}