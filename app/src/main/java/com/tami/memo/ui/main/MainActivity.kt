package com.tami.memo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.tami.memo.R
import com.tami.memo.base.MemoActivity
import com.tami.memo.common.EventObserver
import com.tami.memo.databinding.ActivityMainBinding
import com.tami.memo.ui.insert.InsertActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : MemoActivity() {

    lateinit var bb: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bb.apply {
            lifecycleOwner = this@MainActivity
            vm = this@MainActivity.vm
        }
        initLiveData()
    }

    private fun initLiveData() {
        vm.goInsert.observe(this, EventObserver {
            startActivity(InsertActivity.getIntent(this))
        })
    }
}