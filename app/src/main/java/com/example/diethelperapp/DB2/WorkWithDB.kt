package com.example.diethelperapp.DB

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.AppDatabase
import com.example.diethelperapp.common.JsonUtil
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
    fun fillTable(context: Context)
    {
        // По рабоче крестьянски.
        // Сделать коллекцию, в нее добавить эти элементы.
        // В корутине сделать цикл и просто исполнять insert с разными объектами.
        // Не очень способ, но для начала сойдет.
        val tmp: JsonUtil = JsonUtil(context)
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
                DB_work?.insertCrossRef(tmp.listCrossRefDietOwnDishes)
            } catch (t: Throwable){
                print(t.message)
            }
        }






    }
    fun getLogs()
    {
        var test:List<DietDAO.CrossRefDietOwnDishes>?
        var tmpTest: List<DietDAO.Diet>?
        viewModelScope.launch {
            try{
                  test = DB_work?.getCrossRef()
               tmpTest = DB_work?.getAllDiet()

            } catch (t: Throwable){
                print(t.message)
            }
        }

    }
}

/*ANTLR Tool version 4.5.3 used for code generation does not match the current runtime version 4.7.1ANTLR Runtime version 4.5.3 used for parser compilation does not match the current runtime version 4.7.1ANTLR Tool version 4.5.3 used for code generation does not match the current runtime version 4.7.1ANTLR Runtime version 4.5.3 used for parser compilation does not match the current runtime version 4.7.1
D:\NEW_FOLDER_SINCE_ROOM\JohnyProjects\ArcadiaProjects\android-diet-helper\app\build\tmp\kapt3\stubs\debug\com\example\diethelperapp\DB\DietDAO.java:60: error: com.example.diethelperapp.DB.DietDAO is part of com.example.diethelperapp.DB2.AppDatabase but this entity is not in the database. Maybe you forgot to add com.example.diethelperapp.DB.DietDAO.Dishes to the entities section of the @Database?
    public abstract java.lang.Object insertCrossRef(@org.jetbrains.annotations.NotNull()*/