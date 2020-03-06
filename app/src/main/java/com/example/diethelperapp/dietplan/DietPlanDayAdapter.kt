package com.example.diethelperapp.dietplan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.databinding.ListItemDayRecipeBinding

class DietPlanDayAdapter(_daysList: List<DietPlanRepository.DietPlanDay>, _viewModel: DietPlanViewModel, _day: Int, _timeOfDay: Int):
    RecyclerView.Adapter<DietPlanDayAdapter.DayViewHolder>() {
    var daysList:List<DietPlanRepository.DietPlanDay> = _daysList
    var viewModel = _viewModel
    var day = _day
    var timeOfDay = _timeOfDay

    //override fun getItemCount() = daysList.size

    override fun getItemCount() =  when(timeOfDay){
        0 -> daysList[day].breakfastList.size
        1 -> daysList[day].lunchList.size
        2 -> daysList[day].dinnerList.size
        3 -> daysList[day].otherList.size
        else -> daysList[day].otherList.size
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):DayViewHolder {
        val dayBinding = ListItemDayRecipeBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return DayViewHolder(dayBinding)
    }
    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        when(timeOfDay){
            0 -> holder.dayBinding.recipeName = daysList[day].breakfastList[position].recipeId
            1 -> holder.dayBinding.recipeName = daysList[day].lunchList[position].recipeId
            2 -> holder.dayBinding.recipeName = daysList[day].dinnerList[position].recipeId
            3 -> holder.dayBinding.recipeName = daysList[day].otherList[position].recipeId
        }

        //holder.
        //holder.dietBinding.dietName = dietsNamesList[position].diet_name
        //holder.dietBinding.dietId = dietsNamesList[position].id_diet
        //holder.dietBinding.viewModel = viewModel

    }

    class  DayViewHolder(val dayBinding: ListItemDayRecipeBinding): RecyclerView.ViewHolder(dayBinding.root){

    }



}