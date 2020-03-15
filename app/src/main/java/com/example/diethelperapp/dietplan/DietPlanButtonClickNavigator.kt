package com.example.diethelperapp.dietplan

interface DietPlanButtonClickNavigator {
    fun onRecipeAddClick(day: Int, timeOfDay: Int)

    fun onRecipeRemoveClick(day: Int, timeOfDay: Int)

    fun onRecipeReplaceClick(day: Int, timeOfDay: Int)

}