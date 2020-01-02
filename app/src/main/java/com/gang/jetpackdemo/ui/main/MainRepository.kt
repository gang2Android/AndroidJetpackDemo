package com.gang.jetpackdemo.ui.main

import com.gang.jetpackdemo.api.RetrofitClient
import com.gang.jetpackdemo.bean.HomeBean

class MainRepository {
    suspend fun getHomeData(): HomeBean {
        return RetrofitClient.service.getHomeData().await()
    }
}