package com.example.itools

import com.example.itools.service.retrofit.RetrofitFactory
import com.example.itools.service.retrofit.RetrofitService
import com.example.itools.ui.adapter.CategoriesAdapter
import com.example.itools.ui.adapter.RequestInProgressAdapter
import com.example.itools.ui.adapter.RequestPendingAdapter
import com.example.itools.ui.listener.OnItemClickListener
import com.example.itools.ui.viewmodel.EmployeeStockControllViewModel
import com.example.itools.ui.viewmodel.EmployeeRequestsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RequestPendingAdapter(get()) }

    single { RequestInProgressAdapter(get())}

    single { CategoriesAdapter(get())}

    single { RetrofitFactory() }

    factory { RetrofitService(get()) }

}

val viewModelModule = module {
    viewModel { EmployeeRequestsViewModel(get(), get(), get()) }
    viewModel { EmployeeStockControllViewModel(get(), get()) }

}