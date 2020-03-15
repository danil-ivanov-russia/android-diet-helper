package com.example.diethelperapp.recipelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.DB2.Models.DishesModel
import com.example.diethelperapp.databinding.ListItemRecipeBinding

class RecipeListAdapter(var recipesList: List<DishesModel>, var viewModel: RecipeListViewModel):
    RecyclerView.Adapter<RecipeListAdapter.DietListViewHolder>() {

    override fun getItemCount() = recipesList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DietListViewHolder {
        val recipeBinding = ListItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DietListViewHolder(recipeBinding)
    }


    override fun onBindViewHolder(holder: DietListViewHolder, position: Int) {
        holder.recipeBinding.recipeName = viewModel.recipesNames.value?.get(position)?.dishesName
    }

    class DietListViewHolder(val recipeBinding: ListItemRecipeBinding):RecyclerView.ViewHolder(recipeBinding.root){

    }


}