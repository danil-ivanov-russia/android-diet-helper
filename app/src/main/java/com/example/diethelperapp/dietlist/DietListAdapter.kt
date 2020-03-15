package com.example.diethelperapp.dietlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.databinding.ListItemDietBinding

class DietListAdapter(var dietsNamesList: List<DietModel>, var viewModel: DietListViewModel):RecyclerView.Adapter<DietListAdapter.DietListViewHolder>() {

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
        holder.dietBinding.dietName = dietsNamesList[position].dietName
        holder.dietBinding.dietId = dietsNamesList[position].dietId
        holder.dietBinding.viewModel = viewModel

    }
    class DietListViewHolder(val dietBinding: ListItemDietBinding):RecyclerView.ViewHolder(dietBinding.root){

        }


}