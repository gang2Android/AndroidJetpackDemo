package com.gang.jetpackdemo.api

import com.gang.jetpackdemo.bean.ProBean
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "http://api.999000.cn/"
    }

    @GET("api/appdataport/goods/?act=index")
    fun getHomeData(): Deferred<ProBean>
}