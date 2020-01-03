package com.gang.jetpackdemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gang.lib_base.mvvm.BaseViewModel
import com.gang.jetpackdemo.bean.HomeBean

class MainViewModel : BaseViewModel() {

    private val response: MainRepository = MainRepository()

    private val _uiState = MutableLiveData<UIState>()
    val uiState: LiveData<UIState>
        get() = _uiState

    fun getHomeData() {
        if (_uiState.value == null) {
            _uiState.value = UIState(true, null)
        } else {
            if (_uiState.value!!.showLoading) {
                return
            }
        }

        run(
            task = {
                val result = response.getHomeData()
                _uiState.postValue(UIState(false, result))
            },
            error = {
                _uiState.value = UIState(false, null)
            }
        )

    }

    data class UIState(val showLoading: Boolean, val showData: HomeBean?)
}