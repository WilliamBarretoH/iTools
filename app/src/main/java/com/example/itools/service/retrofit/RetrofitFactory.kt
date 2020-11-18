package com.example.itools.service.retrofit

import com.example.itools.service.retrofit.interfaces.RetrofitInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private var retrofit: Retrofit? = null

    init {
        if (retrofit == null) {
            retrofit =
                Retrofit.Builder()
                    .baseUrl("https://a0a44017-f579-4949-a913-1d371c0fb639.mock.pstmn.io/")
                    .client(OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }

    private fun getRetrofit(): Retrofit? {
        return retrofit
    }

    fun getRetrofitInterface(): RetrofitInterface {
        return getRetrofit()!!.create(
            RetrofitInterface::class.java
        )
    }
}