package com.example.diethelperapp.common.dagger.modules

import com.example.diethelperapp.common.RetrofitProvider
import com.example.diethelperapp.retrofit.RetrofitRepository
import com.example.diethelperapp.retrofit.RetrofitRepositoryImplementation
import dagger.Module
import dagger.Provides

@Module
class RetrofitModule {
    @Provides
    fun retrofitRepository(
        api: RetrofitProvider
    ): RetrofitRepository = RetrofitRepositoryImplementation(
        api = api.dishes()
    )
}