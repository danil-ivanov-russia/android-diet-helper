package com.example.diethelperapp.dietplan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.databinding.ListItemDayBinding

class DietPlanAdapter(_daysList: List<DietPlanRepository.DietPlanDay>, _viewModel: DietPlanViewModel):
    RecyclerView.Adapter<DietPlanAdapter.DietPlanViewHolder>() {
    var daysList:List<DietPlanRepository.DietPlanDay> = _daysList
    var viewModel = _viewModel

    override fun getItemCount() = daysList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):DietPlanViewHolder {
        val dietBinding = ListItemDayBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return DietPlanViewHolder(dietBinding)
    }
    override fun onBindViewHolder(holder: DietPlanViewHolder, position: Int) {
        /*
        when (position) {
            0 -> holder.dietBinding.dayName = "Понедельник"
            1 -> holder.dietBinding.dayName = "Вторник"
            2 -> holder.dietBinding.dayName = "Среда"
            3 -> holder.dietBinding.dayName = "Четверг"
            4 -> holder.dietBinding.dayName = "Пятница"
            5 -> holder.dietBinding.dayName = "Суббота"
            6 -> holder.dietBinding.dayName = "Воскресенье"
        }*/
        holder.dietBinding.dayNumber = position
        holder.dietBinding.viewModel = viewModel

        holder.dietBinding.breakfastRecyclerView.layoutManager = LinearLayoutManager(holder.dietBinding.breakfastRecyclerView.context)
        //holder.dietBinding.breakfastRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 0)

        holder.dietBinding.lunchRecyclerView.layoutManager = LinearLayoutManager(holder.dietBinding.lunchRecyclerView.context)
        //holder.dietBinding.lunchRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 1)

        holder.dietBinding.dinnerRecyclerView.layoutManager = LinearLayoutManager(holder.dietBinding.dinnerRecyclerView.context)
        //holder.dietBinding.dinnerRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 2)

        holder.dietBinding.otherRecyclerView.layoutManager = LinearLayoutManager(holder.dietBinding.otherRecyclerView.context)
        //holder.dietBinding.otherRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 3)

        holder.dietBinding.breakfastRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 0)
        holder.dietBinding.lunchRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 1)
        holder.dietBinding.dinnerRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 2)
        holder.dietBinding.otherRecyclerView.adapter = DietPlanDayAdapter(daysList, viewModel, position, 3)

        holder.dietBinding.breakfastRecyclerView.setRecycledViewPool(RecyclerView.RecycledViewPool())
        holder.dietBinding.lunchRecyclerView.setRecycledViewPool(RecyclerView.RecycledViewPool())
        holder.dietBinding.dinnerRecyclerView.setRecycledViewPool(RecyclerView.RecycledViewPool())
        holder.dietBinding.otherRecyclerView.setRecycledViewPool(RecyclerView.RecycledViewPool())
    }
    class DietPlanViewHolder(val dietBinding: ListItemDayBinding): RecyclerView.ViewHolder(dietBinding.root){

    }


}