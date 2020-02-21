package com.example.diethelperapp.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val recipeId: String,
    private val repository: RecipeRepository
): ViewModel() {
    private var _recipe: RecipeRepository.Recipe? = null
        set(value) {
            field = value
            (recipe as MutableLiveData).postValue(value)
        }
    val recipe: LiveData<RecipeRepository.Recipe> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
            val recipe: RecipeRepository.Recipe? = try{
                repository.loadRecipe(recipeId)
            } catch (t: Throwable){
                print(t.message)
                null
            }

            _isLoading = false
            recipe?.let {_recipe = it}
        }
    }
}