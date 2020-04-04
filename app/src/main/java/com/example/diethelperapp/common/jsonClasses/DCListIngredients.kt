package com.example.diethelperapp.common.jsonClasses

//data class DCListIngredients (
//    val ownDishesId: Array<Int>,
//    val ingredientsName: Array<String>?,
//    val protein: Array<Double?>,
//    val fat: Array<Double?>,
//    val carbohydrates: Array<Double?>,
//    val calories: Array<Double?>,
//    val ingredientsCount: Array<Int?>
//)
data class DCListIngredients(
    val array: Array<tmp>
)
data class tmp(
    val ingredientId : String,
    val ingredientsCount : Int,
    val dishesId : Int
)