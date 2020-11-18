package com.example.itools.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itools.R
import com.example.itools.model.entity.CategoryProduct

class CategoriesAdapter(var context: Context) :
    RecyclerView.Adapter<CategoriesAdapter.CategorieViewHolder>(){

    companion object var categoriesList = arrayListOf<CategoryProduct>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return CategorieViewHolder(view)

    }

    fun setCategoriesList(categories : List<CategoryProduct>){
        categoriesList.addAll(categories)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategorieViewHolder, position: Int) {
        var category = categoriesList.get(position)
        holder.bind(category)

    }

    inner class CategorieViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        var nameCategory : TextView
        var descriptionCategory : TextView

        fun bind(categoryProduct: CategoryProduct){
            nameCategory.text = categoryProduct.CategoryName
            descriptionCategory.text = categoryProduct.CategoryDescription
        }

        init {
            nameCategory = itemView.findViewById(R.id.category_name_text)
            descriptionCategory = itemView.findViewById(R.id.category_description_text)
        }
    }

}
