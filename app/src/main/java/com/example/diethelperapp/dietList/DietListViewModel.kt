package com.example.diethelperapp.dietList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.diet.DietRepository
import kotlinx.coroutines.launch

class DietListViewModel(
    private val repository: DietRepository,
    private val navigator: DietListItemClickNavigator
): ViewModel() {
    private var _dietsNames: List<DietModel>? = null
        set(value) {
            field = value
            (dietsNames as MutableLiveData).postValue(value)
        }
    val dietsNames: MutableLiveData<List<DietModel>> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
            val dietsNames: List<DietModel>? = try{
                repository.getAllDiet()
            } catch (t: Throwable){
                print(t.message)
                null
            }

            _isLoading = false
            dietsNames?.let {_dietsNames = it}
        }
    }

    fun itemClick(id: Int) {
        navigator.onItemClick(id)
    }

}