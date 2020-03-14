package com.example.diethelperapp.common.JsonClases

data class DCDishes(
    var dishesId: Array<Int>,
    var dishesName: Array<String>,
    var protein: Array<Double>,
    var fat: Array<Double>,
    var carbohydrates: Array<Double>,
    var calories: Array<Double>,
    var category: Array<String>,
    var mark: Array<String>,
    var description: Array<String>,
    var linkIngredients: Array<Int>

)
