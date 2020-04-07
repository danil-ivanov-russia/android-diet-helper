package com.example.diethelperapp.common.jsonClasses


data class DCDishes(
    val arrayDishes: Array<CertainDishes>
)
data class CertainDishes(
    var dishesId: Int,
    var dishesName: String,
    var protein: Double,
    var fat: Double,
    var carbohydrates: Double,
    var calories: Double,
    var category: String,
    var mark: MutableList<String>,
    var description: String,
    var amount: Int
)

