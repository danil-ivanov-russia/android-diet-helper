package com.example.diethelperapp.DB2.Models

interface DishesModel {
    var dishesId: Int
    var dishesName: String?
    var protein: Double?  
    var fat: Double?  
    var carbohydrates: Double?  
    var calories: Double?  
    var category: String?  
    var mark: String?  
    var description: String?  
    var linkIngredients: Int
}