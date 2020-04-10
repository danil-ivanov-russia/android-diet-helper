package com.example.diethelperapp.common

import com.example.diethelperapp.db2.AppDatabase
import com.example.diethelperapp.diet.DietRepository
import com.example.diethelperapp.diet.DietRepositoryImplementation
import com.example.diethelperapp.dietplan.DietPlanRepository
import com.example.diethelperapp.dietplan.DietPlanRepositoryImplementation
import com.example.diethelperapp.recipecreate.RecipeCreateRepository
import com.example.diethelperapp.recipecreate.RecipeCreateRepositoryImplementation
import com.example.diethelperapp.recipelist.RecipeListRepository
import com.example.diethelperapp.recipelist.RecipeListRepositoryImplementation
import dagger.Module
import dagger.Provides
@Module
class RepositoryModel
{
    @Provides
    fun dietList(
        dao: AppDatabase
    ): DietRepository = DietRepositoryImplementation(
        dao = dao.getDietDAO()
    )

    @Provides
    fun calendar(
        dao: AppDatabase
    ): DietPlanRepository = DietPlanRepositoryImplementation(
        dao = dao.getDietDAO()
    )

    @Provides
    fun recipeCreate(
        dao: AppDatabase
    ): RecipeCreateRepository = RecipeCreateRepositoryImplementation(
        dao = dao.getDietDAO()
    )

    @Provides
    fun recipeList(
        dao: AppDatabase
    ): RecipeListRepository = RecipeListRepositoryImplementation(
        dao = dao.getDietDAO()
    )
}