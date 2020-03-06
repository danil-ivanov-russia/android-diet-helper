package com.example.diethelperapp.dietList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.databinding.ListItemDietBinding

class DietListAdapter(_dietsNamesList: List<DietModel>, _viewModel: DietListViewModel):RecyclerView.Adapter<DietListAdapter.DietListViewHolder>() {
    var dietsNamesList:List<DietModel> = _dietsNamesList
    var viewModel = _viewModel

    override fun getItemCount() = dietsNamesList.size

    override fun onCreateViewHolder( viewGroup:ViewGroup, i:Int):DietListViewHolder {
        val dietBinding = ListItemDietBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return DietListViewHolder(dietBinding)
    }
    override fun onBindViewHolder(holder: DietListViewHolder, position: Int) {
        holder.dietBinding.dietName = dietsNamesList[position].diet_name
        holder.dietBinding.dietId = dietsNamesList[position].id_diet
        holder.dietBinding.viewModel = viewModel

    }
    class DietListViewHolder(val dietBinding: ListItemDietBinding):RecyclerView.ViewHolder(dietBinding.root){

        }


}