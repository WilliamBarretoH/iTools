package com.example.itools.service.retrofit.interfaces

import com.example.itools.model.entity.CategoryProduct
import com.example.itools.model.entity.RequestClient
import io.reactivex.Observable
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("getitens")
    fun getListRequests() : Observable<List<RequestClient>>

    @GET("getcategories")
    fun getListCategories() : Observable<List<CategoryProduct>>
}
