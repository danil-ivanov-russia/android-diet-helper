package com.example.diethelperapp.common

import com.example.diethelperapp.DB2.AppDatabase
import com.example.diethelperapp.diet.DietRepository
import dagger.Component

@Component(

    dependencies = [AppDatabase::class],
    modules = [RepositoryModel::class]
)

abstract class RepositoryComponent
{
    abstract fun diet(): DietRepository
}