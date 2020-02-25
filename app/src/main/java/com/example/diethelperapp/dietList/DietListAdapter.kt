package com.example.diethelperapp.dietList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.R
import com.example.diethelperapp.databinding.ListItemDietBinding

class DietListAdapter(_dietsNamesList: List<String>):RecyclerView.Adapter<DietListAdapter.DietListViewHolder>() {
    var dietsNamesList:List<String> = _dietsNamesList
    //var onDietClickListener: OnDietClickListener = _onDietClickListener

    override fun getItemCount() = dietsNamesList.size

    override fun onCreateViewHolder( viewGroup:ViewGroup, i:Int):DietListViewHolder {
        val dietBinding = ListItemDietBinding.inflate(LayoutInflater.from(viewGroup.context),
            viewGroup, false)
        return DietListViewHolder(dietBinding)
    }
    override fun onBindViewHolder(holder: DietListViewHolder, position: Int) {
        holder.dietBinding.dietName = dietsNamesList[position]

    }
    fun setEmployeeList(_dietsNamesList: List<String>) {
        this.dietsNamesList = _dietsNamesList
        notifyDataSetChanged()
    }
    class DietListViewHolder(val dietBinding: ListItemDietBinding):RecyclerView.ViewHolder(dietBinding.root){

        }

/*
    public interface OnDietClickListener{
        abstract var navController: NavController
        fun onDietClick( position: Int)
    }
    */

}