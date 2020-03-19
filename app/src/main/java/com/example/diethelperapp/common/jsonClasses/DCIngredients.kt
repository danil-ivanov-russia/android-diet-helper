package com.example.diethelperapp.common.jsonClasses

data class DCIngredients (
    var ingredientsId: Array<Int>,
    var ingredientsName: Array<String>,
    var protein: Array<Double>,
    var fat: Array<Double>,
    var carbohydrates: Array<Double>,
    var calories: Array<Double>

)
