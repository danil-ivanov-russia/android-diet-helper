package com.example.diethelperapp.retrofit

import com.example.diethelperapp.common.models.DishesModel

class RetrofitRepositoryImplementation( private val api: DishesModel): RetrofitRepository {
    override suspend fun loadDishes(): List<DishesModel> {
        TODO("Not yet implemented")
    }
}