package com.example.diethelperapp.dietList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diethelperapp.diet.DietRepository
import kotlinx.coroutines.launch

class DietListViewModel(
    private val repository: DietRepository
): ViewModel() {
    private var _dietsNames: List<String>? = null
        set(value) {
            field = value
            (dietsNames as MutableLiveData).postValue(value)
        }
    val dietsNames: MutableLiveData<List<String>> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

//    init {
//        viewModelScope.launch {
//            val dietsNames: List<String>? = try{
//                repository.getAllNameDiets()
//            } catch (t: Throwable){
//                print(t.message)
//                null
//            }
//
//            _isLoading = false
//            dietsNames?.let {_dietsNames = it}
//        }
//    }
}