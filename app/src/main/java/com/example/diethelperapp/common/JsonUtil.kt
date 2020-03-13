package com.example.diethelperapp.common

import android.content.Context
import com.example.diethelperapp.DB.DietDAO
import com.example.diethelperapp.common.JsonClases.DCLinkDietToDishes
import com.google.gson.Gson

// как это сделать правильно
// объявить пустые коллекции типов таблиц
// сделать функцию получение строки JSON с параметром названия файла
// сделать enum с названиями файлов
// сделать инициализацию ВСЕХ дата классов в отдельной функции
// сделать сеттеры для коллекции классов таблиц с функционалом парсинга из дата класса
// сделать геттеры для коллеций классов таблиц
// и в классе DB_Work просто вызывать нужную коллекцию в insert
// возможно следует сделать класс с этими коллекциями, но пока так все организую.
class JsonUtil(ctx: Context) {
    var listCrossRefDietOwnDishes: MutableCollection<DietDAO.CrossRefDietOwnDishes>? = mutableListOf()
   private var context: Context? = ctx

init {
    val link: DCLinkDietToDishes =
        Gson().fromJson<DCLinkDietToDishes>(getJsonString("MtoM_Diet_Dishes.json"), DCLinkDietToDishes::class.java)
    setListCrossRefDietOwnDishes(link)
}
    private var listLinkDishesToDiet: MutableCollection<DietDAO.CrossRefDietOwnDishes>? = null
    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }

//    fun initListsTables() {
//        val link: DCLinkDietToDishes =
//            Gson().fromJson<DCLinkDietToDishes>(getJsonString("MtoM_Diet_Dishes.json"), DCLinkDietToDishes::class.java)
//        setListCrossRefDietOwnDishes(link)
//    }

    private fun setListCrossRefDietOwnDishes(obj: DCLinkDietToDishes) {
        var i: Int = 0;
        while (i < obj.dietId.size) {
            listCrossRefDietOwnDishes?.add(
                DietDAO.CrossRefDietOwnDishes(
                    obj.dietId[i],
                    obj.dishesId[i]
                )
            )
            i++
        }
    }

}