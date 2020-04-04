package com.example.diethelperapp.common.jsonClasses

data class DCIngredients(

    val array: Array<tmpIngredient>
)

data class tmpIngredient(
    val ingredientsName: String,
    val protein: Double,
    val fat: Double,
    val carbohydrates: Double,
    val calories: Double
)
