package com.example.diethelperapp.db2.models

interface IngredientsModel {
    var ingredientsId: Int
    var ingredientsName: String?  
    var protein: Double?  
    var fat: Double?  
    var carbohydrates: Double?  
    var calories: Double?  
    var measure: String?  
}