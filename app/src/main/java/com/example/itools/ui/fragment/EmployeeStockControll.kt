package com.example.itools.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.itools.R
import com.example.itools.ui.adapter.CategoriesAdapter
import com.example.itools.ui.viewmodel.EmployeeStockControllViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeStockControll : Fragment() {

    private lateinit var recyclerViewCategory : RecyclerView

    private val categoriesAdapter by inject<CategoriesAdapter>()

    val employeeStockControllViewModel : EmployeeStockControllViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        employeeStockControllViewModel.getCategoriesList()

        recyclerViewCategory = view.findViewById(R.id.categories_list_view)

        recyclerViewCategory.adapter = categoriesAdapter



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_stock_categories, container, false)
    }

}