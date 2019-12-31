package com.gang.jetpackdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initView()
        initListener()
    }

    abstract fun initView()

    abstract fun initListener()

    abstract fun getLayoutId(): Int
}