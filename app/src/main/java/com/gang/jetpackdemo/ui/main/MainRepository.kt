package com.gang.jetpackdemo.ui.main

import com.gang.jetpackdemo.api.RetrofitClient
import com.gang.jetpackdemo.base.BaseRepository
import com.gang.jetpackdemo.bean.HomeBean

class MainRepository : BaseRepository() {
    suspend fun getHomeData(): HomeBean {
        return RetrofitClient.service.getHomeData().await()
    }
}