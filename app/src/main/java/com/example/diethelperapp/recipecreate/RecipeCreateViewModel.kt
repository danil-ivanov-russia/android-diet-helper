package com.example.diethelperapp.recipecreate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.db2.DietDAO
import kotlinx.coroutines.launch

class RecipeCreateViewModel(
    private val repository: RecipeCreateRepository,
    private val navigator: RecipeCreateClickNavigator
) : ViewModel() {

    private var _allIngredientsList: List<DietDAO.Ingredients>? = null
        set(value) {
            field = value
            (allIngredientsList as MutableLiveData).postValue(value)
        }
    val allIngredientsList: MutableLiveData<List<DietDAO.Ingredients>> = MutableLiveData()

    private var _thisIngredientsList: MutableList<DietDAO.Ingredients>? = mutableListOf<DietDAO.Ingredients>()
        set(value) {
            field = value
            (thisIngredientsList as MutableLiveData).postValue(value)
        }
    val thisIngredientsList: MutableLiveData<List<DietDAO.Ingredients>> = MutableLiveData()

    private var _customRecipe: DietDAO.Dishes? = null
        set(value) {
            field = value
            (customRecipe as MutableLiveData).postValue(value)
        }
    val customRecipe: MutableLiveData<DietDAO.Dishes> = MutableLiveData()

    private var _customRecipeName: String? = null
        set(value) {
            field = value
            (customRecipeName as MutableLiveData).postValue(value)
        }
    val customRecipeName: MutableLiveData<String> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    var selectedIngredient: DietDAO.Ingredients?= null

    init {
        viewModelScope.launch {
            val allIngredientsList: List<DietDAO.Ingredients>? = try {
                repository.loadIngredients()
            } catch (t: Throwable) {
                print(t.message)
                null
            }

            _isLoading = false
            allIngredientsList?.let { _allIngredientsList = it }
        }
    }

    fun toIngredientList(){
        navigator.onIngredientAddClick()
    }

    fun chooseIngredient(id: Int){
        viewModelScope.launch {
            _thisIngredientsList?.add(repository.getIngredientById(id))
            _thisIngredientsList = _thisIngredientsList
            navigator.onIngredientChooseClick()
        }
    }

    fun removeIngredient(position: Int){
        _thisIngredientsList?.remove(_thisIngredientsList!![position])
        _thisIngredientsList = _thisIngredientsList

    }

}