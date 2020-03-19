package com.example.diethelperapp.db2.models



interface DishesModel {
    var dishesId: Int
    var dishesName: String
    var protein: Double  
    var fat: Double  
    var carbohydrates: Double  
    var calories: Double  
    var category: String
    var mark: MutableList<String>
    var description: String  
    var amount: Int
}