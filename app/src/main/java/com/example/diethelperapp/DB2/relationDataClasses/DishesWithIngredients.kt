package com.example.diethelperapp.db2.relationDataClasses

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.diethelperapp.db2.DietDAO

data class DishesWithIngredients(
    @Embedded val Dishes: DietDAO.Dishes,
    @Relation(
        parentColumn = "dishesId",
        entityColumn = "ingredientsId",
        associateBy = Junction(DietDAO.ListIngredients::class)
    )
    val Ingredients: List<DietDAO.Ingredients>

   // @Embedded(prefix = "li") val Count: DietDAO.ListIngredients

)