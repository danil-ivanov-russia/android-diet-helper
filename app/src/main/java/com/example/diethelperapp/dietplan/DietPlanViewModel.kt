package com.example.diethelperapp.dietplan

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DietPlanViewModel(
        private val dietId: Int,
        private val repository: DietPlanRepository,
        var navigator: DietPlanButtonClickNavigator,
        private val ctx: Context?
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
            val dietPlan: List<DietPlanRepository.DietPlanDay>? = try{
                if (ctx != null) {
                    repository.fillCalendar(dietId,ctx)
                    repository.setCalendar()
                }
                repository.loadDietPlan()
            } catch (t: Throwable){
                print(t.message)
                null
            }

            _isLoading = false
            dietPlan?.let {_dietPlan = it}
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

    fun calculateWeeklyNutrition(): Nutrition{
        var calories = 0.0
        var protein = 0.0
        var fat = 0.0
        var carbohydrate = 0.0
        for (i in 0..6){
            calories += calculateDailyNutrition(i).calories
            protein += calculateDailyNutrition(i).protein
            fat += calculateDailyNutrition(i).fat
            carbohydrate += calculateDailyNutrition(i).carbohydrate
        }
        return Nutrition(calories, protein, fat, carbohydrate)
    }

    fun calculateDailyNutrition(day: Int): Nutrition {
        val calories: Double = _dietPlan?.get(day)?.breakfastList!!.sumByDouble { it.calories } +
                _dietPlan?.get(day)?.lunchList!!.sumByDouble { it.calories } +
                _dietPlan?.get(day)?.dinnerList!!.sumByDouble { it.calories } +
                _dietPlan?.get(day)?.otherList!!.sumByDouble { it.calories }
        val protein: Double = _dietPlan?.get(day)?.breakfastList!!.sumByDouble { it.protein } +
                _dietPlan?.get(day)?.lunchList!!.sumByDouble { it.protein } +
                _dietPlan?.get(day)?.dinnerList!!.sumByDouble { it.protein } +
                _dietPlan?.get(day)?.otherList!!.sumByDouble { it.protein }
        val fat: Double = _dietPlan?.get(day)?.breakfastList!!.sumByDouble { it.fat } +
                _dietPlan?.get(day)?.lunchList!!.sumByDouble { it.fat } +
                _dietPlan?.get(day)?.dinnerList!!.sumByDouble { it.fat } +
                _dietPlan?.get(day)?.otherList!!.sumByDouble { it.fat }
        val carbohydrate: Double = _dietPlan?.get(day)?.breakfastList!!.sumByDouble { it.carbohydrates } +
                _dietPlan?.get(day)?.lunchList!!.sumByDouble { it.carbohydrates } +
                _dietPlan?.get(day)?.dinnerList!!.sumByDouble { it.carbohydrates } +
                _dietPlan?.get(day)?.otherList!!.sumByDouble { it.carbohydrates }
        return Nutrition(calories, protein, fat, carbohydrate)
    }

    class Nutrition(
        val calories: Double,
        val protein: Double,
        val fat: Double,
        val carbohydrate: Double
    )


}