package com.example.diethelperapp.recipelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.db2.models.DishesModel
import kotlinx.coroutines.launch

class RecipeListViewModel(
    private val repository: RecipeListRepository,
    var navigator: RecipeListClickNavigator
) : ViewModel() {
    private var _recipesNames: List<DishesModel>? = null
        set(value) {
            field = value
            (recipesNames as MutableLiveData).postValue(value)
        }
    val recipesNames: MutableLiveData<List<DishesModel>> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    private var _isUserRecipes = false
        set(value) {
            field = value
            (isUserRecipes as MutableLiveData).postValue(value)
        }
    val isUserRecipes: LiveData<Boolean> = MutableLiveData(_isUserRecipes)

    init {
        viewModelScope.launch {
            val recipesNames: List<DishesModel>? = try {
                repository.loadStandartRecipes()
            } catch (t: Throwable) {
                print(t.message)
                null
            }

            _isLoading = false
            _isUserRecipes = false
            recipesNames?.let { _recipesNames = it }
        }
    }

    fun toCreateRecipe(){
        navigator.onRecipeCreateClick()
    }

    fun selectStandartRecipes(){
        viewModelScope.launch {
            val recipesNames: List<DishesModel>? = try {
                repository.loadStandartRecipes()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            _isLoading = false
            _isUserRecipes = false
            recipesNames?.let { _recipesNames = it }
        }
    }

    fun selectUserRecipes(){
        viewModelScope.launch {
            _isLoading = true
            val recipesNames: List<DishesModel>? = try {
                repository.loadUserRecipes()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            _isLoading = false
            _isUserRecipes = true
            recipesNames?.let { _recipesNames = it }
        }
    }

    fun selectWebRecipes(){
        viewModelScope.launch {
            _isLoading = true
            val recipesNames: List<DishesModel>? = try {
                repository.loadRecipesFromWeb()
            } catch (t: Throwable) {
                print(t.message)
                null
            }
            _isLoading = false
            _isUserRecipes = false
            recipesNames?.let { _recipesNames = it }
        }
    }


}