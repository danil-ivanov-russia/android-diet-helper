package com.example.diethelperapp.common

import com.example.diethelperapp.db2.AppDatabase
import com.example.diethelperapp.diet.DietRepository
import com.example.diethelperapp.diet.DietRepositoryImplementation
import com.example.diethelperapp.dietplan.DietPlanRepository
import com.example.diethelperapp.dietplan.DietPlanRepositoryImplementation
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
}