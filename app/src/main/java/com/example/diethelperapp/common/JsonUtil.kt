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
        setListDietsAndCrossRefDietOwnDishes()
        setListDishes()
       // setCalendarAndCrossRefCalendarWithDishes()
        setIngredients()
        setCrossRefListIngredient()
    }


    private fun getJsonString(fileString: String): String =
            context?.assets?.open(fileString)?.bufferedReader().use {
                it!!.readText()
            }


    // не нравиться мне такой подход, надо бы узнать как сделать лучше
    private fun setListDietsAndCrossRefDietOwnDishes() {
        val obj: DCDiet = Gson().fromJson(getJsonString("Diet.json"), DCDiet::class.java)
        var i = 0;
        for (i in obj.arrayDiet) {
            listDiets?.add(
                    DietDAO.Diet(
                            i.dietId,
                            i.dietName,
                            i.supportingInformation,
                            i.duration
                    )
            )
        }
        for (i in obj.arrayDiet) {
            for (j in i.arrayDishesBelongDiet)
                listCrossRefDietOwnDishes?.add(
                        DietDAO.CrossRefDietOwnDishes(
                                i.dietId,
                                j
                        )
                )
        }


    }

    private fun setListDishes() {
        val obj: DCDishes =
                Gson().fromJson(getJsonString("Dishes.json"), DCDishes::class.java)
        for (i in obj.arrayDishes) {
            listDishes?.add(
                    DietDAO.Dishes(
                            i.dishesId,
                            i.dishesName,
                            i.protein,
                            i.fat,
                            i.carbohydrates,
                            i.calories,
                            i.category,
                            i.mark,
                            i.description,
                            i.amount
                    )
            )
        }

    }



     fun setCalendarAndCrossRefCalendarWithDishes() {
        val obj: DCCalendar =
                Gson().fromJson(getJsonString(chooseCalendarJSON(nameDiet)), DCCalendar::class.java)
        for (i in obj.arrayCalendar) {
            listCalendar?.add(DietDAO.Calendar(i.markDay))
        }

        for (i in obj.arrayCalendar)
            for (j in i.arrayDishes)
                listCrossRefCalendarOwnDishes?.add(DietDAO.CrossRefCalendarOwnDishes(i.markDay, j))


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