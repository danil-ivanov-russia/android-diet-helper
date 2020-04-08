package com.example.diethelperapp.common.dagger.providers

import com.example.diethelperapp.common.RetrofitProvider
import com.example.diethelperapp.common.dagger.modules.RetrofitModule
import com.example.diethelperapp.retrofit.RetrofitRepository
import dagger.Component

class RetrofitComponent {
    @Component(
        dependencies = [
            RetrofitProvider::class
        ],
        modules = [
            RetrofitModule::class
        ]
    )
    abstract class RepositoryComponent {
        abstract fun retrofitRepository(): RetrofitRepository
    }

}