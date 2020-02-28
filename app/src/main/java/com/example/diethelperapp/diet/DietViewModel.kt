package com.example.diethelperapp.diet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.recipe.RecipeRepository
import kotlinx.coroutines.launch

class DietViewModel(
private val dietId: Int,
private val repository: DietRepository
): ViewModel() {
    private var _diet: DietModel? = null
    set(value) {
        field = value
        (diet as MutableLiveData).postValue(value)
    }
    val diet: LiveData<DietModel> = MutableLiveData()

    private var _isLoading = true
    set(value) {
        field = value
        (isLoading as MutableLiveData).postValue(value)
    }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
            val diet: DietModel? = try{
                repository.getCertainDietById(dietId)
            } catch (t: Throwable){
                print(t.message)
                null
            }

            _isLoading = false
            diet?.let {_diet = it}
        }
    }
}