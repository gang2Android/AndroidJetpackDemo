package com.gang.jetpackdemo.base

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.lang.Exception

open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val mLaunchManager: MutableList<Job> = mutableListOf()

    fun run(
        task: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.() -> Unit
    ) {
        val job = GlobalScope.launch(Dispatchers.IO) {
            try {
                task()
            } catch (ex: Exception) {
                Log.e("BaseViewModel", "${ex.message}")
                error()
            }
        }
        mLaunchManager.add(job)
        job.invokeOnCompletion { mLaunchManager.remove(job) }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        mLaunchManager.clear()
    }

}
