package com.example.diethelperapp.common

import android.content.Context
import com.example.diethelperapp.DB.DietDAO
import com.example.diethelperapp.common.JsonClases.DCDiet
import com.example.diethelperapp.common.JsonClases.DCDishes
import com.example.diethelperapp.common.JsonClases.DCLinkDietToDishes
import com.google.gson.Gson


class JsonUtil(ctx: Context) {
    var listCrossRefDietOwnDishes: MutableCollection<DietDAO.CrossRefDietOwnDishes>? =
        mutableListOf()
    var listDiets: MutableCollection<DietDAO.Diet>? = mutableListOf()
    var listDishes: MutableCollection<DietDAO.Dishes>? = mutableListOf()

    private var context: Context? = ctx

    // получше бы сделать, много дублирующего кода
    init {
        setListCrossRefDietOwnDishes()
        setListDiets()
        setListDishes()
    }

    private fun getJsonString(fileString: String): String =
        context?.assets?.open(fileString)?.bufferedReader().use {
            it!!.readText()
        }


    private fun setListCrossRefDietOwnDishes() {
        val obj: DCLinkDietToDishes = Gson().fromJson<DCLinkDietToDishes>(
            getJsonString("MtoM_Diet_Dishes.json"),
            DCLinkDietToDishes::class.java
        )
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

    private fun setListDiets() {
        val obj: DCDiet = Gson().fromJson<DCDiet>(getJsonString("Diet.json"), DCDiet::class.java)
        var i: Int = 0;
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
            Gson().fromJson<DCDishes>(getJsonString("Dishes.json"), DCDishes::class.java)
        var i: Int = 0;
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
                    obj.linkIngredients[i]

                )
            )
            i++
        }
    }

}