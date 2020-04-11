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


    private var _thisIngredientsList: MutableList<IngredientWithAmount>? =
        mutableListOf<IngredientWithAmount>()
        set(value) {
            field = value
            (thisIngredientsList as MutableLiveData).postValue(value)
        }
    val thisIngredientsList: MutableLiveData<MutableList<IngredientWithAmount>> = MutableLiveData()

    /*
        private var _customRecipeName: String? = null
            set(value) {
                field = value
                (customRecipeName as MutableLiveData).postValue(value)
            }
        val customRecipeName: MutableLiveData<String> = MutableLiveData()

        private var _customRecipeDescription: String? = ""
            set(value) {
                field = value
                (customRecipeDescription as MutableLiveData).postValue(value)
            }
        val customRecipeDescription: MutableLiveData<String> = MutableLiveData()

     */
    var customRecipe: DietDAO.Dishes? = null

    val customRecipeName = MutableLiveData<String>()

    val customRecipeDescription = MutableLiveData<String>()

    private var _customRecipeCalories: Double? = 0.0
        set(value) {
            field = value
            (customRecipeCalories as MutableLiveData).postValue(value)
        }
    val customRecipeCalories: MutableLiveData<Double> = MutableLiveData()

    private var _customRecipeProtein: Double? = 0.0
        set(value) {
            field = value
            (customRecipeProtein as MutableLiveData).postValue(value)
        }
    val customRecipeProtein: MutableLiveData<Double> = MutableLiveData()

    private var _customRecipeFat: Double? = 0.0
        set(value) {
            field = value
            (customRecipeFat as MutableLiveData).postValue(value)
        }
    val customRecipeFat: MutableLiveData<Double> = MutableLiveData()

    private var _customRecipeCarbohydrate: Double? = 0.0
        set(value) {
            field = value
            (customRecipeCarbohydrate as MutableLiveData).postValue(value)
        }
    val customRecipeCarbohydrate: MutableLiveData<Double> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    var selectedIngredient: DietDAO.Ingredients? = null

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
            calculateNutrition()
        }
    }


    fun calculateNutrition() {
        _customRecipeCalories =
            _thisIngredientsList!!.sumByDouble { it.ingredient.calories!! * it.amount.toDouble() / 100.0 }
        _customRecipeProtein =
            _thisIngredientsList!!.sumByDouble { it.ingredient.protein!! * it.amount.toDouble() / 100.0 }
        _customRecipeFat =
            _thisIngredientsList!!.sumByDouble { it.ingredient.fat!! * it.amount.toDouble() / 100.0 }
        _customRecipeCarbohydrate =
            _thisIngredientsList!!.sumByDouble { it.ingredient.carbohydrates!! * it.amount.toDouble() / 100.0 }
    }

    fun chooseIngredient(id: String) {
        viewModelScope.launch {
            _thisIngredientsList?.add(
                IngredientWithAmount(
                    "100.0",
                    repository.getIngredientByName(id)
                )
            )
            _thisIngredientsList = _thisIngredientsList
            calculateNutrition()
            navigator.onIngredientChooseClick()
        }
    }

    fun removeIngredient(position: Int) {
        _thisIngredientsList?.remove(_thisIngredientsList!![position])
        _thisIngredientsList = _thisIngredientsList
        calculateNutrition()
    }

    fun createRecipe() {
        calculateNutrition()
        viewModelScope.launch {
            customRecipeName.value?.let {
                customRecipe = DietDAO.Dishes(
                    0,
                    it,
                    _customRecipeProtein!!,
                    _customRecipeFat!!,
                    _customRecipeCarbohydrate!!,
                    _customRecipeCalories!!,
                    "Пользовательская",
                    mutableListOf("Завтрак", "Обед", "Ужин", "Перекус"),
                    customRecipeDescription.value ?: "",
                    1
                )
            }
            customRecipe?.let {
                repository.addRecipeToDatabase(it)
            }

        }
    }
}

class IngredientWithAmount(
    var amount: String = "100.0",
    var ingredient: DietDAO.Ingredients
)