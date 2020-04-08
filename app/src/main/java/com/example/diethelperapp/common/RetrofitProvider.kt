package com.example.diethelperapp.common


import com.example.diethelperapp.common.models.DishesModel
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider{
    private val retrofitCities = Retrofit
        .Builder()
        .baseUrl(Constans.Api_Dishes)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    fun dishes(): DishesModel = retrofitCities.create(DishesModel::class.java)
}