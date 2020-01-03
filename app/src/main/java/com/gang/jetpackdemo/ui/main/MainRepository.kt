package com.gang.jetpackdemo.ui.main

import com.gang.jetpackdemo.api.RetrofitClient
import com.gang.lib_base.mvvm.BaseRepository
import com.gang.jetpackdemo.bean.HomeBean

class MainRepository : BaseRepository() {
    suspend fun getHomeData(): HomeBean {
        return RetrofitClient.service.getHomeData().await()
    }
}