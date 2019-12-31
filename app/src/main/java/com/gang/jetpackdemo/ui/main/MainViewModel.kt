package com.gang.jetpackdemo.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gang.jetpackdemo.bean.ProBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(val response: MainRepository) : ViewModel() {

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

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = response.getHomeData()
                _uiState.postValue(UIState(false, result))
            } catch (ex: Exception) {
                _uiState.value = UIState(false, null)
            }
        }
    }

    data class UIState(val showLoading: Boolean, val showData: ProBean?)

    class MainViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(MainRepository()) as T
        }
    }
}