package com.example.diethelperapp.DB2.Models

interface IngredientsModel {
    var ingredientsId: Int
    var ingredientsName: String?  
    var protein: Double?  
    var fat: Double?  
    var carbohydrates: Double?  
    var calories: Double?  
    var measure: String?  
}