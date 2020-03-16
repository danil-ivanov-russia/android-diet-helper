package com.example.diethelperapp.common

import com.example.diethelperapp.db2.AppDatabase
import com.example.diethelperapp.diet.DietRepository
import com.example.diethelperapp.diet.DietRepositoryImplementation
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
}