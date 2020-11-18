package com.example.itools.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.itools.model.entity.RequestClient
import com.example.itools.service.retrofit.RetrofitService
import com.example.itools.ui.adapter.RequestInProgressAdapter
import com.example.itools.ui.adapter.RequestPendingAdapter
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class EmployeeRequestsViewModel(
    var retrofitService: RetrofitService,
    var requestPendingAdapter: RequestPendingAdapter,
    var requestInProgressAdapter: RequestInProgressAdapter) : ViewModel() {


    fun getRequestList(){
        retrofitService.getRquestList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.i("LISTAAAAAAAAAAAAAA", "getRequestList: ${it}")
                this.requestPendingAdapter.setRequestList(it)
                this.requestInProgressAdapter.setRequestList(it)


            }){
                Log.i("ERROOOOR", "getRequestList:${it} ")
            }
    }
}