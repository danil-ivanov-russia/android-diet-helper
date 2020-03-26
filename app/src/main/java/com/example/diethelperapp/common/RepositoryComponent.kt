package com.example.diethelperapp.common

import com.example.diethelperapp.db2.AppDatabase
import com.example.diethelperapp.diet.DietRepository
import com.example.diethelperapp.dietplan.DietPlanRepository
import com.example.diethelperapp.recipecreate.RecipeCreateRepository
import dagger.Component

@Component(

    dependencies = [AppDatabase::class],
    modules = [RepositoryModel::class]
)

abstract class RepositoryComponent
{
    abstract fun diet(): DietRepository

    abstract fun calendar(): DietPlanRepository

    abstract fun recipeCreate(): RecipeCreateRepository
}