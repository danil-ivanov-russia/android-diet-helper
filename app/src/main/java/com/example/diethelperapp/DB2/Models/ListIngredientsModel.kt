package com.example.diethelperapp.db2.models

interface ListIngredientsModel {
    var ownDishesId: Int
    var linkIngredientsId: Int
    var ingredientsCount: Int?
    var ingredientsName: String?
}