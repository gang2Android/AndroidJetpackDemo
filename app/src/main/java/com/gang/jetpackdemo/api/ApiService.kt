package com.gang.jetpackdemo.api

import com.gang.jetpackdemo.bean.HomeBean
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://wanandroid.com/"
    }

    @GET("article/listproject/0/json")
    fun getHomeData(): Deferred<HomeBean>
}