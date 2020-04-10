package com.example.diethelperapp.recipecreate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.databinding.ListItemRecipecreateIngredientBinding

class RecipeCreateIngredientsAdapter(var ingredientsList: List<IngredientWithAmount>, var viewModel: RecipeCreateViewModel):
    RecyclerView.Adapter<RecipeCreateIngredientsAdapter.RecipeCreateIngredientListViewHolder>() {

    override fun getItemCount() = ingredientsList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int):RecipeCreateIngredientListViewHolder {
        val ingredientBinding = ListItemRecipecreateIngredientBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return RecipeCreateIngredientListViewHolder(ingredientBinding)
    }

    class RecipeCreateIngredientListViewHolder(val ingredientBinding: ListItemRecipecreateIngredientBinding): RecyclerView.ViewHolder(ingredientBinding.root){
    }

    override fun onBindViewHolder(holder: RecipeCreateIngredientListViewHolder, position: Int) {
        holder.ingredientBinding.viewModel = viewModel
        holder.ingredientBinding.ingredientName = ingredientsList[position].ingredient.ingredientsName
        holder.ingredientBinding.ingredientListPosition = position
    }

}