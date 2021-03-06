package com.example.diethelperapp.dietplan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.databinding.ListItemDayRecipeBinding

class DietPlanDayAdapter(var daysList: List<DietPlanRepository.DietPlanDay>, var viewModel: DietPlanViewModel, var day: Int, var timeOfDay: Int):
    RecyclerView.Adapter<DietPlanDayAdapter.DayViewHolder>() {

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
        holder.dayBinding.viewModel = viewModel
        when(timeOfDay){
            0 -> holder.dayBinding.recipeName = daysList[day].breakfastList[position].dishesName
            1 -> holder.dayBinding.recipeName = daysList[day].lunchList[position].dishesName
            2 -> holder.dayBinding.recipeName = daysList[day].dinnerList[position].dishesName
            3 -> holder.dayBinding.recipeName = daysList[day].otherList[position].dishesName
        }

    }

    class  DayViewHolder(val dayBinding: ListItemDayRecipeBinding): RecyclerView.ViewHolder(dayBinding.root){

    }



}