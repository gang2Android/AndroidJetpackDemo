package com.gang.jetpackdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<VM : BaseViewModel>(viewModelClass: Class<VM>) : AppCompatActivity() {

    protected var mViewModel: VM? = ViewModelProvider.NewInstanceFactory().create(viewModelClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        mViewModel?.let {
            lifecycle.addObserver(it)
        }

        initView()
        initListener()
    }

    override fun onDestroy() {
        mViewModel?.let {
            lifecycle.removeObserver(it)
        }
        super.onDestroy()
    }

    abstract fun initView()

    abstract fun initListener()

    abstract fun getLayoutId(): Int
}