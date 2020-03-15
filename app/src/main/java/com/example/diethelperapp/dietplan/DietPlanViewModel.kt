package com.example.diethelperapp.dietplan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DietPlanViewModel(
    private val dietId: String,
    private val repository: DietPlanRepository,
    var navigator: DietPlanButtonClickNavigator
): ViewModel() {
    private var _dietPlan: List<DietPlanRepository.DietPlanDay>? = null
        set(value) {
            field = value
            (dietPlan as MutableLiveData).postValue(value)
        }
    val dietPlan: MutableLiveData<List<DietPlanRepository.DietPlanDay>> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
            val dietsNames: List<DietPlanRepository.DietPlanDay>? = try{
                repository.loadDietPlan(dietId)
            } catch (t: Throwable){
                print(t.message)
                null
            }

            _isLoading = false
            dietsNames?.let {_dietPlan = it}
        }
    }

    fun addRecipe(day: Int, timeOfDay: Int){
        navigator.onRecipeAddClick(day, timeOfDay)
    }


    fun removeRecipe(day: Int, timeOfDay: Int){
        //тут убирать в базе?
        navigator.onRecipeRemoveClick(day, timeOfDay)
    }

    fun replaceRecipe(day: Int, timeOfDay: Int){
        navigator.onRecipeReplaceClick(day, timeOfDay)
    }

}