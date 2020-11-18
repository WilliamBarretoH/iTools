package com.example.itools.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.itools.service.retrofit.RetrofitService
import com.example.itools.ui.adapter.CategoriesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EmployeeStockControllViewModel(
    var retrofitService: RetrofitService,
    var categoriesAdapter: CategoriesAdapter)
    : ViewModel() {

    fun getCategoriesList() {
        retrofitService.getCategoriesList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                this.categoriesAdapter.setCategoriesList(it)
            })
    }
}