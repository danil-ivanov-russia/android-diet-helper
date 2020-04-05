package com.example.diethelperapp.db2.relationDataClasses

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.example.diethelperapp.db2.DietDAO

data class OneToOneListToIngredient(
    @Embedded val List: DietDAO.ListIngredients,
    @Relation(
        parentColumn = "ingredientId",
        entityColumn = "ingredientsName"
    )
    val Ingredient: DietDAO.Ingredients
)