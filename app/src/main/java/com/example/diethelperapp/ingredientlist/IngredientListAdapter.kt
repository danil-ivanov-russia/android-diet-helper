package com.example.diethelperapp.ingredientlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.databinding.ListItemIngredientBinding
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.recipecreate.RecipeCreateViewModel

class IngredientListAdapter(var ingredientsList: List<DietDAO.Ingredients>, var viewModel: RecipeCreateViewModel):
    RecyclerView.Adapter<IngredientListAdapter.IngredientListViewHolder>() {

    override fun getItemCount() = ingredientsList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):IngredientListViewHolder {
        val ingredientBinding = ListItemIngredientBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return IngredientListViewHolder(ingredientBinding)
    }

    class IngredientListViewHolder(val ingredientBinding: ListItemIngredientBinding): RecyclerView.ViewHolder(ingredientBinding.root){

    }

    override fun onBindViewHolder(holder: IngredientListAdapter.IngredientListViewHolder, position: Int) {
        holder.ingredientBinding.viewModel = viewModel
        holder.ingredientBinding.ingredientName = ingredientsList[position].ingredientsName
    }


}