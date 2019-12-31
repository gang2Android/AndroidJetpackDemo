package com.gang.jetpackdemo.ui.main

import com.gang.jetpackdemo.api.RetrofitClient
import com.gang.jetpackdemo.bean.ProBean

class MainRepository {
    suspend fun getHomeData(): ProBean {
        return RetrofitClient.service.getHomeData().await()
    }
}