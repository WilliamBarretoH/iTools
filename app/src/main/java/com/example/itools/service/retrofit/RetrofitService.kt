package com.example.itools.service.retrofit

import com.example.itools.model.entity.CategoryProduct
import com.example.itools.model.entity.RequestClient
import com.example.itools.service.retrofit.interfaces.RetrofitInterface
import io.reactivex.Observable

class RetrofitService(var retrofitFactory: RetrofitFactory) {

    private var retrofitInit : RetrofitInterface

    init {
        this.retrofitInit = retrofitFactory.getRetrofitInterface()
    }

    fun getRquestList() : Observable<List<RequestClient>> {
        return retrofitInit.getListRequests()
    }

    fun getCategoriesList() : Observable<List<CategoryProduct>>{
        return retrofitInit.getListCategories()
    }

}