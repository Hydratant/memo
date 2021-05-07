package com.tami.memo.ui.main

import androidx.activity.viewModels
import com.tami.memo.R
import com.tami.memo.base.BindingActivity
import com.tami.memo.common.EventObserver
import com.tami.memo.databinding.MainActBinding
import com.tami.memo.ui.insert.InsertActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<MainActBinding>(R.layout.main_act) {

    private val vm: MainViewModel by viewModels()
    override fun onLoadOnce() {
        bb.vm = vm
        vm.goInsert.observe(this, EventObserver {
            startActivity(InsertActivity.getIntent(this))
        })
    }
}