package com.example.diethelperapp.retrofit

import com.example.diethelperapp.common.models.DishesModel

interface RetrofitRepository {
    suspend fun loadDishes(): List<DishesModel>
}