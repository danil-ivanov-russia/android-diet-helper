package com.example.diethelperapp.common

import android.content.Context
import com.example.diethelperapp.common.jsonClasses.*
import com.example.diethelperapp.db2.DietDAO
import com.google.gson.Gson


class JsonUtil(_ctx: Context) {
    var listCrossRefDietOwnDishes: MutableCollection<DietDAO.CrossRefDietOwnDishes>? =
        mutableListOf()
    var listDiets: MutableCollection<DietDAO.Diet>? = mutableListOf()
    var listDishes: MutableCollection<DietDAO.Dishes>? = mutableListOf()
    var listCrossRefCalendarOwnDishes: MutableCollection<DietDAO.CrossRefCalendarOwnDishes>? =
        mutableListOf()
    var listCalendar: MutableCollection<DietDAO.Calendar>? = mutableListOf()
    var listIngredients: MutableCollection<DietDAO.Ingredients>? = mutableListOf()
    var listCrossRefIngredients: MutableCollection<DietDAO.ListIngredients>? = mutableListOf()
    private var context: Context? = _ctx

    private var nameDiet: String = ""

    constructor(_ctx: Context, _nameDiet: String) : this(_ctx) {
        nameDiet = _nameDiet
    }


    init {
        setListCrossRefDietOwnDishes()
        setListDiets()
        setListDishes()
        setListCrossRefCalendarToDishes()
        setCalendar()
        setIngredients()
        setCrossRefListIngredient()
    }


    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }


    private fun setListCrossRefDietOwnDishes() {
        val obj: DCLinkDietToDishes = Gson().fromJson(
            getJsonString("CrossRefDietToDishes.json"),
            DCLinkDietToDishes::class.java
        )
        var i = 0;
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

    private fun setListDiets() {
        val obj: DCDiet = Gson().fromJson(getJsonString("Diet.json"), DCDiet::class.java)
        var i = 0;
        while (i < obj.dietId.size) {
            listDiets?.add(
                DietDAO.Diet(
                    obj.dietId[i],
                    obj.dietName[i],
                    obj.supportingInformation[i],
                    obj.duration[i]
                )
            )
            i++
        }
    }

    private fun setListDishes() {
        val obj: DCDishes =
            Gson().fromJson(getJsonString("Dishes.json"), DCDishes::class.java)
        var i = 0;
        while (i < obj.dishesId.size) {
            listDishes?.add(
                DietDAO.Dishes(
                    obj.dishesId[i],
                    obj.dishesName[i],
                    obj.protein[i],
                    obj.fat[i],
                    obj.carbohydrates[i],
                    obj.calories[i],
                    obj.category[i],
                    obj.mark[i],
                    obj.description[i],
                    obj.amount[i]
                )
            )
            i++
        }
    }

    private fun setListCrossRefCalendarToDishes() {
        val obj: DCLinkCalendarToDishes = Gson().fromJson(
            getJsonString("CrossRefCalendarToDishes.json"),
            DCLinkCalendarToDishes::class.java
        )
        var i = 0;
        while (i < obj.dishesId.size) {
            listCrossRefCalendarOwnDishes?.add(
                DietDAO.CrossRefCalendarOwnDishes(
                    obj.calendarId[i],
                    obj.dishesId[i]
                )
            )
            i++
        }
    }

    fun setCalendar() {
        val obj: DCCalendar =
            Gson().fromJson(getJsonString(chooseCalendarJSON(nameDiet)), DCCalendar::class.java)
        var i = 0;
        while (i < obj.markDiet.size) {
            listCalendar?.add(
                DietDAO.Calendar(
                    obj.markDiet[i],
                    obj.dayOfWeek[i]


                )
            )
            i++
        }
    }

    private fun setIngredients() {
        val obj: DCIngredients =
            Gson().fromJson(getJsonString("Ingredients.json"), DCIngredients::class.java)
        for (i in obj.arrayIngredients) {
            listIngredients?.add(
                DietDAO.Ingredients(
                    i.ingredientsName,
                    i.protein,
                    i.fat,
                    i.carbohydrates,
                    i.calories

                )
            )
        }
    }

    private fun setCrossRefListIngredient() {
        val obj: DCListIngredients =
            Gson().fromJson(
                getJsonString("ListIngredients.json"),
                DCListIngredients::class.java
            )
        for (j in obj.arrayDishesWithIngredients) {
            listCrossRefIngredients?.add(
                DietDAO.ListIngredients(j.ingredientId, j.ingredientsCount, j.dishesId)
            )
        }
    }

    private fun chooseCalendarJSON(nameDiet: String): String = when (nameDiet) {
        "Гречневая диета" -> "CalendarBuckwheat.json"
        "Белковая диета" -> "CalendarProtein.json"
        "Диета парижанки" -> "CalendarParis.json"
        else -> "CalendarBuckwheat.json"
    }


}