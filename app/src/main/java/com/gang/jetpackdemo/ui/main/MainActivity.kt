package com.gang.jetpackdemo.ui.main

import android.util.Log
import androidx.lifecycle.Observer
import com.gang.jetpackdemo.R
import com.gang.jetpackdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>(MainViewModel::class.java) {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
    }

    override fun initListener() {
        mViewModel?.apply {
            uiState.observe(this@MainActivity, Observer {
                if (it.showLoading)
                    Log.e("111", "loading----1")
                else
                    Log.e("111", "loading----2")

                if (it.showData == null) {
                    Log.e("111", "data====null")
                } else {
                    Log.e("111", "data====" + it.showData.toString())
                    main_tv.text = it.showData.toString()
                }
            })
        }

        mViewModel?.getHomeData()
    }

}
